package eCommerceStoreConsole.entities.implementations;

import java.util.Arrays;

import eCommerceStoreConsole.entities.Cart;
import eCommerceStoreConsole.entities.Product;

public class DefaultCart implements Cart {
	
	private static final int DEFAULT_PRODUCT_CAPACITY = 10;
	private Product[] products;
	private int lastIndex;
	
	{
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
		lastIndex = products.length - 1;
		
	}

	@Override
	public boolean isEmpty() {
		if (products == null || products.length == 0) {
			return true;
		}
		
		for (Product product : products) {
			if(product != null) {
				return false;
			}
		}
		return true;
	}
	

@Override
public void addProduct(Product product) {
    if (product == null) {
        return;
    }
    if (lastIndex >= products.length) {
        products = Arrays.copyOf(products, products.length * 2);  // Double the array size
    }
    products[lastIndex] = product;
    lastIndex++;  // Increment index after adding
}
	
	public Product[] getProducts() {
		int nonNullProductsAmount = 0;
		for (Product product : products) {
			if (product != null) {
				nonNullProductsAmount++;
			}
		}
		
		Product[] nonNullProducts = new Product[nonNullProductsAmount];
		int index = 0;
		for (Product product : products) {
			if(product != null) {
				nonNullProducts[index++] = product;
			}
		}
		return nonNullProducts;
	}

	@Override
	public void clear() {
		products = new Product[DEFAULT_PRODUCT_CAPACITY];
	}

}
