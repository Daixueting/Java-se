package com.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @PACKAGE_NAME: com.reflex
 * @NAME: TestClassPart2
 * @USER: 代学婷
 * @AIM: 通过反射来调用类中的普通方法
 * @DATE: 2019/9/4
 **/
public class TestClassPart2 {
    public static void main(String[] args) throws NoSuchFieldException {
        //Class对象获取方法
        Class classz =Person.class;
     //通过反射来调用类的普通方法
        Method[] methods=classz.getMethods();
        for (Method method:methods
             ) {
            System.out.println("=================");
            System.out.println(method.getName()+" "+ Arrays.toString(method.getParameterTypes()));
        }
        try {
            Method methods2=classz.getMethod("setName", String.class);
            Person person=new Person("张三",22);
            Object returnValue=methods2.invoke(person,"lisi");
            System.out.println(returnValue);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

       //通过反射来获取属性
       Student student=new Student();
        student.setName("代学婷");
        student.setAge(20);
        student.setSkill("java");

        Class studentClass=Student.class;
        //获取父类公开的属性
        Field[] fields=studentClass.getFields();
        System.out.println("====================");
        for (Field field:fields
             ) {
            System.out.println(field.getName()+"  "+field.getType());
        }

        try {
            Field field=studentClass.getField("age");
            System.out.println(field.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        Field field1=studentClass.getDeclaredField("skill");
        try {
            field1.set(student,"c语言");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        field1.setAccessible(true);//打破封装性
        System.out.println(field1.getName());

        try {
            Object obj=field1.get(student);
            System.out.println(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
class Person {
    private String name ;
    public int age ;
    public Person() {

    }
    public Person(String name,int age) {
        this.name = name ; this.age = age ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String greetInfo() {
        return "欢迎"+this.getName();
    }

    public void printPersonInfo(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class Student extends Person{
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "Student{" +
                "skill='" + skill + '\'' +
                '}';
    }
}