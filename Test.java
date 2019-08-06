import java.util.Scanner; 
public class Test{ 
public static void main(String[] args) throws NumberFormatException{
	
	System.out.println(fristUpper("hello"));
    
	}
	public static String fristUpper(String str){
	//把第一个值变为大写
	 String str1=str.substring(0,1).toUpperCase();
	 //单取出str的第一个字母
	 char[] a =str.toCharArray(0,1);
	 String str2=new String(a);
	 System.out.println(str2);
	 System.out.println(str1);
	 String str3=str.replaceFirst(str2,str1);
	 return str3;
 }
	}
