package cjv805.lab4;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.Test;

/**
 * @author Pratiksha Raval
 * This Class Test the Sales Representative Manager Class.
 * It will Test Sales Representative Name and Salary.
 */
class SalesRepresentativeManagerTest {

	SalesRepresentativeManager sr = new SalesRepresentativeManager();
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("CJV805");
	EntityManager entitymanager = emfactory.createEntityManager( );

	@Test
	void testName() {
		
		String IncorrectName = "Alexxxxxxxxxxxxx Stevennnnnnnnn Parkkkkkkkk ";
		
		int SampleID = 10;
		String SampleEmail = "seneca@myseneca.ca";
		double SampleSalary= 2000;
		
		sr.createSalesRep(entitymanager, SampleID, IncorrectName, SampleSalary);
		assertEquals(sr.valid,false);
	
	}
	
	
	@Test
	void testSalary() {
		
		double IncorrectSalary= -1500;
		
		int SampleID = 10;
		String SampleName = "Alex";
		String SampleEmail = "seneca@myseneca.ca";
		
		
		sr.createSalesRep(entitymanager, SampleID, SampleName, IncorrectSalary);
		assertEquals(sr.valid,false);
	
	}
	

}
