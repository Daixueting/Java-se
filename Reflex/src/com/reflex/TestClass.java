package com.reflex;

import java.util.Date;

/**
 * @PACKAGE_NAME: com.reflex
 * @NAME: TestClass
 * @USER: 代学婷
 * @AIM: 反射
 * @DATE: 2019/9/4
 **/
public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException {
        Date date=new Date();
        Date date1=new Date();
        //返回的是Class对象，java.util.Date
        System.out.println(date.getClass());
        System.out.println(date.getClass());

        //实例化class对象
        Class classz1=date.getClass();
        Class classz2=Date.class;
        Class claassz3=Class.forName("java.util.Date");
        System.out.println(classz1==classz2);
        //不获取Class对象，可以通过Class类获取静态属性和方法
        //获取到class对象，即可访问Class类中定义的成员属性
        try {
            Object object=classz1.newInstance();   //通过对象反射对象
            System.out.println(object);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Class classz11=Integer.class;
        Object object2= null;
        try {
            object2 = classz11.newInstance();
            System.out.println(object2);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


    }
}
