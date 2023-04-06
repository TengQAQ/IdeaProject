package com.teng.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        text1();
    }
    static void text1(){
        Scanner scanner = new Scanner(System.in);
        int[] arr = {50,15,95,8546,548};
        int[] temp;
        System.out.println("请输入删除的数");
        int a = scanner.nextInt();
        temp = arr;
        arr = new int[arr.length - 1];
        for (int i = 0,j = 0; i <temp.length ; i++) {
            if (temp[i] == a){
                System.out.println("找到了");
            }else {
                arr[j] = temp[i];
                j++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
