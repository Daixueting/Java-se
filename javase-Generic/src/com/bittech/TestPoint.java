package com.bittech;

/**
 * @PACKAGE_NAME: com.bittech
 * @NAME: TestPoint
 * @USER: 代学婷
 * @AIM:  泛型
 * @DATE: 2019/9/2
 **/
public class TestPoint {
    public  static void code1(){
        Point point1=new Point();
        point1.setX(20);
        point1.setY(10);
        //若是Y在赋值的时候不小心赋值成为String类型，会在输出的时候出现运行时异常

        Point point2=new Point();
        point2.setX(20.1);
        point2.setY(10.1);

        System.out.println("通过Point的getter方法来获取属性的值");
        int x=(Integer) point1.getX();
        int y=(Integer)point1.getY();
        System.out.println("point1的x值"+x+"  "+" point1的y值" +y);
    }

    public static void main(String[] args) {
    Point1<String> point1=new Point1<String>();
    point1.setX("东经180度");

    testMath("hello world");

    }

    /*
    泛型方法
     */
    public static  <T> void testMath(T t){
        System.out.println(t);
    }
}
