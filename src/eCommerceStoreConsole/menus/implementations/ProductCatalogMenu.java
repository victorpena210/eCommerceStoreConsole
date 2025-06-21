package eCommerceStoreConsole.menus.implementations;

import eCommerceStoreConsole.configurations.ApplicationContext;
import eCommerceStoreConsole.entities.Product;
import eCommerceStoreConsole.menus.Menu;
import eCommerceStoreConsole.services.ProductManagementService;
import eCommerceStoreConsole.services.implementations.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {
	
	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;
	
	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		Menu menuToNavigate = null;
		while (true) {
			printMenuHeader();
			printProductsToConsole();
		}
	
	}
	
	private void printProductsToConsole() {
		Product[] products = productManagementService.getProducts();
	}
	

	@Override
	public void printMenuHeader() {
		System.out.println();
		System.out.println("**** PRODUCT CATALOG ****");
		System.out.println("Enter Product ID to add it to the cart");

	}

}
