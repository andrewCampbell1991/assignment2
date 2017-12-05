package ie.lyit.hotel;

import  ie.lyit.serialize.CustomerSerializer;
import java.util.*;

public class Customer extends Person{// INHERITANCE - Customer IS-A Person
	// Customer has name, address, & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	
	public static int number= 0;
	private int custID;
	// AND number
	//public static int nextNumber=1;// static for unique number - starts off at 1
	
	// Default Constructor
	// Called when object is created like this ==> 
	//   Customer cObj = new Customer();	
	public Customer(){
		super();			// NOTE:Don't need to call super() explicitly.
		emailAddress=null;
		// Set number to static nextNumber before incrementing nextNumber
		custID=number++;
	}
	
	// Initialization Constructor
	// Called when object is created like this ==>
	// Customer cObj = new Customer("Mr","Joe","Doe","12 Hi Rd,Letterkenny",
	//                              "0871234567","joe@hotmail.com");
	public Customer(String t, String fN, String sn, String address, 
			        String pNo, String email){
		// Call super class constructor - Passing parameters required by Person ONLY!
		super(t, fN, sn, address, pNo);
		// And then initialise Customers own instance variables
		emailAddress=email;
		// And finally set number to static nextNumber before incrementing nextNumber
		custID=number++;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding additional bits
	@Override
	public String toString(){
		return super.toString() + "," + emailAddress;
	}

	// equals() method
	// ==> Called when comparing an object with another object, 
	//     e.g. - if(c1.equals(c2))				
	// ==> Probably sufficient to compare customer numbers as they're unique
	@Override
	public boolean equals(Object obj){
		Customer cObject;
		if (obj instanceof Customer)
		   cObject = (Customer)obj;
		else
		   return false;
		   
	    return(this.number==cObject.number);
	}

	// set() and get() methods
	
	
	public void setEmailAddress(String emailAddress){
		this.emailAddress=emailAddress;
	}
	
	public String getEmailAddress(){
		return this.emailAddress;
	}	
	// You shouldn't be able to setNumber() as it is unique, 
	// so don't provide a setNumber() method
	public int getNumber(){
		return number;
	}	
	
	public void read() throws IllegalArgumentException{
		Scanner kbString = new Scanner(System.in);	
		
		String t, fN, sN, address, email, pNo;
		
		int customerNumber =0;
		
		boolean balanceGoodInput = false;
		
		System.out.println("ENTER CUSTOMER DETAILS ==>");
   	    System.out.print("Title : "); t=kbString.nextLine();
		System.out.print("First Name : "); fN=kbString.nextLine();
	    System.out.print("Surname : "); sN=kbString.nextLine();
	    //name = new Name(t, fN, sN);
		System.out.print("ADDRESS: ");address=kbString.nextLine();
		System.out.print("Phone number: ");pNo=kbString.nextLine();
		System.out.print("Email: ");email=kbString.nextLine();
		System.out.print("Customer designated number is:- "+number++);
				
		//number=nextNumber;
		//nextNumber++;
		
		/*do{
			try{
				System.out.print("Customer number : ");customerNumber=kbString.nextInt();
				balanceGoodInput = true;
			}
			catch(InputMismatchException e){
				System.out.println("Please enter input of type int "); 
				kbString.nextLine();
			}
		}while(!(balanceGoodInput));*/
	}

}
