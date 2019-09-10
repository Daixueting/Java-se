package com.reflex;

/**
 * @PACKAGE_NAME: com.reflex
 * @NAME: TestFruit
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/4
 **/
public class TestFruit {
    public static void main(String[] args) {
        Fruit fruit=FruitFactory.getFruit("com.reflex.Apple");
        if (fruit!=null){
            fruit.eat();
        }else {
            System.out.println("FruitFactory创建对象失败");
        }
    }
}
