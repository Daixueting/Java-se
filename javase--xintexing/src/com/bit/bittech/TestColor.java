package com.bit.bittech;

/**
 * @PACKAGE_NAME: com.bit.bittech
 * @NAME: TestColor
 * @USER: 代学婷
 * @AIM:  多例--非枚举
 * @DATE: 2019/9/2
 **/
public class TestColor {
    public static void main(String[] args) {
    Color color=Color.getInstance(2);
        System.out.println(color.getTitle());
        System.out.println(color.toString());

    }
}

//多例：一个类实例化对象的个数是可数的
//实现：使构造方法私有化
//在使用一个静态方法返回一个实例化的对象
class Color{


    public String getTitle() {
        return title;
    }

    private String title;
    private static final Color RED = new Color("RED") ;
    private static final Color GREEN = new Color("GREEN") ;
    private static final Color BLUE = new Color("BLUE") ;

    private Color(String title){
        this.title=title;
    }

    public static Color getInstance(int flag){
     switch (flag){
         case 1:
             return RED;
         case 2:
             return GREEN;
         case 3:
             return BLUE;
             default:
                 return null;
     }
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                '}';
    }
}