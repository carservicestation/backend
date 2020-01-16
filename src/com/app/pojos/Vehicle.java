package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

	private Integer vehicleId;
	private String make;
	private String model;
	private Fuel fuelType;

	public Vehicle() {
	}

	public Vehicle(String make, String model, Fuel fuelType) {
		this.make = make;
		this.model = model;
		this.fuelType = fuelType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehicle_id")
	public Integer getCarId() {
		return vehicleId;
	}

	public void setCarId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	@Column(length = 30)
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	@Column(length = 30)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20, name="fuel_type")
	public Fuel getFuelType() {
		return fuelType;
	}

	public void setFuelType(Fuel fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", make=" + make + ", model=" + model + ", fuelType=" + fuelType
				+ "]";
	}

}
