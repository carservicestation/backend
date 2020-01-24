
package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service")
public class Service {

	private Integer id;
	private String name;
	private String desc;
	private double price;
	private byte[] image;
	private Set<ServiceCenter> serviceCenters = new HashSet<>();
	private Set<Appointment> appointments = new HashSet<>();
	
	public Service() {
	}

	public Service(String name, String desc, double price) {

		this.name = name;
		this.desc = desc;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
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

	@Column(name = "description",columnDefinition = "TEXT")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Lob
	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@ManyToMany(mappedBy = "services")
	@JsonIgnore
	public Set<ServiceCenter> getServiceCenters() {
		return serviceCenters;
	}

	public void setServiceCenters(Set<ServiceCenter> serviceCenters) {
		this.serviceCenters = serviceCenters;
	}
	
	@ManyToMany(mappedBy = "services")
	@JsonIgnore
	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "Service [serviceId=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + "]";
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
		Service other = (Service) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
