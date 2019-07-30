//判断给定的字符串是否由数字组成、
import java.util.Scanner; 
public class StringTest{ 
public static void main(String[] args) {
System.out.println("请输入字符串");
Scanner scanner=new Scanner(System.in);
String str=scanner.nextLine();
char[] data=str.toCharArray();
System.out.println(isNumber(str));
}
public static boolean isNumber(String str){
	char[] data=str.toCharArray();
	for(int i=0;i<data.length;){
		//这个是字符类型
	if(data[i]<'0'||data[i]>'9'){
		return false;
	}else {
		i++;
	}
	}
	return true;
}
}