package com.ming.homework;


import com.ming.Model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HomeWork {
    /**
     * 将一个字符串集合中的所有英文字母转换为大写
     */
    public void test1(){
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e", "f");
        Stream stream = Stream.of(strings);
        stream.map(i -> {
            return i.toString().toUpperCase();
                })
                .forEach( str -> System.out.println("1.输出结果" + str));
    }

    /**
     * 对数组中的每个数求平方后输出
     */
    public static void test2(){
        int[] ints = {1, 2, 3, 4};
        Arrays.stream(ints)
                .map(i->{
                    return i*i;
                })
                .forEach( str -> System.out.println("2.输出结果" + str));
    }

    /**
     * 输出数组中所有的奇数
     */
    public static void test3(){
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
//        Stream stream = Stream.of(ints);
        Arrays.stream(ints)
                .filter(i-> (i&1) == 1)
                .forEach(System.out::println);
    }

    /**
     * 输出所有的Student对象的姓名
     */
    public static void test4(){
        List<Student> students = Arrays.asList(
                new Student(1, 20, "张三"),
                new Student(2, 20, "李四"),
                new Student(3, 20, "王五"),
                new Student(4, 20, "赵六")
        );
        students.stream()
                .forEach(students1 -> System.out.println(students1.getName()));
    }

    public static void main(String[] args) {
        HomeWork homeWork = new HomeWork();
//        homeWork.test1();
//        homeWork.test2();
//        homeWork.test3();
        homeWork.test4();
    }
}
