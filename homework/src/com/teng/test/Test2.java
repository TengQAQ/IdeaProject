package com.teng.test;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        int[] arr;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        arr = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字:");
            int a = scanner.nextInt();
            arr[i] = a;
            count += a;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("这个数组里的数之和："+count);

    }
}
