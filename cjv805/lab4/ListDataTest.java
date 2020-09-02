package cjv805.lab4;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import cjv805.lab4.model.Contract;
import cjv805.lab4.model.Customer;
/**
 * @author Pratiksha Raval
 * Test All Methods in ListData Class.
 * It will Compare the Method Results with data fetched from Customer and Contract Table.
 */
class ListDataTest {

	@Test
	void testNamedQuery() {
		
		ListData Test1 = new ListData();
		Customer ca = new Customer();
		String Email ="ross@gmail.com";
		List<Customer> custList = Test1.queryAllCustomer_NamedQuery();
		
		assertEquals(custList.get(0).getEmail().toString(),Email);
	}
	
	@Test
	void testAllContractDetails() {
		
		ListData Test2 = new ListData();
		Contract ca = new Contract();
		String desc = "Bike";
		List<Contract> contractList = Test2.queryAllContractDetails();
		
		assertEquals(contractList.get(0).getDescription().toString(),desc);
	}

}
