package me.bingyue.interview;

import java.io.File;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 用java 多线程实现 cat /home/admin/logs/*.log | grep "Login" | uniq -c |sort -nr
 * 遍历目录下文件，查找含有"Login"关键词的行并输出， 显示每行出现的次数，根据次数按照从小到大顺序排序
 */
public class CommandRealize {

	public static final String FILE_PATH = "/Users/bingyue/log";
	public static final String SURFEX = ".log";

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		try {

			List<ReadCallable> callables = new LinkedList<ReadCallable>();
			List<Future> futures = new LinkedList<Future>();

			File file = new File(FILE_PATH);
			File[] listfile = file.listFiles();

			for (int i = 0; i < listfile.length; i++) {
				if (!listfile[i].isDirectory()) {
					File f = listfile[i];
					String path = f.getAbsolutePath();

					if (path != null && path.indexOf(SURFEX) >-1) {
						ReadCallable callable = new ReadCallable(f.getAbsolutePath());
						callables.add(callable);
					}
				}
			}

			ExecutorService pool = Executors.newCachedThreadPool();

			for (ReadCallable c : callables) {
				Future f = pool.submit(c);
				futures.add(f);
			}

			pool.shutdown();

			Map<String, Integer> result = new HashMap<String, Integer>();

			for (Future f : futures) {
				result.putAll((Map) f.get());
			}
			
			for (Entry<String, Integer> entry : result.entrySet()) {
				System.out.println(entry.getKey() + " "+ entry.getValue());
			}

			ValueComparator comparable = new ValueComparator(result);

			TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(comparable);
			sorted_map.putAll(result);

			for (String sortedkey : sorted_map.keySet()) {
				System.out.println(result.get(sortedkey) + " " + sortedkey);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	static class ValueComparator implements Comparator<String> {
		Map<String, Integer> base_map;

		public ValueComparator(Map<String, Integer> map) {
			this.base_map = map;
		}

		public int compare(String arg0, String arg1) {
			if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
				return 0;
			}
			// 按照value从大到小排序
			if (base_map.get(arg0) < base_map.get(arg1)) {
				return 1;
			} else if (base_map.get(arg0) == base_map.get(arg1)) {
				return 0;
			} else {
				return -1;
			}
		}

	}

}
