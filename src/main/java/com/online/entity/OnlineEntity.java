package com.online.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderDetails")
public class OnlineEntity {

	private int orderId;
	private String orderBrand;
	private String orderProduct;
	private float orderPrice;
	private String fromAddress;
	private String toAddress;
	private String orderUserName;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "OrderId")
	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Column(name = "OrderBrand")
	public String getOrderBrand() {
		return orderBrand;
	}

	public void setOrderBrand(String orderBrand) {
		this.orderBrand = orderBrand;
	}
	@Column(name = "OrderProduct")
	public String getOrderProduct() {
		return orderProduct;
	}

	public void setOrderProduct(String orderProduct) {
		this.orderProduct = orderProduct;
	}

	@Column(name = "OrderPrice")
	public float getOrderPrice() {
		return orderPrice;
	}

	

	public void setOrderPrice(float orderPrice) {
		this.orderPrice = orderPrice;
	}

	@Column(name = "FromAddress")
	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	@Column(name = "ToAddress")
	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	@Column(name = "OrderPersonName")
	public String getOrderUserName() {
		return orderUserName;
	}

	public void setOrderUserName(String orderUserName) {
		this.orderUserName = orderUserName;
	}

	public OnlineEntity(int orderId, String orderName, float orderPrice, String fromAddress, String toAddress,
			String brand, String orderProduct) {
		super();
		this.orderId = orderId;
		this.orderBrand = brand;
		this.orderPrice = orderPrice;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.orderProduct = orderProduct;
	}

	public OnlineEntity() {
		super();
	}

}
