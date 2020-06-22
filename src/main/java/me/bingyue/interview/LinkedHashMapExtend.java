package me.bingyue.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExtend extends LinkedHashMap {

    private int cacheSize;

    public LinkedHashMapExtend(int cacheSize){
        super();
        this.cacheSize=cacheSize;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry eldest) {

        if(size()>cacheSize){
            return true;
        }
        return false;
    }


    public static void main(String[] args){

        LRUCache lruCache=new LRUCache(2);
        lruCache.set(1,111);
        lruCache.set(2,222);
        lruCache.set(3,333);
        System.out.println("ele:"+lruCache.get(3));
        System.out.println("ele:"+lruCache.get(1));

    }

}
