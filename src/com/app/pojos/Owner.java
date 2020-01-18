package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "owner")
public class Owner {

	private Integer ownerId;
	private String name;
	private String email;
	private String phone;
	private String password;
	private OwnerAddress address;
	private List<ServiceCenter> serviceCenters = new ArrayList<>() ;
	
	public Owner() {
	}

	public Owner(String name, String email, String phone, String password) {
	
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="owner_id")
	public Integer getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
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
	
	@Embedded
	public OwnerAddress getAddress() {
		return address;
	}

	public void setAddress(OwnerAddress address) {
		this.address = address;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="owner", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<ServiceCenter> getServiceCenters() {
		return serviceCenters;
	}

	public void setServiceCenters(List<ServiceCenter> serviceCenters) {
		this.serviceCenters = serviceCenters;
	}
	
	public void addServiceCenters(ServiceCenter sc)
	{
		this.serviceCenters.add(sc);
	}
	
	public void removeServiceCenters(ServiceCenter sc)
	{
		this.serviceCenters.remove(sc);
	}
	

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}
	
}


