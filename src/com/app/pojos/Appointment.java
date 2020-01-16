
package com.app.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "appointment")
public class Appointment {

	private Integer apmtId;
	private Date datetime;
	private Customer customer;
	private ServiceCenter servCenter;
	private Vehicle vehicle;
	private Payment payment;
	private Set<Service> services = new HashSet<>();
	
	public Appointment() {
	}

	public Appointment(Date datetime, Customer customer, ServiceCenter servCenter, Payment payment) {
		this.setDatetime(datetime);
		this.customer = customer;
		this.servCenter = servCenter;
		this.payment = payment;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "apmt_id")
	public Integer getApmtId() {
		return apmtId;
	}

	public void setApmtId(Integer apmtId) {
		this.apmtId = apmtId;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	@OneToOne
	@JoinColumn(name = "cust_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne
	@JoinColumn(name = "center_id")
	public ServiceCenter getServCenter() {
		return servCenter;
	}

	public void setServCenter(ServiceCenter servCenter) {
		this.servCenter = servCenter;
	}
	
	@OneToOne
	@JoinColumn(name = "vehicle_id")
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@OneToOne(mappedBy="appointment")
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "appointment_service",joinColumns = @JoinColumn(name="apmt_id"),inverseJoinColumns = @JoinColumn(name="service_id"))
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}


	@Override
	public String toString() {
		return "Appointment [datetime=" + datetime + ", customer=" + customer + ", servCenter=" + servCenter + "]";
	}

}
