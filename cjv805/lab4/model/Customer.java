package cjv805.lab4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
/**
 * Represents a Customer in the system.  
 */

//Mark that this is an Entity Bean, 
@Entity
@Table(name="CUSTOMER")
@NamedQueries ({
	@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c"),
})
public class Customer {
	
	@Id
	// Mark that this field is the primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CUSTOMER_ID" , unique = true , nullable = false ,updatable = false)
	private int id;
	
	private String name;
	
	private String email;
	
	private int age;
	
	
	@ManyToOne
	@JoinColumn(name="Sales_Representative_ID")
	private SalesRepresentative salesrep;
	
	
	
	/**
	 * Default constructor, required by JPA
	 */
	public Customer() {
		super();
	}
	
	
	/**
	 * Convenience constructor
	 */
	public Customer(int id, String name,String email,int age) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
	
	String email_Regex ="^(.+)@(.+)$"; 
                   
	Pattern pattern = Pattern.compile(email_Regex); 
	Matcher matcher = pattern.matcher(email);
	if(matcher.matches())
		{this.email = email;}
	else
		{System.out.println("Enter Valid Email :");}
	}


	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@ManyToOne
	public SalesRepresentative getSalesRep() {
		return salesrep;
	}

	public void setFamily(SalesRepresentative salesrep) {
		this.salesrep =salesrep;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email+ "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + age;
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
		Customer other = (Customer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (age!= other.age)
			return false;
		return true;
	}
	
}
