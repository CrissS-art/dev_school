package fr.fms.entities;

import java.util.Date;

public class Order {
	private int idOrder;
	private Date date;
	private int totalAmount;
	private int idCustomer;
	public Order(int idOrder, Date date, int totalAmount, int idCustomer) {
		super();
		this.idOrder = idOrder;
		this.date = date;
		this.totalAmount = totalAmount;
		this.idCustomer = idCustomer;
	}
	public Order(Date date, int totalAmount, int idCustomer) {
		super();
		this.date = date;
		this.totalAmount = totalAmount;
		this.idCustomer = idCustomer;
	}
	@Override
	public String toString() {
		return "Order [idOrder=" + idOrder + ", date=" + date + ", totalAmount=" + totalAmount + ", idCustomer="
				+ idCustomer + "]";
	}
	public int getIdOrder() {
		return idOrder;
	}
	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}
	

	}
