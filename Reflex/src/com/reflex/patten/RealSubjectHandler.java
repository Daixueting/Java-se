package com.reflex.patten;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @PACKAGE_NAME: com.reflex.patten
 * @NAME: RealSubjectHandler
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/5
 **/
//这个类才是动态代理的业务类
//动态代理时需要实现InvocationHandler接口，用于编写增强的业务功能
public class RealSubjectHandler implements InvocationHandler {
    private Object targae;      //真实业务类的对象
  //  private  Object message;

    public RealSubjectHandler(Object targae) {
        this.targae = targae;
    }
//    public RealSubjectHandler(Object message) {
//        this.targae = message;
//    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这是代理增强代码A");
        //目标对象的方法执行
        Object object=method.invoke(targae,args);
        System.out.println("这是代理增强代码B");
        return  object;
    }
}
