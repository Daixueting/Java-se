package com.reflex.annotation;

import java.io.Serializable;
import java.lang.annotation.*;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * @PACKAGE_NAME: com.reflex.annotation
 * @NAME: TestAnnotation
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/6
 **/
public class TestAnnotation {
    public static void main(String[] args) {
  Class classz= Member2.class;
  Annotation[] annotation=classz.getAnnotations();
        for (Annotation at:annotation
             ) {
            System.out.println(at);
            System.out.println(at.toString());
        }//只输出了一个@  Deprecatsd

        //获取方法上的注解
        //先获取Method对象
        try {
            Method method=classz.getMethod("toString");
            Annotation[] annotations=method.getAnnotations();
            for (Annotation at:annotations
            ) {
                System.out.println(at);
                System.out.println(at.toString());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        //测值自定义注释
        Class classz1=Member3.class;
        Annotation annotation1=classz1.getAnnotation(MyAnnotion.class);  //参数传入注释的反射对象
        System.out.println(annotation1);

    }
}

//自定义注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ interface MyAnnotion{
    String name() default "tom";  //使用default关键字指定值
    int age() default 22;
}


//自定义注解的使用
@MyAnnotion(name = "java",age=22)//需要在括号中指定抽象方法的返回值
class Member3{

}


    @Deprecated//弃用
    @SuppressWarnings(value = "unused")
class Member2 implements Serializable{

        @Override
        @Deprecated
        public String toString() {
            return "Member2{}";
        }
    }

