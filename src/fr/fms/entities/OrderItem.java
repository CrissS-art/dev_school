package fr.fms.entities;

public class OrderItem {

	private int idOrderItem;
	private int idProduct;
	private int quantity;
	private int unitaryPrice;	
	private int idOrder;
	
	public OrderItem(int idOrderItem, int idProduct, int quantity, int unitaryPrice, int idOrder) {
		super();
		this.idOrderItem = idOrderItem;
		this.idProduct = idProduct;
		this.quantity = quantity;
		this.unitaryPrice = unitaryPrice;
		this.idOrder = idOrder;
	}

	@Override
	public String toString() {
		return "OrderItem [idOrderItem=" + idOrderItem + ", idProduct=" + idProduct + ", quantity=" + quantity
				+ ", unitaryPrice=" + unitaryPrice + ", idOrder=" + idOrder + "]";
	}

	public int getIdOrderItem() {
		return idOrderItem;
	}

	public void setIdOrderItem(int idOrderItem) {
		this.idOrderItem = idOrderItem;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitaryPrice() {
		return unitaryPrice;
	}

	public void setUnitaryPrice(int unitaryPrice) {
		this.unitaryPrice = unitaryPrice;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}
	

}
