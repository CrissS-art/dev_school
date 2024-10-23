package entites;

public class Product {

//	attributes
	private int idProduct;
	private String name;
	private String description;
	private int length;
	private String type;
	private int price;
	
//	constructors
	public Product(int idProduct, String name, String description, int length, String type, int price) {
		this.idProduct = idProduct;
		this.name = name;
		this.description = description;
		this.length = length;
		this.type = type;
		this.price = price;
	}
	public Product(String name, String description, int length, String type, int price) {
		this.name = name;
		this.description = description;
		this.length = length;
		this.type = type;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", description=" + description + ", length="
				+ length + ", type=" + type + ", price=" + price + "]";
	}
	public int getIdProduct() {
		return idProduct;
	}
	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
