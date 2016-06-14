package me.bingyue.daily.jdknotes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

/**
 * 针对HashMap的value进行排序 
 * @author Bingyue
 */
public class HashMapSort {

	public static void main(String[] args) {
        
        HashMap<String, Integer> map = new HashMap<String, Integer>(){{
            put("tom", 18);
            put("jack", 25);
            put("susan", 20);
            put("rose", 38);
        }};
         
        ValueComparator cmptor = new ValueComparator(map);
         
        /**
         * 转换为有序的TreeMap进行输出
         */
        TreeMap<String, Integer> sorted_map = new TreeMap<String, Integer>(cmptor);
        sorted_map.putAll(map);
         
        for(String sortedkey : sorted_map.keySet()){
            System.out.println(sortedkey+map.get(sortedkey));
        }
 
//        Collections.sort(list);
//          Collections.sort(list, c);
        
        
        /**
         * 转换为有序的list进行排序
         */
        List<String> keys = new ArrayList<String>(map.keySet());
        Collections.sort(keys, cmptor);
        for(String key : keys) {
        	 System.out.println(key+map.get(key));
        }
    }
 
    static class ValueComparator implements Comparator<String> {
        HashMap<String, Integer> base_map;
 
        public ValueComparator(HashMap<String, Integer> base_map) {
            this.base_map = base_map;
        }
 
        public int compare(String arg0, String arg1) {
            if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
                return 0;
            }
 
            if (base_map.get(arg0) < base_map.get(arg1)) {
                return -1;
            } else if (base_map.get(arg0) == base_map.get(arg1)) {
                return 0;
            } else {
                return 1;
            }
        }
    }
}
