import java.util.Scanner;
interface Computer {
 void printComputer(); 
 }
 class MacbookProComputer implements Computer {
 public void printComputer() {
 System.out.println("This is a MacbookPro"); 
 } 
 }
 class SurfaceBookComputer implements Computer { 
 public void printComputer() { 
 System.out.println("This is a SurfaceBook");
 } 
 }
 class ComputerFactory{
	 public static Computer getInstance(String type){
		 Computer computer=null;
       if(type.equals("mac")){
		   computer=new MacbookProComputer();
	   }else if(type.equals("surface")){
		   computer=new SurfaceBookComputer();
	   }
 return computer;	   
	   }	 
	 }
 public class Client {
 public static void main(String[] args) { 
 Scanner scanner=new Scanner(System.in);
 System.out.println("请输入你要购买的电脑型号：");
 String type=scanner.nextLine();
 Computer computer=ComputerFactory.getInstance(type);
 computer.printComputer();
 }
 }