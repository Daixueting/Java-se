package com.reflex.annotation;

import com.reflex.Fruit;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @PACKAGE_NAME: com.reflex.annotation
 * @NAME: TestAnnotionFactory
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/6
 **/
public class TestAnnotionFactory {
    public static void main(String[] args) {
        try {
            IFruit fruit=FruitFactory.getInstance();
            fruit.eat();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


interface IFruit {
    public void eat() ;
}

class Apple implements IFruit {
    @Override
    public void eat() {
        System.out.println("吃苹果") ;
    }
}
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    public Class<?> target() ;
}

@MyAnnotation(target = Apple.class) //方法的指定值是Apple的class对象
class FruitFactory {
    public static <T> T getInstance() throws Exception{
    MyAnnotation mt = FruitFactory.class.getAnnotation(MyAnnotation.class) ;
    Class class21=mt.target(); //得到一个Apple的class对象
    return (T) mt.target().newInstance() ;
    }
}