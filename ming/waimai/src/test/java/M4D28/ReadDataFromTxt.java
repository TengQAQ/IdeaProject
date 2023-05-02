package M4D28;

import lombok.Data;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author QinTeng
 * @version 1.0
 * @date 2023/4/28-14:56
 * @description
 */
public class ReadDataFromTxt {
    public static void main(String[] args) {
        //path文件 元数据
        String path = "D:\\IdeaProject\\ming\\waimai\\src\\test\\java\\M4D28\\file.text";
        // 定义要写入的文件路径和文件名
        String filePath = "D:\\IdeaProject\\ming\\waimai\\src\\test\\java\\M4D28\\";
        String fileName = "result.txt";
        BufferedReader reader = null;
        List<user> lists = new ArrayList<>();
        List<String> data = new ArrayList<>();
        try {
            // 创建一个 BufferedReader 对象
            reader = new BufferedReader(new FileReader(path));
            String line = null;
            // 逐行读取文件内容
            while ((line = reader.readLine()) != null) {
                data.add(line);
                String[] strings = line.split(",");
                user user = new user();
                if(!strings[0].startsWith("学")){
                    user.setId( Integer.parseInt(strings[0]));
                    user.setName(strings[1]);
                    user.setSex(strings[2]);
                    user.setAge(Integer.parseInt(strings[3]));
                    user.setPhone(strings[4]);
                    lists.add(user);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭 BufferedReader
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        // 打印读取到的数据
        System.out.println("打印读取到的数据");
        for (String s : data) {
            System.out.println(s);
        }
        // 输出所有男性的数据
        System.out.println("输出所有男性的数据");
        List<user> userList1 = lists.stream().filter(a -> a.getSex().contains("男")).collect(Collectors.toList());
        // 输出年龄从大到小
        System.out.println("输出年龄从大到小");
        List<user> userList = lists.stream().sorted(Comparator.comparing(a -> a.getAge())).collect(Collectors.toList());

        // 从输入流中读取数据，并将数据写入文件
        try (OutputStream outputStream = new FileOutputStream(new File(filePath, fileName));
              Writer writer = new OutputStreamWriter(outputStream, "UTF-8")
        ) {
            writer.write(String.valueOf(data));
            writer.write(System.lineSeparator());
            writer.write(userList1.toString());
            writer.write(System.lineSeparator());
            writer.write(userList.toString());
            System.out.println("Data has been written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file.");
            e.printStackTrace();
        }

    }
    @Data
    public static class user {
        private int id;
        private String name;
        private String sex;
        private int age;
        private String phone;
    }
}
