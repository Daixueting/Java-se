package com.bittech;

/**
 * @PACKAGE_NAME: com.bittech
 * @NAME: TestMessage
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/2
 **/
public class TestMessage {
    public static void main(String[] args) {
//        Message<String> message=new Message<>();
//        message.setMessage("java is best");
//        fun(message);

        Message<Integer> message=new Message<>();
        message.setMessage(666);
        fun(message);
    }

    //fun方法中Message类型参数的具体类型String
    public static void fun(Message<?> message){
        message=new Message<String>();//这里可以创建
        System.out.println(message.getMessage());    //返回值为null
        //返回的是方法中实例化的message，但是massage的不可以做修改
    }
}
