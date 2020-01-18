
package com.app.pojos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "service")
public class Service {

	private Integer serviceId;
	private String name;
	private String desc;
	private double price;
	private Set<ServiceCenter> centers = new HashSet<>();
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
	public Integer getServiceId() {
		return serviceId;
	}

	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
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
	
	@ManyToMany(mappedBy = "services")
	@JsonIgnore
	public Set<ServiceCenter> getCenters() {
		return centers;
	}

	public void setCenters(Set<ServiceCenter> centers) {
		this.centers = centers;
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
		return "Service [serviceId=" + serviceId + ", name=" + name + ", desc=" + desc + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((serviceId == null) ? 0 : serviceId.hashCode());
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
		if (serviceId == null) {
			if (other.serviceId != null)
				return false;
		} else if (!serviceId.equals(other.serviceId))
			return false;
		return true;
	}


}
