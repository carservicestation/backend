package com.app.pojos;

import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "center")
public class ServiceCenter {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private Owner owner;
	private Address address;

	private Set<Service> services = new HashSet<>();
	
	private List<Appointment> appointments = new ArrayList<>();

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

	@OneToOne(mappedBy = "serviceCenter", cascade = CascadeType.ALL, orphanRemoval = true)
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne
	@JoinColumn(name = "owner_id")
	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "center_service", joinColumns = @JoinColumn(name = "centre_id"), inverseJoinColumns = @JoinColumn(name = "service_id"))
	public Set<Service> getServices() {
		return services;
	}

	public void setServices(Set<Service> services) {
		this.services = services;
	}
	
	@OneToMany(mappedBy = "serviceCenter", cascade = CascadeType.ALL, orphanRemoval = true)
	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	public void addService(Service s)
	{
		this.services.add(s);
		s.getServiceCenters().add(this);
	}
	
	public void removeService(Service s)
	{
		this.services.remove(s);
		s.getServiceCenters().remove(this);
	}
	
	public void addAddress(Address a)
	{
		this.setAddress(a);
		a.setServiceCenter(this);
	}
	
	public void removeAddress()
	{
		this.setAddress(null);
		this.address.setServiceCenter(null);
	}
	
	@Override
	public String toString() {
		return "ServiceCenter [centerId=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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
