package eCommerceStoreConsole.menus.implementations;

import eCommerceStoreConsole.menus.Menu;
import eCommerceStoreConsole.configurations.*;
import eCommerceStoreConsole.entities.Order;
import eCommerceStoreConsole.services.*;
import eCommerceStoreConsole.services.implementations.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {
	
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		if(context.getLoggedInUser() == null) {
			System.out.println("Please, log in or create an account to see a list of your orders");
			new MainMenu().start();
			return;
		} else {
			printUserOrdersToConsole(); 
		}
		
	}
	
	private void printUserOrdersToConsole() {
		Order[] loggedInUserOrders = orderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
		
		if(loggedInUserOrders == null || loggedInUserOrders.length == 0) {
			System.out.println("unfortunately, you don't have any orders yet."
					+ "Navigate back to main menu to place a new order.");
		} else {
			for(Order order : loggedInUserOrders) {
				System.out.println(order + "\n");
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("**** MY ORDERS ****");
	}

}
