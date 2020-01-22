package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

	private Integer custId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private List<Address> addresses = new ArrayList<>();

	public Customer() {

	}

	public Customer(String name, String email, String phone, String password) {
	
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cust_id")
	public Integer getCustId() {
		return custId;
	}

	public void setCustId(Integer custId) {
		this.custId = custId;
	}
	
	@Column(length = 30)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(length = 30, unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(length = 30, nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(mappedBy="customer", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public void addAddress(Address ca)
	{
		this.addresses.add(ca);
		ca.setCustomer(this);
	}
	
	public void removeAddress(Address ca)
	{
		this.addresses.remove(ca);
		ca.setCustomer(null);
	}

	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}
}



/*
 * Online Car Service Station
 * Car Service Station is an online application through which you can search
 * nearby Service Centers according to your convenience.Through this application
 * you can reserve a time slot for servicing and repairing of your car as per
 * availability. You can select a service center, services provided by specific
 * service center, vehicle pickup options, timing, service charges, contacts.
 * User will have to create an account on application to use it. 
 */


