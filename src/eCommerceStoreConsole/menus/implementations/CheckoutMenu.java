package eCommerceStoreConsole.menus.implementations;

import eCommerceStoreConsole.menus.Menu;
import eCommerceStoreConsole.services.OrderManagementService;
import eCommerceStoreConsole.services.ProductManagementService;
import eCommerceStoreConsole.services.implementations.DefaultOrderManagementService;
import eCommerceStoreConsole.services.implementations.DefaultProductManagementService;

import java.util.Scanner;

import eCommerceStoreConsole.configurations.ApplicationContext;
import eCommerceStoreConsole.entities.*;
import eCommerceStoreConsole.entities.implementations.*;

public class CheckoutMenu implements Menu {
	
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	

	@Override
	public void start() {
		while (true) {
			printMenuHeader();
			Scanner scanner = new Scanner(System.in);
			String userCreditCardNumber = scanner.next();
			
			createOrder(userCreditCardNumber);
			System.out.println("allDone");
			new MainMenu().start();
		}
	}
	
	private boolean createOrder(String creditCardNumber) {
		Order order = new DefaultOrder();
		if (!order.isCreditCardNumberValid(creditCardNumber)) {
			System.out.println("invalid card Number");
			return false;
		}

		order.setCreditCardNumber(creditCardNumber);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCustomerId(context.getLoggedInUser().getId());
		orderManagementService.addOrder(order);
		
		return true;
		
	}
	


	@Override
	public void printMenuHeader() {
		System.out.println("**** CHECKOUT ****");
		System.out.print("Enter your credit card number without spaces and press enter if you confirm purchase: ");

	}

}
