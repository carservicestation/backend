
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
	private ServiceCenter serviceCenter;
	private Vehicle vehicle;
	private Payment payment;
	private Address pickupAddress;
	
	private Set<Service> services = new HashSet<>();

	public Appointment() {
	}

	public Appointment(Date datetime) {
		this.datetime = datetime;
	}

	public Appointment(Date datetime, Customer customer, ServiceCenter serviceCenter, Vehicle vehicle, Payment payment,
			Set<Service> services) {
		this.datetime = datetime;
		this.customer = customer;
		this.serviceCenter = serviceCenter;
		this.vehicle = vehicle;
		this.payment = payment;
		this.services = services;
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
	public ServiceCenter getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	@OneToOne
	@JoinColumn(name = "vehicle_id")
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@OneToOne(mappedBy = "appointment")
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	@ManyToOne
	@JoinColumn(name="addr_id")
	public Address getPickupAddress() {
		return pickupAddress;
	}

	public void setPickupAddress(Address pickupAddress) {
		this.pickupAddress = pickupAddress;
	}

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "appointment_service", joinColumns = @JoinColumn(name = "apmt_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}

	public void addService(Service s) {
		this.services.add(s);
		s.getAppointments().add(this);
	}
	
	public void removeService(Service s) {
		this.services.remove(s);
		s.getAppointments().remove(this);
	}

	public void addServiceCenter(ServiceCenter sc) {
		this.setServiceCenter(sc);
		sc.getAppointments().add(this);
	}

	public void removeServiceCenter(ServiceCenter sc) {
		this.setServiceCenter(null);
		sc.getAppointments().remove(this);
	}

	@Override
	public String toString() {
		return "Appointment [datetime=" + datetime + "]";
	}

}
