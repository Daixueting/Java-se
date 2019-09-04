package com.bit.bittech;

/**
 * @PACKAGE_NAME: com.bit.bittech
 * @NAME: TestLambda
 * @USER: 代学婷
 * @AIM:lambda表达式
 * @DATE: 2019/9/3
 **/
public class TestLambda {
    public static void main(String[] args) {
      //通过一个匿名内部类，创建一个对象
      IMessage2 iMessage2=new IMessage2() {
          @Override
          public void print() {
              System.out.println("这是通过匿名内部类来实现接口");
          }
      };
      iMessage2.print();

      IMessage2 iMessage21=() -> System.out.println("这是lambda表达式来实现接口");
      iMessage21.print();
        IMessage3 iMessage3=() -> {
            String a="hello";
            String b="world";
            return a+b;
        };
        iMessage3.fun();
        IMessage4 iMessage4=(x,y) -> x+y;
        System.out.println(iMessage4.add(4,5));

        //1.静态的方法引用 类名称::方法名称
//        IUtil1<Integer,String> iUtil1=(i) ->{
//          return String.valueOf(i);
//        };
        IUtil1<Integer,String> iUtil1=String::valueOf;
        iUtil1.conver(20);

        convert((x)->String.valueOf(x));
        convert((x)->{
            System.out.println(x);
            return String.valueOf(x);  //根据传入值和返回值类型来创建的对象
        });
        convert(
                String::valueOf
        );
        convert(new IUtil1<Integer, String>() {
            @Override
            public String conver(Integer integer) {
                return String.valueOf(integer);
            }
        });
      //2.对象方法引用
        IUtil2<String> iUtil2=()->{
            return "Hello";
        };
        System.out.println(iUtil2.switchParam());
        "Hello".toUpperCase();
       IUtil2 iUtil21="Hello"::toUpperCase;
       //IUtil2 iUtil21=() ->{
        //  return "Hello".toUpperCase();
        //  }
        System.out.println(iUtil21.switchParam());
        //3.类中的普通方法引用   类名：：方法名成
        IUtil3<String,  Integer> iUtil3= String::compareTo;
        System.out.println(iUtil3.compare("Hello","HELLO"));
        //引用类的构造方法
        IUtil4<String,Integer,Person1> iUtil4=(p1,p2) ->{
           return new Person1("张三",22);
        };
        IUtil4<String,Integer,Person1> iUtil41=Person1::new;
        Person1 person1=iUtil41.createObject("李四",20);
    }

    public static void convert(IUtil1<Integer,String> iUtil1){
    System.out.println(iUtil1.conver(20));
}
}
/*
* lambda函数式变成
* 1.函数接口：专门为函数变成而生，有且只有一个抽象方法，采用@FunctionalInterface来标识
* */

@FunctionalInterface
interface IMessage2{
    void print();
}

@FunctionalInterface
interface IMessage3{
    String fun();
}

@FunctionalInterface
interface IMessage4{
    int add(int x,int y);
}

class Person1{
    private String name;
    private int age;

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person1() {
        this.age=0;
        this.name=null;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

//静态方法引用
@FunctionalInterface
interface IUtil1<P,R>{
    R conver(P p);
}
//对象方法引用
@FunctionalInterface
interface IUtil2<R>{
    R switchParam();
}

//类中的普通方法引用
interface IUtil3<P,R>{
    R compare(P p1,P p2);
}

//引用类的构造函数
@FunctionalInterface
interface IUtil4<P1,P2,R>{
    R createObject(P1 p1,P2 p2);
}