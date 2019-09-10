package com.io;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestMemoryStream
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/8
 **/
public class TestMemoryStream {
    public static void code1(){
        String contect="hello world";
        //要求：内存流将hello world 变成大写
        byte[] data=contect.getBytes();
        ByteArrayInputStream in=new ByteArrayInputStream(data);
        int len=-1;
        ByteArrayOutputStream out=new  ByteArrayOutputStream();
        while ((len=in.read())!=-1){
            len=Character.toUpperCase(len);  //将小写转为大写
            out.write(len); //没有返回值，输出的东西，直接存在内存输出流的对象中
        }
        System.out.println(out);
        byte[] newData=out.toByteArray();
        System.out.println(new String(newData));

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //使用内存流将两个文件合并起来
        //实现方式：a文件读到b文件中
        //       ：a文件--》ByteArrayOutputStream，b文件--》ByteArrayOutputStream，
        //         ByteArrayOutputStream byte[]-->FileOutputStream [适合小文件的合并]
        try(FileInputStream fa=new FileInputStream("E:"+ File.separator+"_test"+File.separator+
                                           "testbytearrayoutputstream"+File.separator+"AData.java");
            FileInputStream fb=new FileInputStream("E:"+ File.separator+"_test"+File.separator+
                    "testbytearrayoutputstream"+File.separator+"BData.java");
            FileOutputStream fdata=new FileOutputStream("E:"+ File.separator+"_test"+File.separator+
                    "testbytearrayoutputstream"+File.separator+"Data.java");
            ByteArrayOutputStream memoryOut=new ByteArrayOutputStream();
        ){
        byte[] buff=new byte[1204];
        int len=-1;
        while ((len=fa.read(buff))!=-1){
            memoryOut.write(buff,0,len);
        }while ((len=fb.read(buff))!=-1){
            memoryOut.write(buff,0,len);
            fdata.flush();
        }
        byte[] mergeData=memoryOut.toByteArray();
        fdata.write(mergeData);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
