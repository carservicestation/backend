package com.app.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

	private Integer id;
	private Date datetime;

	private Customer customer;							//2 way
	private Vehicle vehicle;							//1 way
	private Address pickupAddress;						//1 way
	private ServiceCenter serviceCenter;				//2 way
	private Set<Services> services = new HashSet<>();	//1 way
	private Payment payment;							//2 way
	
	public Appointment() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apmt_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	//---------------------------------------------------------------------------------------------
	//CUSTOMER
	//---------------------------------------------------------------------------------------------
	@ManyToOne
	@JoinColumn(name = "cust_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public void addCustomer(Customer c) {
		this.setCustomer(c);
		c.getAppointments().add(this);
	}

	public void removeCustomer(Customer c) {
		this.setCustomer(null);
		c.getAppointments().remove(this);
	}
	//---------------------------------------------------------------------------------------------
	//VEHICLE
	//---------------------------------------------------------------------------------------------
	@OneToOne
	@JoinColumn(name = "vehicle_id")
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	//---------------------------------------------------------------------------------------------
	//PICKUP ADDRESS
	//---------------------------------------------------------------------------------------------
	@ManyToOne
	@JoinColumn(name="addr_id")
	public Address getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}
	//---------------------------------------------------------------------------------------------
	//SERVICE CENTER
	//---------------------------------------------------------------------------------------------
	@OneToOne
	@JoinColumn(name = "center_id")
	public ServiceCenter getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	public void addServiceCenter(ServiceCenter sc) {
		this.setServiceCenter(sc);
		sc.getAppointments().add(this);
	}

	public void removeServiceCenter(ServiceCenter sc) {
		this.setServiceCenter(null);
		sc.getAppointments().remove(this);
	}
	//---------------------------------------------------------------------------------------------
	//SERVICES
	//---------------------------------------------------------------------------------------------
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "appointment_service", joinColumns = @JoinColumn(name = "apmt_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	public Set<Services> getServices() {
		return services;
	}

	public void setServices(Set<Services> services) {
		this.services = services;
	}
	//---------------------------------------------------------------------------------------------
	//PAYMENT
	//---------------------------------------------------------------------------------------------
	@OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL, orphanRemoval = true)
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void addPayment(Payment p) {
		this.setPayment(p);
		p.setAppointment(this);
	}

	public void removePayment(Payment p) {
		this.setPayment(null);
		p.setAppointment(null);
	}
	//---------------------------------------------------------------------------------------------

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", datetime=" + datetime + ", customer=" + customer + ", serviceCenter="
				+ serviceCenter + ", vehicle=" + vehicle + ", payment=" + payment + ", pickupAddress=" + pickupAddress
				+ ", services=" + services + "]";
	}

}
