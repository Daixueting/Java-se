import java.util.Scanner;
//这个接口是用来区分产品的
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
 //这个接口就是用来生产用的
 interface ComputerFactory{
	 Computer createComputer();
 }
 class MsFactory implements ComputerFactory{
	  public Computer createComputer(){
		  return new SurfaceBookComputer();
	  }
 }
 class AppleFactory implements ComputerFactory{
	  public Computer createComputer(){
		  return new MacbookProComputer();
	  }
 }
 public class Client1 {
 public static void main(String[] args) { 
 Scanner scanner=new Scanner(System.in);
 String type=scanner.nextLine();
 
ComputerFactory computerFactory =new MsFactory();
Computer computer=computerFactory.createComputer();
computer.printComputer();
 }
 }