package cjv805.lab4.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="CONTRACT")
@NamedQueries ({
	@NamedQuery(name="Contract.findAll", query="SELECT c FROM Contract c"),
})

public class Contract implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CONTRACT_ID" , unique = true , nullable = false ,updatable = false)
	private int ContractId;
	
	@Column(name ="Description")
	private String description;
	
	@Column(name = "Value")
	private double value;
	
	@Column(name = "SalesRepresentative")
	private int sales_id;
	

	@Column(name = "Customer")
	private int cust_id;
	

	public Contract() {
		super();
	}

	
	public Contract(int ContractId, String description,int salesrep,int customer) {
		super();
		this.ContractId = ContractId;
		this.description = description;
		this.sales_id = salesrep;
		this.cust_id = customer;
	}
	
	
	public int getContractId() {
		return ContractId;
	}

	public void setContractId(int contractId) {
		ContractId = contractId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	
	public int getSales_id() {
		return sales_id;
	}


	public void setSales_id(int sales_id) {
		this.sales_id = sales_id;
	}


	public int getCust_id() {
		return cust_id;
	}


	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

		
	@Override
	public String toString() {
		return "Contract [Contract ID =" + ContractId + ", Description="
				+ description + ", Value=" + value + ",Sales Representative = " + sales_id + ",Customer = " + cust_id + "]\n";
	}
	
	
}
