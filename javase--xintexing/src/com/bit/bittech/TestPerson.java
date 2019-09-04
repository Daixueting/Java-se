package com.bit.bittech;

/**
 * @PACKAGE_NAME: com.bit.bittech
 * @NAME: TestPerson
 * @USER: 代学婷
 * @AIM:枚举的应用
 * @DATE: 2019/9/3
 **/
public class TestPerson {
    public static void main(String[] args) {
  Person person=new Person(15,"张三",Sex.MAN);
        System.out.println(person.toString());
    }

}
class Person{
    private int age;
    private String name;
    private Sex sex;

    public Person(int age, String name, Sex sex) {
        this.age = age;
        this.name = name;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                '}';
    }
}
enum Sex{
    MAN("男人"),WAMAN("女人");
    private String title;

    Sex(String title){
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
        return "Sex{" +
                "title='" + title + '\'' +
                '}';
    }
}