package cjv805.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cjv805.lab4.model.Contract;
import cjv805.lab4.model.Customer;
import cjv805.lab4.model.SalesRepresentative;

/**
 * @author Pratiksha Raval 
 * This Class is the Main Class which Run the Application.
 * Manager Class Manages Three Categories :
 * 1. Customer
 * 2. Sales Representative
 * 3. Contract
 */
public class Manager {

	public static void main(String[] args) {

		
		Scanner input = new Scanner(System.in);
		int selection;

		System.out.println("1. Manage Customer :");
		System.out.println("2. Manage Sales Representative :");
		System.out.println("3. Manage Contract : ");
		System.out.println("4. Exit");

		selection = input.nextInt();

		if (selection == 1) {
			int choice;

			do {
			
			System.out.println("1. Insert a New Customer : ");
			System.out.println("2. Update existing Customer : ");
			System.out.println("3. Display Customer Information : ");
			System.out.println("4. Delete a Customer : ");
			
			
			System.out.println("5. Exit ");

			choice = input.nextInt();
			CustomerManager customer = new CustomerManager();
			Customer cust = new Customer();
			switch (choice) {
			case 1:
				//
				//System.out.println("Enter Customer ID : ");
				//int ID = input.nextInt();

				System.out.println("Enter Customer Email : ");
				String Email = input.next();

				System.out.println("Enter Customer Name: ");
				String Name = input.next();

				System.out.println("Enter Customer Age : ");
				int Age = input.nextInt();

				customer.createCustomer(customer.entitymanager,cust.getId(), Email, Name, Age);

				if (customer.valid == true) {
					System.out.print("Customer Added Successfully");

				} else {
					System.out.println("Incorrect Input Data");
				}
				break;
			case 2:
				System.out.println("Enter Customer ID to Update: ");
				int NEW_ID = input.nextInt();

				customer.UpdateCustomer(customer.entitymanager, NEW_ID);

				break;
			case 3:
				System.out.println("Enter Customer ID : ");
				int id = input.nextInt();

				customer.displayCustomer(customer.entitymanager, id);

				break;
			case 4:

				System.out.println("Enter Customer ID : ");
				int delete_id = input.nextInt();

				customer.deleteCustomer(customer.entitymanager, delete_id);

				break;
			case 5:
				System.exit(0);

			default:
				System.out.println("Choice must be a value between 1 and 5.");
			}
			}while(choice!=5);

		} else if (selection == 2) {
			input = new Scanner(System.in);
			int key;
			do
			{
			
			System.out.println("1. Insert a New Sales Representative : ");
			System.out.println("2. Update existing Sales Representative : : ");
			System.out.println("3. Display Sales Representative Information : ");
			System.out.println("4. Delete a Sales Representative : ");
			System.out.println("5. Exit ");

			SalesRepresentativeManager salesrep = new SalesRepresentativeManager();
			SalesRepresentative sa = new SalesRepresentative();
			System.out.println("Please enter your choice: ");
			key = input.nextInt();

			switch (key) {

			case 1:
				boolean isName = false;
				boolean issalary = false;


				System.out.println("Enter Name : ");
				String Name = input.next();

				System.out.println("Enter Salary : ");
				double salary = input.nextDouble();

				salesrep.createSalesRep(salesrep.entitymanager, sa.getId(), Name, salary);
				
				if (salesrep.valid == true) {
					System.out.print("Sales Representative Added Successfully");

				} else {
					System.out.println("Incorrect Input Data");
				}
				
				break;

			case 2:
				System.out.println("Enter Sales Representative ID to Update: ");
				int NEW_ID = input.nextInt();

				salesrep.updateSalesRep(salesrep.entitymanager, NEW_ID);

				break;
			case 3:
				System.out.println("Enter ID : ");
				int id = input.nextInt();

				salesrep.displaySalesRep(salesrep.entitymanager, id);

				break;
			case 4:

				System.out.println("Enter ID : ");
				int delete_id = input.nextInt();

				salesrep.deleteSalesRep(salesrep.entitymanager, delete_id);

				break;
			case 5: // Exit from the System
				System.exit(0);

			default: // Invalid option
				System.out.println("Invalid Choice.");
				break;

			}
			
			}while(key!=5);

		} 
		else if (selection == 3)
		{
			ContractManager new_contract = new ContractManager();
			Contract ca= new Contract();
			System.out.println("Generate a New Contract ");
			
			System.out.println("Enter Contract Description :");
			String description = input.next();
			
			System.out.println("Enter Contract Value :");
			double value = input.nextDouble();
			
			System.out.println("Enter Sales Representative ID :");
			int sa_id = input.nextInt();
			
			System.out.println("Enter Customer ID : ");
			int cust_id = input.nextInt();
			
			
			new_contract.buildContract(new_contract.entitymanager,ca.getContractId() ,description, value , sa_id , cust_id);
			
			
		}
		
		
		
		else {
			System.exit(0);
		}

	}
}