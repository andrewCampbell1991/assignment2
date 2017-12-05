//L00085571
//Andrew Campbell
//BSc Computing

package ie.lyit.serialize;

import  ie.lyit.hotel.Customer;
import ie.lyit.serialize.CustomerSerializer;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		// Create an object of CustomerSerializer
		CustomerSerializer customerSerializer = new CustomerSerializer();
		
		// Deserialize the ArrayList from the File,
		customerSerializer.readRecordsFromFile();
		
	    // Create a Menu Object
		Menu menuObj = new Menu();
		menuObj.printHeader1();
		
		do{
			// Call it's display() method
			menuObj.display();
			// Call it's readOption() method
			menuObj.readOption();
			// switch on the option and call the appropriate method
			switch(menuObj.getOption()){
			   case 1:customerSerializer.add();
			   break;
			   case 2:customerSerializer.list();
			   break;
			   case 3:customerSerializer.view();
			   break;
			   case 4:customerSerializer.edit();
			   break;
			   case 5:customerSerializer.delete();
			   break;
			   //case 6:customerSerializer.quit();
			   //break;				
			   default:System.out.println("INVALID OPTION...");
			}
		}while(menuObj.getOption() != 6);	
																			
		// Serialize the ArrayList to the File
		customerSerializer.writeRecordsToFile(
			);
	}
}
	

	