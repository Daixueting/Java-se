package com.bit.bittech;

/**
 * @PACKAGE_NAME: com.bit.bittech
 * @NAME: TestColor2
 * @USER: 代学婷
 * @AIM:  枚举
 * @DATE: 2019/9/3
 **/
public class TestColor2 {
    public static void main(String[] args) {
        System.out.println(Color2.RED);
        System.out.println(Color2.GREEN);
        Color2[] color2s=Color2.values();
        for (Color2 color: color2s
             ) {
            System.out.println(color.getTitle()+" "+color.toString()+" "
                    +color.name()+" "+color.ordinal());
        }
    }
}
enum Color2{ //枚举的写法
    RED("红色"),GREEN("绿色"),BULE("蓝色");//相当于实例化的对象-称作枚举常量
    private String title;
    Color2(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Color2{" +
                "title='" + title + '\'' +
                '}';
    }
}