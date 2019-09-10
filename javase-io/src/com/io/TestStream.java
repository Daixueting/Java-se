package com.io;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestStream
 * @USER: 代学婷
 * @AIM:  从键盘输入
 * @DATE: 2019/9/9
 **/
public class TestStream {
    public static void main(String[] args) {
        InputStream in=System.in; //System.in就表示标准的从键盘输入
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        byte[] buff=new byte[5];
        int len =-1;
        while (true){
            try {
                if (!((len=in.read(buff))!=-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            outputStream.write(buff,0,len);
            if (len<buff.length){
                break;
            }
        }
        System.out.println(outputStream);
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
