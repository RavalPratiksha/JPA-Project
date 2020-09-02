package cjv805.lab4;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cjv805.lab4.model.SalesRepresentative;;


public class SalesRepresentativeManager {

	public static boolean valid;
	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CJV805");
	
	EntityManager entitymanager = emfactory.createEntityManager( );
	
	
public SalesRepresentativeManager()
{
		this.valid = false;
}
		// TODO Auto-generated method stub
		
	public void deleteSalesRep(EntityManager entitymanager, int delete_id) {
		// TODO Auto-generated method stub
		
		entitymanager.getTransaction( ).begin( );

		if(entitymanager.find(SalesRepresentative.class, delete_id) !=null)
		{
		SalesRepresentative salesrep = entitymanager.find(SalesRepresentative.class, delete_id);

		entitymanager.remove(salesrep);
		entitymanager.getTransaction().commit();
		entitymanager.getTransaction( ).commit( );
		entitymanager.close();
		emfactory.close( );	
		System.out.println("Sales Representative Deleted Successfully !!! ");
		}
		else
			System.out.println("No such Sales Representative Available!!!");
	}

	public void displaySalesRep(EntityManager entitymanager, int id) {
		// TODO Auto-generated method stub

		entitymanager.getTransaction( ).begin( );
	    
		if(entitymanager.find(SalesRepresentative.class, id) !=null)
		{
		
		SalesRepresentative salesrep = entitymanager.find(SalesRepresentative.class, id);

		System.out.println(" ID = " + salesrep.getId());
		System.out.println(" NAME = " + salesrep.getName());
		System.out.println(" SALARY = " + salesrep.getSalary());
		entitymanager.getTransaction( ).commit( );
		entitymanager.close();
		emfactory.close( );	
		}
		else
			System.out.println("No such Sales Representative Available!!!");
		
	}

	public void updateSalesRep(EntityManager entitymanager, int ID) {
		// TODO Auto-generated method stub

		boolean isSalary = false ;
		entitymanager.getTransaction( ).begin( );
		Scanner input = new Scanner(System.in);
		if(entitymanager.find(SalesRepresentative.class, ID) !=null)
		{
		SalesRepresentative salesrep = entitymanager.find(SalesRepresentative.class, ID);

		// before update
		System.out.println("Old Information : ");
		System.out.println(salesrep);

		System.out.println("Enter Salary to Update : ");
		double New_Salary = input.nextDouble();
		if(New_Salary>0)
		{
			isSalary = true;
		}
		
		if(isSalary==true)
		{
		salesrep.setSalary(New_Salary);
		entitymanager.getTransaction().commit();

		// after update
		System.out.println("Updated Information : ");
		System.out.println(salesrep);
		entitymanager.getTransaction( ).commit( );
		entitymanager.close();
		emfactory.close( );	
		System.out.println("Sales Representative Successfully Updated !!!");
		}
		else
		{System.out.println("Enter Correct Salary!!");}
		}
		else
			System.out.println("No such Sales Representative Available!!!");
	}

	public SalesRepresentative createSalesRep(EntityManager entitymanager, int ID, String name, double salary) {
		// TODO Auto-generated method stub
		
		SalesRepresentative salesrep = new SalesRepresentative();
		entitymanager.getTransaction( ).begin( );
	    boolean isName  = false ;
	    boolean isSalary = false ;
		
		if(name.length()>=1 && name.length()<=40)
		{
			isName = true;
		}

		
		if(salary>0)
		{
			isSalary = true;
		}

		if(isName==true && isSalary==true)
		{		
		this.valid = true;
		salesrep.setId(ID);
		salesrep.setName(name);
		salesrep.setSalary(salary);
		
		entitymanager.persist(salesrep);
		entitymanager.getTransaction( ).commit( );
		entitymanager.close();
		emfactory.close( );		
		
		}
		
		return salesrep;

	}

	
}