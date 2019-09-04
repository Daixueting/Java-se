package com.bittech;
import static com.bittech.MyMath.add;  //调用add方法的时候可以省去类名
/**
 * @PACKAGE_NAME: com.bittech
 * @NAME: TestImportStatic
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/2
 **/
public class TestImportStatic {
    public static void main(String[] args) {
        System.out.println(add(2,3));
    }
}

class MyMath{
    public static int add(int a,int b){
        return a+b;
    }
}