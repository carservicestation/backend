package com.app.pojos;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Entity
@Table(name = "center")
public class ServiceCenter {

	private Integer centerId;
	private String name;
	private String email;
	private String phone;
	private Owner owner;
	private Set<Service> services = new HashSet<>();
	private CenterAddress address;
	
	public ServiceCenter() {
	}

	public ServiceCenter(String name, String email, String phone) {

		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="center_id")
	public Integer getCenterId() {
		return centerId;
	}

	public void setCenterId(Integer centerId) {
		this.centerId = centerId;
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

	@Column(length = 30)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@ManyToOne
	@JoinColumn(name="owner_id")
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name = "center_service",joinColumns = @JoinColumn(name="centre_id"),inverseJoinColumns = @JoinColumn(name="service_id"))
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}
	
	@Embedded
	public CenterAddress getAddress() {
		return address;
	}

	public void setAddress(CenterAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "ServiceCenter [centerId=" + centerId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ "]";
	}

}
