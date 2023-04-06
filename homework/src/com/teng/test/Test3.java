package com.teng.test;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        int[] arr;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请问需要多少个数？");
        int b = scanner.nextInt();
        arr = new int[b];
        for (int i = 0; i < b; i++) {
            System.out.println("请输入第" + (i + 1) + "个数字:");
            int a = scanner.nextInt();
            arr[i] = a;
            count += a;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("平均数：："+count / b);

    }
}
