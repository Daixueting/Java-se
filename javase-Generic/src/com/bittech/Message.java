package com.bittech;

/**
 * @PACKAGE_NAME: com.bittech
 * @NAME: Message
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/2
 **/
public class Message<T> {
    private T message ;
    public T getMessage() {
        return message;
    }

    public void setMessage(T message) {
        this.message = message;
    }
}
