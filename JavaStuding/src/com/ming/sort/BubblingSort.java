package com.ming.sort;

public class BubblingSort extends BaseSort {
    @Override
    void sort(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints.length - 1; j++) {
                if ( ints[j] > ints[j+1] ){
                    ints[j] = ints[j] ^ ints[j + 1];
                    ints[j + 1] = ints[j] ^ ints[j + 1];
                    ints[j] = ints[j] ^ ints[j + 1];
                }
            }
        }
    }
}
