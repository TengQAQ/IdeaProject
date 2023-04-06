package com.ming.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List list =new ArrayList<>();//调用无参构造方法
        list.add(1);
        int[] ints = {1,2,6,64,34};

        int[] a= new int[10];
        for (int i = 0; i < ints.length; i++) {
            a[i] = ints[i];
        }
        //需要被复制的数组，复制数组的开始下标，目标数组，目标数组的开始下标，复制长度
        System.arraycopy(ints,0,a,5,ints.length);
//        for (int x:a) {
//            System.out.print(x + ",");
//        }
        list.iterator();
    }
}
