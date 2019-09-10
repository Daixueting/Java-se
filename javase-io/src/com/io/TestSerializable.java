package com.io;

import java.io.*;
import java.util.Arrays;
import java.util.Date;

import static java.io.File.separator;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestSerializable
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/9
 **/
public class TestSerializable {
    public static void main(String[] args) {
        Person person = new Person("张三", 1, new Date());
        person.setSkills(new String[]{"java,c++"});
        ObjectOutputStream oout=null;
        try {
            oout=new ObjectOutputStream(new FileOutputStream("E:" + separator + "_test" +
                    separator + "person.txt"));
            oout.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            oout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //反序列化
        File file=new File("E:" + separator + "_test" +
                separator + "person.txt");
        ObjectInputStream in=null;
        try {
            in=new ObjectInputStream(new FileInputStream(file));
            Object object=in.readObject();
            System.out.println(object.getClass());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Person implements Serializable {
    private String name;
    private  Integer age;
    private  String[] skills;
    private Date birthday;

    public Person(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skills=" + Arrays.toString(skills) +
                ", birthday=" + birthday +
                '}';
    }
}