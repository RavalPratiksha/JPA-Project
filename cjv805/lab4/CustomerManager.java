package cjv805.lab4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cjv805.lab4.model.Customer;
import cjv805.lab4.model.SalesRepresentative;
/**
 * @author Pratiksha Raval
 * This Class is Used to Perform CURD Operations on Customer Table
 */
public class CustomerManager {

	public static boolean valid;

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CJV805");

	EntityManager entitymanager = emfactory.createEntityManager( );

	SalesRepresentative sa = new SalesRepresentative();

	public CustomerManager() {
		this.valid = false;
	}

	
	/**
	 * Delete Customer Data
	 * @param entitymanager
	 * @param id Customer ID
	 */
	public void deleteCustomer(EntityManager entitymanager, int id) {
		// TODO Auto-generated method stub
		entitymanager.getTransaction().begin();

		if(entitymanager.find(Customer.class, id) != null)
		{
		Customer customer = entitymanager.find(Customer.class, id);

		entitymanager.remove(customer);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close( );		
		System.out.println("Customer Deleted Successfully !!! ");
	
		}else	
			System.out.println("No such Customer Available!!!");
	}

	
	/**
	 * Display Customer Details
	 * @param entitymanager
	 * @param id
	 */
	public void displayCustomer(EntityManager entitymanager, int id) {
		// TODO Auto-generated method stub
		entitymanager.getTransaction().begin();

		if(entitymanager.find(Customer.class, id) != null)
		{
		
		Customer customer = entitymanager.find(Customer.class, id);

		System.out.println(" ID = " + customer.getId());
		System.out.println(" NAME = " + customer.getName());
		System.out.println(" EMAIL = " + customer.getEmail());
		System.out.println(" SALARY = " + customer.getAge());

		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close( );	
		}
		else 
			System.out.println("No such Customer Available!!!");
	}

	
	/**
	 * Update Customer Details
	 * @param entitymanager
	 * @param ID
	 */
	public void UpdateCustomer(EntityManager entitymanager, int ID) {
		// TODO Auto-generated method stub
		boolean isEmail = false;
		entitymanager.getTransaction().begin();
		Scanner input = new Scanner(System.in);


		if(entitymanager.find(Customer.class, ID) != null)
		{
		
		Customer customer = entitymanager.find(Customer.class, ID);

		// before update
		System.out.println("Old Information : ");
		System.out.println(customer);

		System.out.println("Enter Email ID to Update : ");
		String New_Email = input.next();

		String email_Regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(email_Regex);
		Matcher matcher = pattern.matcher(New_Email);
		if (matcher.matches()) {
			isEmail = true;
		}

		if(isEmail==true)
		{
		customer.setEmail(New_Email);
		entitymanager.getTransaction().commit();

		// after update
		System.out.println("Updated Information : ");
		System.out.println(customer);
		entitymanager.close();
		emfactory.close( );		
		System.out.println("Customer Successfully Updated !!!");
		}
		else {System.out.println("Enter Valid Email ID !!!");}
		}
		else
			System.out.println("No such Customer Available!!!");
		
		
	}

	/**
	 * Create Customer 
	 * @param entitymanager
	 * @param id
	 * @param email
	 * @param name
	 * @param age
	 * @return Customer Instance
	 */
	public Customer createCustomer(EntityManager entitymanager, int id, String email, String name, int age) {
		// TODO Auto-generated method stub

		boolean isEmail = false;
		boolean isName = false;
		boolean isAge = false;

		entitymanager.getTransaction().begin();
		Scanner input = new Scanner(System.in);

		String email_Regex = "^(.+)@(.+)$";

		Pattern pattern = Pattern.compile(email_Regex);
		Matcher matcher = pattern.matcher(email);
		if (matcher.matches()) {
			isEmail = true;
		}

		if (name.length() >= 1 && name.length() <= 40) {
			isName = true;
		}

		if (age >= 18 && age <= 25) {
			isAge = true;
		}

		System.out.println("Enter Sales Representative ID : ");
		int sales_ID = input.nextInt();

		Customer customer = new Customer();

		SalesRepresentative sa = entitymanager.find(SalesRepresentative.class, sales_ID);

		int sales_id = sa.getId();
		String sales_name = sa.getName();
		double sales_salary = sa.getSalary();

		if (isEmail == true && isName == true && isAge == true) {
			this.valid = true;
			customer.setId(id);
			customer.setName(name);
			customer.setEmail(email);
			customer.setAge(age);
			customer.setFamily(sa);
			entitymanager.persist(customer);

			entitymanager.getTransaction().commit();
			entitymanager.close();
			emfactory.close( );		
		}

		return customer;
	}

}
