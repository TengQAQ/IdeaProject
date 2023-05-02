package com.hxzy.waimai;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.util.stream.Stream;
import java.util.zip.CRC32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/13-10:14
 * @description TODO
 */
//@SpringBootTest
class testZip {
    @Test
    void tets(){
        String letter = "dsadasdadsa";
        Stream.of(letter.getBytes()).forEach(item -> System.out.println(item));
//        System.out.println(count);
    }
    @Test
    void testZip(){
        String  directPath="D:\\BaiduNetdiskDownload\\beiqie\\Hero Legend Ver1.13";
        String outPathFileName="D:\\BaiduNetdiskDownload\\beiqie\\Hero Legend Ver1.13.zip";
        try(
                FileOutputStream fileOutputStream = new FileOutputStream(new File(outPathFileName));
                CheckedOutputStream checkedOutputStream = new CheckedOutputStream(fileOutputStream,new CRC32());
                ZipOutputStream zipOutputStream = new ZipOutputStream(checkedOutputStream);
                ) {
            String baseDir = "";
            compress(new File(directPath), zipOutputStream, baseDir);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 压缩文件或文件夹
     * @param file
     * @param zipOutputStream
     * @param baseDir
     */
    private void compress(File file, ZipOutputStream zipOutputStream, String baseDir) throws IOException {
        //代表是文件夹
        if(file.isDirectory()){
            compressDirectory(file, zipOutputStream, baseDir);
        }else{
            //文件
            compressFile(file,zipOutputStream,baseDir);
        }
    }

    /**
     * 循环当前文件夹下一层的所有的文件或文件夹
     * @param dir
     * @param zipOutputStream
     * @param baseDir
     */
    private void compressDirectory(File dir, ZipOutputStream zipOutputStream, String baseDir) throws IOException {
        //得到所有的文件和文件夹
        File[] files = dir.listFiles();
        for(File f : files){
            //递归     File.separator  判断 linux / 路径分隔符    windows  \\路径分隔符
            compress(f, zipOutputStream, baseDir + dir.getName() + File.separator);
        }
    }

    /**
     * 压缩文件
     * @param file
     * @param zipOut
     * @param baseDir
     * @throws IOException
     */
    private static void compressFile(File file, ZipOutputStream zipOut, String baseDir) throws IOException {
        //如果文件不存，不要做了
        if (!file.exists()) {
            return;
        }
        // 把文件加载内存中（内存流）  BufferedInputStream
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            //创建一个 zip实例
            ZipEntry entry = new ZipEntry(baseDir + file.getName());

            //把 zip实例  添加到 zipOutputStream中去
            zipOut.putNextEntry(entry);

            int count;
            byte[] data = new byte[1024];
            while ((count = bis.read(data, 0, 1024)) != -1) {
                zipOut.write(data, 0, count);
            }
        }
    }
}
