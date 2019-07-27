import java.util.Scanner; 
interface IMyInterface{
	public static final int a =10;  //全局常量
	public abstract void test();
}
interface IMessage{
	public abstract void getMsg();
}
class MyInterface implements IMyInterface,IMessage{
	public void test(){
		 System.out.println(a);
	}
	public void getMsg(){
		System.out.println(a);
	}
}
public class Test{ 
public static void main(String[] args) {
	//向上转型
	IMyInterface imyinterface=new MyInterface();
	
	IMessage imessage =(IMessage)imyinterface;
	imyinterface.test();
	imessage.getMsg();
	System.out.println(MyInterface.a);
	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	