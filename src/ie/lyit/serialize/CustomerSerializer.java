//L00085571
//Andrew Campbell
//BSc Computing

package ie.lyit.serialize;

import java.util.ArrayList;
import  ie.lyit.hotel.Customer;
import  ie.lyit.hotel.Person;
import java.util.*;
import java.io.*;


public class CustomerSerializer extends Customer{
	
	private final String FILENAME ="customers.bin";
	////Create an array lis of customers
	private ArrayList<Customer> customers;	
	
	public CustomerSerializer() {
		super();
		customers=new ArrayList<Customer>();
		Customer customer1 = new Customer();
		customers.add(customer1);
		
	}
	
	public void add(){
		// Create a Book object
		Customer customer = new Customer();
		// Read its details
		customer.read();	
		// And add it to the books ArrayList
		customers.add(customer);
		
	}
	//view Customer
	public Customer view(){
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);		

		//Ask user for customer number to be viewed
		System.out.println("ENTER CUSTOMER NUMBER: ");
		int cusNumber=keyboard.nextInt();
		
		// for every Customer object in customers
	    for(Customer tmpCustomer:customers){
		   // if it's number equals the number of the tmpCustomer
		   if(tmpCustomer.getNumber() == cusNumber){
		      // display it
			  System.out.println(tmpCustomer);
			  return tmpCustomer;
		   }
		}
	    // if we reach this code the book was not found so return null
	    return null;		
	}
	
	public void edit(){	
		// Call view() to find, display, & return the book to edit
		Customer tempCustomer = view();
		System.out.println("ENTER CUSTOMER NUMBER: ");
		
	    if(tempCustomer != null){
		   // get it's index
		   int index=customers.indexOf(tempCustomer);
		   // read in a new book and...
		   tempCustomer.getNumber();
		   // reset the object in books
		   customers.set(index, tempCustomer);
		   
	    }
	    else
	    	System.out.println("This is not a valid selection");
	    //tempCustomer.read();
	}
	
	public void delete(){	
		
		Customer tempCustomer = view();
		
	    if(tempCustomer != null)
		   
	       customers.remove(tempCustomer);
	    //tempCustomer.read();
	}
	
	public void list(){
		// for every Book object in books
        for(Customer tmpCustomer:customers)
			// display it
			System.out.println(tmpCustomer);
        
	}
	
	//Method Serializes ArrayList when called
	public void writeRecordsToFile(){
		ObjectOutputStream os=null;
		try {
			// Serialize the ArrayList.
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			os = new ObjectOutputStream(fileStream);
				
			os.writeObject(customers);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		finally {
			try {
				os.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
		
		
	}
	
	//Deserialize the ArrayList.
	
	@SuppressWarnings("unchecked")
	public void readRecordsFromFile(){
		
		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			ObjectInputStream is = new ObjectInputStream(fileStream);
				
			customers = (ArrayList<Customer>)is.readObject();
			
			is.close();
			
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store customer.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

		}
	/*public void generateCustomerNumber() {
			number++;
		
		}*/
	}

