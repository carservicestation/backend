package com.app.pojos;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

@Entity
@Table(name = "appointment")
//@JsonIgnoreProperties(allowSetters = true, value = {"services"})
public class Appointment
{
	private Integer id;
	private Date date;
	private String time;
	private Customer customer;							//2 way
	private Vehicle vehicle;							//1 way
	private Address pickupAddress;						//1 way
	private ServiceCenter serviceCenter;				//2 way
	
    @JsonIgnore
	private Set<Services> services = new HashSet<>();	//1 way
	private Payment payment;							//2 way
	
	private Status status;
	
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
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd",timezone="IST")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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
    @JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "appointment_service", joinColumns = @JoinColumn(name = "apmt_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	public Set<Services> getServices() {
		return services;
	}
    @JsonProperty
	public void setServices(Set<Services> services) {
		this.services = services;
	}
	//---------------------------------------------------------------------------------------------
	//PAYMENT
	//---------------------------------------------------------------------------------------------
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
//
//	public void addPayment(Payment p) {
//		this.setPayment(p);
//		p.setAppointment(this);
//	}
//
//	public void removePayment(Payment p) {
//		this.setPayment(null);
//		p.setAppointment(null);
//	}
	//---------------------------------------------------------------------------------------------

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", date=" + date + ", customer=" + customer + ", serviceCenter="
				+ serviceCenter + ", vehicle=" + vehicle + ", payment=" + payment + ", pickupAddress=" + pickupAddress
				+ ", services=" + services + "]";
	}

}
