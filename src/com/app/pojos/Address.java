package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address{
	
	private Integer id;
	private String streetAddress;
	private String landmark;
	private String city;
	private String pincode;
	private String state;
	private String country;
		
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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
	
	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", landmark=" + landmark + ", city=" + city
				+ ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}	

}