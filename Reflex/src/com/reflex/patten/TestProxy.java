package com.reflex.patten;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @PACKAGE_NAME: com.reflex.patten
 * @NAME: TestProxy
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/5
 **/
public class TestProxy {
    public static void main(String[] args) {
        //代理接口 Subject
        //真实业务类 RealsSubject
        //增强业务处理类RealSubjectHander
        //代理类（代理对象） //生成对象的类Ptoxy类的newProxyIntance()方法来获取
        //JDK动态代理技术

        //先获取业务类对象
        InvocationHandler handler=new RealSubjectHandler(new RealSubject());
        //Ptoxy类的newProxyIntance()方法来获取代理对象，记得要类型强转
       Object proxyObject=(Message)Proxy.newProxyInstance(RealSubject.class.getClassLoader(),
                                              new Class[]{Subject.class,Message.class},handler);
        System.out.println("ProxyObject的类的接口"+ Arrays.toString(proxyObject.getClass().getInterfaces()));
        System.out.println(((Message) proxyObject).greeting("Tom"));
    }
}
