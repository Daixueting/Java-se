package com.bittech;

/**
 * @PACKAGE_NAME: com.bittech
 * @NAME: Point1
 * @USER: 代学婷
 * @AIM:  泛型实现的Point类
 * @DATE: 2019/9/2
 **/
public class Point1<T> {
    private T x;
    private T y;


    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {   //不是泛型方法
        this.y = y;
    }
}
