package com.app.pojos;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address{
	
	private Integer addrId;
	private String streetAddress;
	private String landmark;
	private String city;
	private String pincode;
	private String state;
	private String country;
	
	private Customer customer;
	
	private ServiceCenter serviceCenter;
	
	private Owner owner;
	
	private List<Appointment> appointments = new ArrayList<>();
	
	public Address() {
	}
	
	public Address(String streetAddress, String landmark, String city, String pincode, String state, String country) {
		this.streetAddress = streetAddress;
		this.landmark = landmark;
		this.city = city;
		this.pincode = pincode;
		this.state = state;
		this.country = country;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "addr_id")
	public Integer getAddrId() {
		return addrId;
	}

	public void setAddrId(Integer addrId) {
		this.addrId = addrId;
	}

	@Column(length=50, name = "street_address")
	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	@Column(length=20)
	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	@Column(length=20)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(length=20)
	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	@Column(length=20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	@Column(length=20)
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cust_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@OneToOne
	@JoinColumn(name="center_id")
	public ServiceCenter getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}
	
	@OneToOne
	@JoinColumn(name="owner_id")
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy = "pickupAddress", cascade = CascadeType.PERSIST)
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void addAppointment(Appointment ap)
	{
		this.appointments.add(ap);
		ap.setPickupAddress(this);
	}

	public void removeAppointment(Appointment ap)
	{
		this.appointments.remove(ap);
		ap.setPickupAddress(null);
	}	
	
	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", landmark=" + landmark + ", city=" + city
				+ ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}	

}