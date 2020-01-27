package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class Customer {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private Role role;
	private User user;
	private double wallet;
	private Address address;
	private List<Appointment> appointments = new ArrayList<>();

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
	@Column(name = "cust_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@OneToOne(orphanRemoval = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	//@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="addr_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@JsonIgnore
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Customer [custId=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}
}

	
/*
 * Online Car Service Station Car Service Station is an online application
 * through which you can search nearby Service Centers according to your
 * convenience.Through this application you can reserve a time slot for
 * servicing and repairing of your car as per availability. You can select a
 * service center, services provided by specific service center, vehicle pickup
 * options, timing, service charges, contacts. User will have to create an
 * account on application to use it.
 */
