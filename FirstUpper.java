import java.util.Scanner;
public class FirstUpper{
	//输入一个字符串，将字符串转为首字母大写
	public static void main(String[] args){
		System.out.println("请输入字符串");
		Scanner scnaner=new Scanner(System.in);
		String str=scnaner.nextLine();
		System.out.println(firstUpper(str));
		System.out.println(str); //字符串的不可变更性
	
		
	}
	
 public static String firstUpper(String str){
	//把第一个值变为大写
	 String str1=str.substring(0,1).toUpperCase();
	 //单取出str的第一个字母
	 char a =str.charAt(0);
	 String str2=String.valueOf(a);  //valueOf()和paseInt()...都是静态方法
	 String str3=str.replaceFirst(str2,str1);
	 return str3;
	 
 }
 
}