package com.ming.arraylist;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo{
    public static void main(String[] args) {
        Map<Integer,String> hashMap = new HashMap<Integer, String>();
        hashMap.put(0,"秦腾辉");
        hashMap.put(1,"黎协");
        hashMap.put(2,"王欣俊");
        if (hashMap.containsKey(0)){
            System.out.println(hashMap.get(0));
        }
    }
}
