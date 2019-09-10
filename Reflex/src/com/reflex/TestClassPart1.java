package com.reflex;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/**
 * @PACKAGE_NAME: com.reflex
 * @NAME: TestClassPart1
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/4
 **/
public class TestClassPart1 {
    public static void code() {
        Class classz=Message.class;
        //获取类的包名称
        Package pg = classz.getPackage();  //classz.getPackage（）---获取一个包类的对象
        System.out.println(classz.getPackage());
        System.out.println(pg.getName());
        System.out.println(pg.toString());
        //获取类的名称
        System.out.println(classz.getName());  //包名+类名==类的全限定名称
        System.out.println(classz.getSimpleName());  //类名
        //父类
        Class superClass = classz.getSuperclass();  //先获得直接父类
        System.out.println("父类的名称:" + superClass.getName());
        try {
            Object object = classz.getSuperclass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        //接口（implements）
        Class[] classes2 = classz.getInterfaces();
        for (Class cls :
                classes2) {
            System.out.println(cls.getName());


        }
    }
    public static void main(String[] args) {
      Class classz=Message.class;
            //获取classz的所有构造方法
        Constructor [] constructors=classz.getConstructors(); //构造方法被抽象成为constructor的对象
        System.out.println("===========");
        System.out.println(classz.getName());

        for (Constructor constructor:constructors
             ) {

            //getParameterTypes()是用来获取参数类型的--但是生成的是Class对象
            //遍历数组通过StringBuiider来拼接
            //Arrays
            Class[] parameterTypes=constructor.getParameterTypes();
            String parameters=Arrays.toString(parameterTypes); //将获取的对象编程String的字符串
            System.out.println(constructor.getName()+"   "+parameters);
        }
        System.out.println("------------------");
        //获取指定的构造方法
        try {
            Constructor constructor=classz.getConstructor(String.class);
            System.out.println(constructor);
            //通过构造方法来获取对象
            Object object=constructor.newInstance("张三");
            Message message=(Message) object;
            System.out.println(message.toString());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

interface IMmessage{

}
interface OperatorSystem{

}

class Message implements IMmessage,OperatorSystem{
    private String name;
    private  Integer age;


    public Message() {
    }

    public Message(String name) {
        this.name=name;
        this.age=age;
    }

    public Message(String name,Integer age) {
        this.name=name;
        this.age=age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}