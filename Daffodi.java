//水仙花数只是自幂数的一种，严格来说3位数的3次幂数才称为水仙花数。
public  class Daffodi{
	 public static void main(String[] args){
		 System.out.println(153%10);
		 System.out.println(153/10%10);
	for(int i=100;i<1000;i++){
		int a=i%10;
		int b=(i/10)%10;
		int c=i/100;
		
		if((a*a*a+b*b*b+c*c*c)==i){
			System.out.println(i+"\t");
		}
	}	 
}
	 
}