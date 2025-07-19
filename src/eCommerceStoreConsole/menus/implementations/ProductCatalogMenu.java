package eCommerceStoreConsole.menus.implementations;

import java.lang.reflect.Array;
import java.util.Scanner;

import eCommerceStoreConsole.configurations.ApplicationContext;
import eCommerceStoreConsole.entities.Cart;
import eCommerceStoreConsole.entities.Product;
import eCommerceStoreConsole.entities.implementations.DefaultProduct;
import eCommerceStoreConsole.menus.Menu;
import eCommerceStoreConsole.services.OrderManagementService;
import eCommerceStoreConsole.services.ProductManagementService;
import eCommerceStoreConsole.services.implementations.DefaultOrderManagementService;
import eCommerceStoreConsole.services.implementations.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {
	
	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		Menu menuToNavigate = null;
		
		while (true) {
			printMenuHeader();
			printProductsToConsole();
			
			String userInput = readUserInput();
			if (context.getLoggedInUser() == null) {
				menuToNavigate = new MainMenu();
				System.out.println("you are not logged in. please, sign in or create account");
			} 
			
			Product productToAddToCart = fetchProduct(userInput);
			productToAddToCart(productToAddToCart);
			
			
				System.out.println("TEST");
				
				Product[] usersCartTest = context.getSessionCart().getProducts();
				for(Product product: usersCartTest) {
					System.out.println("test " + product.getProductName() + " test");
				}

				System.out.println("TEST");

					
		}
	
	}
	
	private Product fetchProduct(String userInput) {
		int productIdToAddToCart = Integer.parseInt(userInput);
		Product productToAddToCart = productManagementService.getProductsById(productIdToAddToCart);
		return productToAddToCart;

	}
	
	
	private void productToAddToCart(Product productToAddToCart) {
		context.getSessionCart().addProduct(productToAddToCart);
		System.out.printf("Product %s has been added to your cart. "
				+ "If you want to add a new product - enter the product id."
				+ "If you want to proceed with checkout - enter word CHECKOUT"
				+ "console %n", productToAddToCart.getProductName());
		}



	private String readUserInput() {
		System.out.print("Product ID to add to cart or enter CHECKOUT to proceed with checkout: ");
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		return userInput;
	}

	private void printProductsToConsole() {
		Product[] products = productManagementService.getProducts();
		for(Product product : products) {
			System.out.println(product);
		}
	}
	

	@Override
	public void printMenuHeader() {
		System.out.println();
		System.out.println("**** PRODUCT CATALOG ****");
		System.out.println("Enter Product ID to add it to the cart");

	}

}
