package com.teng.test;

import java.util.Random;
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        int[] arr;
        int flag1 = -1;
        arr = new int[5];
        Random random = new Random();
        for (int j = 0; j < arr.length;){
            int a =  random.nextInt(10) + 1;
            for (int i = 0; i < j; i++) {
                 if (a == arr[i]){
                        flag1 = 0;
                        break;
                }
            }
            if (flag1 == -1){
                arr[j] = a;
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }

    }
}
