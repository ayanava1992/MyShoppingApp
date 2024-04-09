package com.niit.MyOnlineBackend.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="My_Shopping_Address")
public class Address implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	@NotBlank(message = "PLEASE ENTER ADDRESS_LINE-1!!")
	@Column(name = "address_line_one")
	private String address_line1;
	
	@NotBlank(message = "PLEASE ENTER ADDRESS_LINE-2!!")
	@Column(name = "address_line_two")
	private String address_line2;
	
	@NotBlank(message = "PLEASE ENTER CITY!!")
	private String city;
	
	@NotBlank(message = "PLEASE ENTER STATE!!")
	private String state;
	
	@NotBlank(message = "PLEASE ENTER COUNTRY!!")
	private String country;
	
	@NotBlank(message = "PLEASE ENTER CORRECT PIN CODE!!")
	@Column(name ="postal_code")
	private String postalCode;
	
	@Column(name="is_shipping")
	private boolean shipping;
	
	@Column(name="is_billing")
	private boolean billing;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress_line1() {
		return address_line1;
	}

	public void setAddress_line1(String address_line1) {
		this.address_line1 = address_line1;
	}

	public String getAddress_line2() {
		return address_line2;
	}

	public void setAddress_line2(String address_line2) {
		this.address_line2 = address_line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public boolean isShipping() {
		return shipping;
	}

	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}

	public boolean isBilling() {
		return billing;
	}

	public void setBilling(boolean billing) {
		this.billing = billing;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Column(name = "user_id")
	private int userId;

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
