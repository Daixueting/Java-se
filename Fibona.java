import java.util.Scanner;
public class Fibona{
	public static void main(String[] args){
	int a=1;
	int b=1;
	System.out.println("请输入要计算斐波那契数列的个数:");
    Scanner scanner=new Scanner(System.in);
	int z=scanner.nextInt();
	fibona(a,b,z);
}
public static void fibona(int a,int b,int z){
	System.out.print(a+"\t");	
	System.out.print(b+"\t");	
        for(int i=0;i<z-2;i++){
			int c =a+b;
			a=b;
			b=c;
		System.out.print(c+"\t");	
		}
	}
}