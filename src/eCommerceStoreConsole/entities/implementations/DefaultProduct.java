package eCommerceStoreConsole.entities.implementations;

import eCommerceStoreConsole.entities.Product;

public class DefaultProduct implements Product {
	
	private int id;
	private String productName;
	private String productCategory;
	private double price;
	
	public DefaultProduct() {
		
	}

	public DefaultProduct(int id, String productName, String productCategory, double price) {
		this.id = id;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "DefaultProduct [id=" + id + ", productName=" + productName + ", productCategory=" + productCategory
				+ ", price=" + price + "]";
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getProductName() {
		return this.productName;
	}

}
