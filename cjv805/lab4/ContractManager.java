package cjv805.lab4;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import cjv805.lab4.model.Customer;
import cjv805.lab4.model.SalesRepresentative;
import cjv805.lab4.model.Contract;;

/**
 * @author Pratiksha Raval
 * This Class is used to Create the Contract Table and Populate data into table.
 */
public class ContractManager {

	
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CJV805");
	
	EntityManager entitymanager = emfactory.createEntityManager();
	
	
	/**
	 * Build Contract between Customer and Sales Representative
	 * @param entitymanager
	 * @param ca_id Contract Id
	 * @param Description Contract Description
	 * @param value Contract Value
	 * @param sa_id Sales Representative ID
	 * @param cust_id Customer ID
	 * @return Contract Instance
	 */
	public Contract buildContract(EntityManager entitymanager,int ca_id, String Description , double value , int sa_id , int cust_id)
	
	{
		entitymanager.getTransaction().begin();
		Scanner input = new Scanner(System.in);
		
		Contract contract = new Contract();
		
			contract.setContractId(ca_id);
			contract.setDescription(Description);
			contract.setValue(value);
			contract.setSales_id(sa_id);
			contract.setCust_id(cust_id);
			entitymanager.persist(contract);

			entitymanager.getTransaction().commit();
			entitymanager.close();
			emfactory.close( );	
			System.out.println("Contract Generated Successfully!!!");
		

		return contract;
	}
}
