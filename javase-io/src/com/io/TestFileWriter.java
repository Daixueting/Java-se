package com.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestFileWriter
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/7
 **/
public class TestFileWriter {
    public static void code1(){
        File file1 = new File("E:" + File.separator + "_test" + File.separator +
                "testwriter" + File.separator + File.separator + "Hello.text");
        File file2 = file1.getParentFile();
        if (!file2.exists()) {
            Boolean eff = file2.mkdirs();
            if (!eff) {
                System.out.println("文件创建失败");
            }
        }
        try (FileWriter fileWriter=new FileWriter(file1)) {
            fileWriter.append('a')
                    .append("Hello world")
                    .append('\n');

            fileWriter.write("I老虎u");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        File file1 = new File("E:" + File.separator + "_test" + File.separator +
                "testwriter" + File.separator + File.separator + "Hello.text");
        File file2 = file1.getParentFile();

        try (FileReader fileReader= new FileReader(file1)) {
//           char[] buff=new char[1024];
//           int len=fileReader.read(buff);
//            System.out.println("读了："+len+"个字符");
//            System.out.println(new String(buff));
            char[] buff=new char[5];
            int len=-1;
            while ((len=fileReader.read(buff))!=-1){
                System.out.println("读了："+len+"个字符");
                System.out.println(new String(buff));
            }
        } catch (IOException e) {
      e.printStackTrace();
        }

    }
}
