package com.reflex;

/**
 * @PACKAGE_NAME: com.reflex
 * @NAME: Fruit
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/4
 **/
public interface Fruit {
    void eat();
}

class Apple implements Fruit{

    @Override
    public void eat() {
        System.out.println("吃苹果");
    }
}

class FruitFactory{
    private FruitFactory(){

    }
    public static Fruit getFruit(String className){
        try {
            Class classz1=Class.forName(className);
            return (Fruit) classz1.newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

}