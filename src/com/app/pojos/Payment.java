package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {

	private Integer id;
	private double amount;
	//private Appointment appointment;

	public Payment() {
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pay_id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
//	@OneToOne
//	@JoinColumn(name = "apmt_id")
//	public Appointment getAppointment() {
//		return appointment;
//	}
//
//	public void setAppointment(Appointment appointment) {
//		this.appointment = appointment;
//	}

	@Override
	public String toString() {
		return "Payment [payId=" + id + ", amount=" + amount + "]";
	}

}
