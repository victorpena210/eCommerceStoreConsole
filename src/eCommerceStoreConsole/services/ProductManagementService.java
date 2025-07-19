package eCommerceStoreConsole.services;

import eCommerceStoreConsole.entities.Product;

public interface ProductManagementService {
	
	Product[] addToCart(Product product);
	
	Product[] getProducts();
	
	Product getProductsById(int productId);

}
