package com.io;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestFile
 * @USER: 代学婷
 * @AIM: File类的代码测试
 * @DATE: 2019/9/6
 **/
public class TestFile {

    public static void  code1(){
        //输入创建文件的路径，因为"\"是特殊字符 所以要写两个"\\"
        //File.separator() 解决了不同系统下路径分隔符不一样的问题
        File file=new File("E:"+File.separator+"_text"+File.separator+"Hello.java");

        if (file.exists()){
            boolean eff=file.delete();  //若是文件处于打开状态，则运行这个方法eff=true，但是文件并没有删除
            if (eff){
                System.out.println("文件删除成功");
            }else {
                System.out.println("文件删除，但是删除失败");
            }
        }
        try {
            Boolean effect= file.createNewFile(); //创建文件，创建成功返回一个true，创建失败返回false
            if (effect){
                System.out.println("文件创建成功");
            }else{
                System.out.println("w文件创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void code2(){
        //创建一个文件，或者目录要先判断他们的父目录是否存在
        /*
        * 取得父路径或父File对象：
         public String getParent() public File getParentFile()
         若想创建父路径，此时最好取得父路径的File类对象。
        创建目录(无论有多少级父目录，都会创建) public boolean mkdirs()
        */
        File file=new File("E:"+File.separator+"_test"+File.separator+
                "hollejava"+File.separator+"Holle.java");
        //先判断文件本身是否存在
        boolean eff=file.exists();
        if (eff){
            System.out.println("所创的文件已存在");
        }else{
            //要先取得父路径判断是否存在
            File file1=file.getParentFile();
            if (file1.exists()){ //父目录存在的前提下
                //创建文件
                try {
                    boolean effect=file.createNewFile();
                    if (effect){
                        System.out.println(file1.getAbsolutePath()+"父目录存在，文件创建成功");
                    }else {
                        System.out.println(file1.getAbsolutePath()+"父目录存在，文件创建失败");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {  //父目录不存在
                boolean effrct1=file1.mkdirs();
                if (effrct1) {
                    try {
                        boolean eff1=file.createNewFile();
                        if (eff1){
                            System.out.println("父目录不存在，文件创建成功");
                        }else {
                            System.out.println("父目录不存在，文件创建失败");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("父目录不存在，文件创建失败");
                }


            }

        }
    }
    public static void code3(){
        File file=new File("E:"+File.separator+"_test"+File.separator+
                "hollejava"+File.separator+"Holle.java");
        //取得文件信息
        System.out.println("文件名"+file.getName());
        System.out.println("是否为文件"+file.isFile()); //判断file对象是否为文件
        System.out.println("是否是目录"+file.isDirectory());
        System.out.println("文件大小"+file.length());
        System.out.println("最后修改时间"+file.lastModified());  //时间戳
        System.out.println("==================");
        System.out.println("最后修改时间"+new Date(file.lastModified()));  //正常时间
    }
    public static void main(String[] args) {
        File file=new File("E:"+File.separator+"_test"+File.separator+"blog");
//        if (file.isDirectory()){
//            String[] str=file.list(); //如果文件组成为空，会返回null
//            for (String name:str
//                 ) {
//                System.out.println("=========");
//                System.out.println(name);
//            }

    //    }
        if (file.isDirectory()){
            String[] str=file.list((f,n)-> {   //返回指定文件，参数中是一个labda表达式  return +指定文件条件
                return true;
            }); //如果文件组成为空，会返回null
            for (String name:str
                 ) {
                System.out.println("=========");
                System.out.println(name);
            }

                }
        }

}
