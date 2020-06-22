package me.bingyue.jdknotes;

import java.util.Collection;
import java.util.Set;

/**
 * @Title: Map 接口
 * @Description: TODO
 */
public interface Map<K,V> {
	public static interface Entry<K,V> {
		//获取该Entry的key 
		public abstract Object getKey();
		//获取该Entry的value
		public abstract Object getValue();
		//设置Entry的value  
		public abstract Object setValue(Object obj);
		public abstract boolean equals(Object obj);
		public abstract int hashCode();
	}
	
	//返回键值对的数目  
	int size();
	//判断容器是否为空  
	boolean isEmpty();
	//判断容器是否包含关键字key  
	boolean containsKey(Object key);
	//判断容器是否包含值value 
	boolean containsValue(Object value);
	 //根据key获取value  
	Object get(Object key);
	 //向容器中加入新的key-value对  
	Object put(Object key, Object value);
	//根据key移除相应的键值对  
	Object remove(Object key);
	//将另一个Map中的所有键值对都添加进去  
	void putAll(Map<? extends K, ? extends V> m);
	//清除容器中的所有键值对  
	void clear();
	//返回容器中所有的key组成的Set集合  
	Set keySet();
	//返回所有的value组成的集合  
	Collection values();
	 //返回所有的键值对  
	Set<Map.Entry<K, V>> entrySet();
	
	//继承自Object的方法
	boolean equals(Object obj);
	int hashCode();
}
