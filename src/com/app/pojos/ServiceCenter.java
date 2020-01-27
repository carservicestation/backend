package com.app.pojos;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "center")
public class ServiceCenter {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private double wallet;
	
	private Owner owner;  //2 way
	private Address address; //1 way

	private Set<Services> services = new HashSet<>();  //1 way
	
	private List<Appointment> appointments = new ArrayList<>(); //2way done

	public ServiceCenter() {
	}

	public ServiceCenter(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "center_id")
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

	@Column(length = 30)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	public double getWallet() {
		return wallet;
	}

	public void setWallet(double wallet) {
		this.wallet = wallet;
	}

	//--------------------------------------------------------------------------------------
	//OWNER
	//--------------------------------------------------------------------------------------
	//@JsonIgnore
	@OneToOne(mappedBy = "serviceCenter",cascade = CascadeType.ALL, orphanRemoval = true)
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
	public void addOwner(Owner o) {
		this.setOwner(o);
		o.setServiceCenter(this);
	}
	
	public void removeOwner(Owner o) {
		this.setOwner(null);
		o.setServiceCenter(null);
	}
	//--------------------------------------------------------------------------------------
	//@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="addr_id")
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	//--------------------------------------------------------------------------------------
	//SERVICES
	//--------------------------------------------------------------------------------------
	//@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "center_service", joinColumns = @JoinColumn(name = "centre_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	public Set<Services> getServices() {
		return services;
	}

	public void setServices(Set<Services> services) {
		this.services = services;
	}
	//--------------------------------------------------------------------------------------
	//Appointment
	//--------------------------------------------------------------------------------------
	@JsonIgnore
	@OneToMany(mappedBy = "serviceCenter", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}
	//--------------------------------------------------------------------------------------

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "ServiceCenter [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", owner="
				+ owner + ", address=" + address + ", services=" + services + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceCenter other = (ServiceCenter) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
