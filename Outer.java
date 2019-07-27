public class Outer{
	private String msg="OUTER的msg";
	class Inner{
		public void fun(){
			System.out.println(msg);
		}
	}
	public void test(){
		Inner in=new Inner();
		in.fun();
	}
	
	public static void main(String[] args){
		Outer out =new Outer();
	    out.test();
	
}
}