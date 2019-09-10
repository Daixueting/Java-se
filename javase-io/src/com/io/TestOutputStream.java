package com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestOutputStream
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/7
 **/
public class TestOutputStream {
    public static void code1(){
        File file=new File("E:"+File.separator+"_test"+File.separator+"Hello.text");
        //判断目录是否存在
        File file1=file.getParentFile();
        if (!file1.exists()){
            file1.mkdirs();
        }
        //输出流：目录存在，若是文件不存在，输出流会自动创建
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(65);
            fileOutputStream.write(66);
            fileOutputStream.write(67);
            fileOutputStream.write(68);
            fileOutputStream.write(69);
            fileOutputStream.write('\n');
            fileOutputStream.write(70);
            fileOutputStream.write(71);
            fileOutputStream.write(72);
            fileOutputStream.write(73);
            fileOutputStream.write(74);

            fileOutputStream.flush();//
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
        File file=new File("E:"+File.separator+"_test"+File.separator+"Hello.text");
        //判断目录是否存在
        File file1=file.getParentFile();
        if (!file1.exists()){
            file1.mkdirs();
        }
        //输出流：目录存在，若是文件不存在，输出流会自动创建
       // FileOutputStream fileOutputStream=null;
        /*自动关闭
        try(创建资源类对象){

         }catch{
         }
        * */
        try ( FileOutputStream fileOutputStream=new FileOutputStream(file)){
            fileOutputStream.write(65);
            fileOutputStream.write(66);
            fileOutputStream.write(67);
            fileOutputStream.write(68);
            fileOutputStream.write('\n');
            fileOutputStream.write(69);
            fileOutputStream.write('\n');
            fileOutputStream.write(70);
            fileOutputStream.write(71);
            fileOutputStream.write(72);
            fileOutputStream.write(73);
            fileOutputStream.write(74);
            fileOutputStream.write(75);
            fileOutputStream.write(76);
            fileOutputStream.write(77);
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
