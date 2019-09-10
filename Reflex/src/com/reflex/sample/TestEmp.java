package com.reflex.sample;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @PACKAGE_NAME: com.reflex.sample
 * @NAME: TestEmp
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/5
 **/
public class TestEmp {
    public static void main(String[] args) {
        //将一个字符串的内容赋值给Emp对象的属性
        //实现：
        //1.拆分字符串 先| 再：  ；
        //实例化对象 赋值

        String value="name:张三|job:SoftDeveloper";
        String[] attributeNameValue=value.split("\\|");
        System.out.println(attributeNameValue[0]);
        System.out.println(attributeNameValue[1]);
        Emp emp=new Emp();
        for (String nameAndValue:attributeNameValue
             ) {
           String[] nv=nameAndValue.split(":");
            setXxx(emp,nv[0],nv[1]);
        }

        System.out.println(emp.toString());
    }
    public static void setXxx(Object object,String name,String value){

        Class classz= object.getClass();
        String setMethodName="set"+name.substring(0,1).toUpperCase()+(name.length()>1?name.substring(1):" ");
        System.out.println("======================");
        System.out.println(setMethodName);
        //通过反射对象来的到这个类的方法
        try {
            Method method=classz.getMethod(setMethodName,name.getClass());
            method.invoke(object,value);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
