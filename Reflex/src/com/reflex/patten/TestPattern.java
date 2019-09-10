package com.reflex.patten;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @PACKAGE_NAME: com.reflex.patten
 * @NAME: TestPattern
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/5
 **/
public class TestPattern {
    public static void main(String[] args) {
        Subject subject=Factory.getInstance("com.reflex.patten.ProxySubject",new RealSubject());
        subject.eat();
    }
}

interface Subject{
    void eat();
}

interface Message{
    String greeting(String name);
}
class RealSubject implements Subject,Message{
    @Override public void eat() {
        System.out.println("饿了要吃饭") ;
    }

    @Override
    public String greeting(String name) {
        return "欢迎"+name;
    }
}

//动态代理和这个类没有关系
class ProxySubject implements Subject {
    private Subject subject ;

    public ProxySubject(Subject subject) {
        this.subject = subject;
    }

    public void prepare() {
        System.out.println("饭前收拾食材") ;
    }

    public void afterEat() {
        System.out.println("洗刷刷") ;
    }

    @Override
    public void eat() {
        this.prepare() ;
        this.subject.eat() ; // 核心吃
        this.afterEat() ;
    }
}

class Factory{  //用来获取代理对象
    private Factory(){

    }
    public static  <T> T getInstance(String className,Object obj){ //obj是真实业务类的对象
        try {
            Class classz=Class.forName(className);

            //得到代理接口的返回值类型（作为返回值）
            Class classz2=classz.getInterfaces()[0];
            //通过反射对象先获取指定的构造方法
            Constructor constructor=classz.getConstructor(classz2);
            //在通过构造方法实例化一个类
            return (T)constructor.newInstance(obj);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }  catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}