package com.teng.test;

import java.util.Scanner;

public class XunHuan{
    public static void main(String[] args){
        PanDuan();
    }

    void HuiWenShu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("判断回文数");
        System.out.println("请输入一个数字");
        String a = scanner.next();
        int b = a.length();
        boolean flag = true;
        if (b%2 == 0){
            for (int i = 0; i < b / 2; i++) {
                if (a.charAt(i) == a.charAt(b - i - 1)){
                    System.out.println(i);
                }else {
                    flag = false;
                    break;
                }
            }
        }else {
            for (int i = 0; i < b / 2 ; i++) {
                if (a.charAt(i) == a.charAt(b - i - 1)){
                    System.out.println(i);
                }else {
                    flag = false;
                    break;
                }
            }
        }
        if (flag == true){
            System.out.println(a+"是水回文数");
        }else {
            System.out.println(a+"不是水回文数");
        }
    }

    static int week(int y, int m, int d)
    {
        int num = 0;
        if(m == 1 || m == 2) {
            m += 12;
            y--;
        }
        int a = y%100;
        int b = y-a*100;
        num = (a/4) - 2*a + b + (b/4) + (13*(m+1)/5) + d - 1;
        return num%7;
    }


    public static void PanDuan(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入年：");
        int year = scanner.nextInt();
        System.out.println("请输入月份");
        int month = scanner.nextInt();
        System.out.println("请输入天数");
        int day = scanner.nextInt();
        int c = week(year,month,day);
        System.out.println(c);
    }
}