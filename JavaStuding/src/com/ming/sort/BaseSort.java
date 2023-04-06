package com.ming.sort;

abstract class BaseSort {

     abstract void sort(int[] ints);

     public void starsort(int[] ints){
         Long star = System.currentTimeMillis();
         sort(ints);
         Long end = System.currentTimeMillis();
         System.out.println(end - star + "毫秒");
     }

}
