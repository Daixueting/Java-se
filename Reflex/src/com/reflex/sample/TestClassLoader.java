package com.reflex.sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @PACKAGE_NAME: com.reflex.sample
 * @NAME: TestClassLoader
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/5
 **/
public class TestClassLoader {
    public static void main(String[] args) {
     Class classz=TestClassLoader.class;
        System.out.println(classz.getClassLoader());
        System.out.println(classz.getClassLoader().getParent());
        System.out.println(classz.getClassLoader().getParent().getParent());
    }
}
