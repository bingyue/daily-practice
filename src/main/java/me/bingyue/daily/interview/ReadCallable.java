package me.bingyue.daily.interview;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

public class ReadCallable implements Callable<Map<String, Integer>> {

	Map<String, Integer> map = new HashMap<String, Integer>();

	private static String filePath;

	public ReadCallable(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public Map<String, Integer> call() {
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;

		try {
			fis = new FileInputStream(filePath);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);

			while (br.readLine() != null) {
				String line = br.readLine();

				if (line != null && line.indexOf("Login") > -1) {
					if (map.containsKey(line)) {
						Integer count = map.get(line);
						map.put(line, count++);
					} else {
						map.put(line, 1);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				isr.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return map;
	}

}
