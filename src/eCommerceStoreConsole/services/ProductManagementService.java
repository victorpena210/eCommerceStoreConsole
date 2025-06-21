package eCommerceStoreConsole.services;

import eCommerceStoreConsole.entities.Product;

public interface ProductManagementService {
	
	Product[] getProducts();
	
	Product getProductsById(int productIdToAddToCart);

}
