package cjv805.lab4.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Sales Representative in the system.  
 */
@Entity
//Mark that this is an Entity Bean, 
public class SalesRepresentative {
	
	@Id
	// Mark that this field is the primary key
	//IDENTITY will generate ID Starting from 1 and incrementing by 1.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Sales_Representative_ID", unique = true, nullable = false, updatable = false) 
	private int id;
	
	private String name;
	
	private double salary;
	
	
	public SalesRepresentative() {
		super();
	}
	
	
	/**
	 * Convenience constructor
	 */
	public SalesRepresentative(int id, String name,double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		
	}
	

	@OneToMany(mappedBy="salesrep")
	@JoinColumn(name="CUSTOMER_ID")
	private List<Customer> members = new ArrayList<Customer>();
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}

	@OneToMany(mappedBy="salesrep")
	public List<Customer> getMembers() {
		return members;
	}


	public void setMembers(List<Customer> members) {
		this.members = members;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = (int) (prime * result + salary);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesRepresentative other = (SalesRepresentative) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (salary!= other.salary)
			return false;
		return true;
	}
	

}
