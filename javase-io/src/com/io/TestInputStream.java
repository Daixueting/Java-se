package com.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestInputStream
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/7
 **/
public class TestInputStream {
    public static void main(String[] args) {
        File file=new File("E:"+File.separator+"_test"+File.separator+"Hello.text");

        try(  FileInputStream fileInputStream=new FileInputStream(file);) {
          int len=-1;
          while ((len=fileInputStream.read())!=-1){
              System.out.print((char)fileInputStream.read());
          }

          //  byte[] by=new byte[5];
         /*   while ((len=fileInputStream.read(by))!=-1){
                System.out.print(new String(by,0,len));
                System.out.println(len);
          }*/
//            fileInputStream.read(by);
//            fileInputStream.read(by,2,2);
//            System.out.println(new String(by));
//            fileInputStream.read(by,2,2);
//            System.out.println(new String(by));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
