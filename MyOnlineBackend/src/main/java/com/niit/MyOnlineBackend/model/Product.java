package com.niit.MyOnlineBackend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="My_Shopping_Product")
public class Product 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="Product_Code")
	private String code;
	
	@Column(name="Product_Name")
	private String name;
	
	@Column(name="Product_Brand")
	private String brand;
	
	@Column(name="Product_Description")
	private String description;
	
	@Column(name="Product_Unit_Price")
	private double unit_price;
	
	@Column(name="Product_Quantity")
	private int quantity;
	
	@Column(name="Is_Active")
	private boolean active;
	
	@Column(name="Product_Category_Id")
	private int category_id;
	
	@Column(name="Product_Supplier_Id")
	private int supplier_id;
	
	public Product()
	{
		code="PRD"+ UUID.randomUUID().toString().substring(24);
	}
	public double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getSupplier_id() {
		return supplier_id;
	}
	public void setSupplier_id(int supplier_id) {
		this.supplier_id = supplier_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
