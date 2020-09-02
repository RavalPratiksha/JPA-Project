package cjv805.lab4;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

/**
 * @author Pratiksha Raval
 * This Class Test the Customer Manager Class.
 * It will Test Customer Name, Email and Age.
 */
class CustomerManagerTest {

	CustomerManager cm = new CustomerManager();
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CJV805");
	EntityManager entitymanager = emfactory.createEntityManager( );
	
	
	@Test
	void testEmail() {
	
		
		String IncorrectEmail = "mysenecasenecacollege.ca";
		
		int SampleID = 10;
		String SampleName = "Alex";
		int SampleAge= 20;
		
		cm.createCustomer(entitymanager, SampleID, IncorrectEmail, SampleName, SampleAge);
		assertEquals(cm.valid,false);
	}

	@Test
	void testName() {
		
		String IncorrectName = "Alexxxxxxxxxxxxx Stevennnnnnnnn Parkkkkkkkk ";
		
		int SampleID = 10;
		String SampleEmail = "seneca@myseneca.ca";
		int SampleAge= 20;
		
		cm.createCustomer(entitymanager, SampleID, SampleEmail, IncorrectName, SampleAge);
		assertEquals(cm.valid,false);
	
	}
	
	@Test
	void testAge() {
		
		int IncorrectAge= 40;
		
		int SampleID = 10;
		String SampleName = "Alex";
		String SampleEmail = "seneca@myseneca.ca";
		
		
		cm.createCustomer(entitymanager, SampleID, SampleEmail, SampleName, IncorrectAge);
		assertEquals(cm.valid,false);
	
	}
	
}
