package www.bit.java;

/**
 * @PACKAGE_NAME: www.bit.java
 * @NAME: Test
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/6
 **/
class Singleton{
    private static  Singleton singleton=new Singleton();
   private Singleton(){

   }
   public static Singleton getInstance(){
       return singleton;
   }

}
    private static  Singleton singleton=new Singleton();
    private Singleton(){

    }
    public static Singleton getInstance(){
        return singleton;
    }
public class Test {
    public static void main(String[] args) {
        Singleton singleton1=Singleton.getInstance();
        Singleton singleton2=Singleton.getInstance();
        System.out.println(singleton1==singleton2);
    }
}
