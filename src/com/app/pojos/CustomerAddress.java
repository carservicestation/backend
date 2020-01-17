package com.app.pojos;
import javax.persistence.*;

@Entity
@Table(name = "cust_address")
public class CustomerAddress{
	
	private Integer addrId;
	private String streetAddress;
	private String landmark;
	private String city;
	private String pincode;
	private String state;
	private String country;
	
	public CustomerAddress() {
	}
	
	public CustomerAddress(String streetAddress, String landmark, String city, String pincode, String state, String country) {
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

	@Override
	public String toString() {
		return "CustomerAddress [streetAddress=" + streetAddress + ", landmark=" + landmark + ", city=" + city
				+ ", pincode=" + pincode + ", state=" + state + ", country=" + country + "]";
	}	

}