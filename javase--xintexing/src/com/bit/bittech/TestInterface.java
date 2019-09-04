package com.bit.bittech;

/**
 * @PACKAGE_NAME: com.bit.bittech
 * @NAME: TestInterface
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/3
 **/
public class TestInterface {
    public static void main(String[] args) {
        IMessage qq=new QQMessage();
        qq.fun();
        IMessage qq2=IMessage.getInstance();
    }
}
interface IMessage{
    public default void fun(){
        System.out.println("聊天工具");
    }
    // 可以直接由接口名称直接调用
    public static IMessage getInstance() {
        return new QQMessage() ;
    }
    void print();
}
class QQMessage implements IMessage{

    @Override
    public void print() {
        System.out.println("这是qq聊天工具");
    }
    @Override
    public void fun(){
        System.out.println("沟通多一点");
    }
}

class MsnMessage implements IMessage{

    @Override
    public void print() {
        System.out.println("这是Msn的聊天工具");
    }
}