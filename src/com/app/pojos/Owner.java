package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "owner")
public class Owner {

	private Integer id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private Role role;
	
	private User user;
	private ServiceCenter serviceCenter;  //2 way done
	
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
	
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	//@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@JsonIgnore
	@OneToOne(orphanRemoval = true,cascade = CascadeType.ALL)
	@JoinColumn(name = "center_id")
	public ServiceCenter getServiceCenter() {
		return serviceCenter;
	}

	public void setServiceCenter(ServiceCenter serviceCenter) {
		this.serviceCenter = serviceCenter;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}
	
}


