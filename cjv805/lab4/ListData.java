package cjv805.lab4;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import cjv805.lab4.model.Customer;
import cjv805.lab4.model.SalesRepresentative;
import cjv805.lab4.model.Contract;

/**
 * @author Pratiksha Raval
 * This Class will List All Data.
 * 1) Lists all customer names and their email addresses
 * 2) List the customer name, sales representative name, contract description and contract value 
 * for each contract that a given sales representative secures
 */
public class ListData {

	
	private EntityManagerFactory emf;
	private static EntityManager em;
	

	/**
	 * Lists all customer names and their email addresses
	 * @return Customer Data
	 */
	public List<Customer> queryAllCustomer_NamedQuery() {
		getEntityManager();
		List<Customer> customer = null;

		try {
			
			TypedQuery<Customer> query = em.createNamedQuery("Customer.findAll", Customer.class);

			customer = query.getResultList();
		} catch (Exception ex) {
		} finally {
			//closeEntityManager();
		}
		return customer;
	}
	
	
	/**
	 * List the customer name, sales representative name, contract description and contract value 
	 * for each contract that a given sales representative secures
	 * @return Contract Details
	 */
	public List<Contract> queryAllContractDetails() {
		getEntityManager();
		List<Contract> contract = null;

		try {
			
			TypedQuery<Contract> query = em.createNamedQuery("Contract.findAll", Contract.class);

			contract = query.getResultList();
		} catch (Exception ex) {
		} finally {
		//	closeEntityManager();
		}
		return contract;
	}
	
	public void getEntityManager() {
		// Create the EntityManager
		emf = Persistence.createEntityManagerFactory("CJV805");
		em = emf.createEntityManager();
	}

	public void closeEntityManager() {
		// Close the EntityManager
		em.close();
		emf.close();
	}


public static void main(String[] args) {

	ListData use = new ListData();

	// Query all countries using named query
	List<Customer> custList = use.queryAllCustomer_NamedQuery();
	System.out.println("\nCustomer List (using named query):\n" + custList);
	

	List<Contract> contractList = use.queryAllContractDetails();
	
	System.out.println("\nContract Details :\n");
	for(int i = 0; i<contractList.size();i++)
	{
		int sa_id = contractList.get(i).getSales_id();
		int ca_id = contractList.get(i).getCust_id();
		
		SalesRepresentative sa = em.find(SalesRepresentative.class,sa_id);
		
		Customer ca = em.find(Customer.class,sa_id);
		
		
		String sales_name = sa.getName();
		String cust_name = ca.getName();
	
		System.out.println("Customer Name : " + cust_name + " Sales Rep. ID : " + sa_id +" Sales Representative : " + sales_name + " Description : " + contractList.get(i).getDescription() + " Value : " +contractList.get(i).getValue() );
		
	}
	
	
}
}
