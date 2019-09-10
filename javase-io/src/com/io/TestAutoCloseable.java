package com.io;

/**
 * @PACKAGE_NAME: com.io
 * @NAME: TestAutoCloseable
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/7
 **/
public class TestAutoCloseable {
    public static void main(String[] args) {
       /* Message message=new Message();
        message.print();
        try {
            message.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        try(Message message=new Message()){
            message.print();
        }
         catch (Exception e) {
            e.printStackTrace();
        }

    }
}
class Message implements AutoCloseable{
 public void print(){
     System.out.println("Message print方法调用");
 }
    @Override
    public void close() throws Exception {
        System.out.println("Message close方法执行");
    }
}