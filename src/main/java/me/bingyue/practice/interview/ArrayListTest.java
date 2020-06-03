package me.bingyue.practice.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @Title: ArrayListTest 
 * @Description: TODO
 */
public class ArrayListTest {

	public static void main(String[] args){
		ArrayList<Object> list=new ArrayList();
		for(int i=0;i<10000;i++){
			list.add(i);
		}
		useIterator(list);
		useRandomAccess(list);
		useForeach(list);
	}
	
	public static void useIterator(List<Object> list){
		Long startTime = System.currentTimeMillis();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
		    iter.next();
		}
		System.out.println(System.currentTimeMillis()-startTime);
	}
	
    public static void useRandomAccess(List<Object> list){
    	Long startTime = System.currentTimeMillis();
    	for (int i=0; i<list.size(); i++) {
    		list.get(i);
    		}
		System.out.println(System.currentTimeMillis()-startTime);
	}
    
    public static void useForeach(List<Object> list){
    	
    	Long startTime = System.currentTimeMillis();
    	for (Object obj:list) {
    		     ;
    	}
		System.out.println(System.currentTimeMillis()-startTime);
	}
}
