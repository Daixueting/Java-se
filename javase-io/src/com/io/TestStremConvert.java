package com.io;

import java.io.*;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestStremConvert
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/8
 **/
public class TestStremConvert {
    public static void main(String[] args) {
        File file=new File("E:"+File.separator+"_test"+File.separator+"Hello.text");
        //字节流的输入流转化成为字符流的输入流----InputStreamReader
        try (InputStream inputStream=new FileInputStream(file);
             Reader reader=new InputStreamReader(inputStream)){ //将字节流转换成为字符流

            char[] buff=new char[5];
            int len=-1;
            while ((len=reader.read(buff))!=-1){
                System.out.println("len的值为:"+len);
                System.out.println(new String(buff,0,len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
