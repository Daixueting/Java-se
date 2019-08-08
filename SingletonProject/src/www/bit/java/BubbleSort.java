package www.bit.java;

/**
 * @PACKAGE_NAME: www.bit.java
 * @NAME: BubbleSort
 * @USER: 代学婷
 * @AIM:
 * @DATE: 2019/8/6
 **/
import java.util.Scanner;
public class BubbleSort{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入十个整数");
        int[] array=new int[10];
        for(int i=0;i<10;i++){
            array[i]=scanner.nextInt();
        }
        bubbleSort(array);
        for(int temp:array){
            System.out.print(temp+"\t");
        }
    }
    //冒泡排序的优化，如果发现没有交换的时候，就说明数组已经有序了，可以直接跳出循环
    public static void bubbleSort(int[] array){
        for(int i=1;i<array.length;i++){
            boolean sort=false;
            for(int j=0;j<array.length-i;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    sort=true;
                }
                if(!sort){
                    break;
                }
            }
        }
    }
}