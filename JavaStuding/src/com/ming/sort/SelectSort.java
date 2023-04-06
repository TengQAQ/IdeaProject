package com.ming.sort;

public class SelectSort extends BaseSort {
    @Override
    void sort(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            for (int j = i + 1; j < ints.length - 1; j++) {
                int min = i;
                if ( ints[i] < ints[j] ){
                    min = j;
                }
                if (min != i){
                    ints[i] = ints[i] ^ ints[min];
                    ints[min] = ints[i] ^ ints[min];
                    ints[i] = ints[i] ^ ints[min];
                }
            }
        }
    }
}
