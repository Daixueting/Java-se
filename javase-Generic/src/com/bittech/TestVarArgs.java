package com.bittech;

/**
 * @PACKAGE_NAME: com.bittech
 * @NAME: TestVarArgs
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/9/2
 **/

//计算任意数量的整数之和--形参为int[]
public class TestVarArgs {
    //利用新特性：方法可变参数
    public static int sum (int...values){ //表示values为一个数组
        int sum=0;
        for (int i = 0; i <values.length ; i++) {
            sum +=values[i];
        }
        return sum;
    }

    //foreach循环
    public static void main(String[] args) {
        int[] values=new int[]{1,2,3,4,5,6};
        for (int value:values) {
            System.out.println(value);
        }
        System.out.println(sum(1,2,3,4,4,5));
    }
}
