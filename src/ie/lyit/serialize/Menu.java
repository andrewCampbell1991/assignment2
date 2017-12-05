package ie.lyit.serialize;

import java.util.Scanner;

public class Menu {
   private int option;

   public void printHeader1() {
		System.out.println("**************************************");
		System.out.println("**              Welcome             **");
		System.out.println("**************************************");
	}

   public void display() {
		System.out.println("---Please enter number of selection---");
		System.out.println("**************************************");
		System.out.println("\t1.Add Customer");
		System.out.println("\t2.List Customer details");
		System.out.println("\t3.View Customer details");
		System.out.println("\t4.Edit Customer details");
		System.out.println("\t5.Delete Customer Details");
		System.out.println("\t6.Quit");
		
	}
	
   public void readOption(){
      @SuppressWarnings("resource")
      Scanner kbInt = new Scanner(System.in);
  	  System.out.println("\n\tEnter one of the available options");
   	  option=kbInt.nextInt();
   }
					
	public int getOption(){
	   return option;
	}

	public void printHeader() {
		// TODO Auto-generated method stub
		
	}	
}