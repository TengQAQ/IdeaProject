package com.ming.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamDemo {
    public static void main(String[] args) {
        test1();
//        test2();

    }

    /**
     * 每次读取1个字节
     */
    private static void test1() {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("a.txt");
            // 从文件中读取字节
            int count = 0;
            while (true) {
                // 每次读取1个字节，当读取到文件的末尾时，返回-1
                int read = inputStream.read();
                if (read == -1) {
                    break;
                }
                char c = (char)read;
                count++;
                System.out.println(c + "一共接受了" +count);
            }


        } catch (FileNotFoundException e) { // 当读取的文件不存在时
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) { // 避免空指针异常
                try {
                    // 关闭流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void test2(){
        /*
         * try (  声明的对象只能是实现了AutoCloseable接口  )
         * 当对象使用完毕时，不管程序是否发生异常，最后都会自动调用该
         * 对象的close方法。
         * */
        try(
                InputStream in = new FileInputStream("a.txt")
        ){
            // 每次最多读取1024个字节
            byte[] bytes = new byte[30];
            int count;
            while ((count = in.read(bytes)) != -1) {
                String s = new String(bytes, 0, count);
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
