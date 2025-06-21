package eCommerceStoreConsole.menus.implementations;

import eCommerceStoreConsole.entities.User;
import eCommerceStoreConsole.menus.Menu;
import eCommerceStoreConsole.services.UserManagementService;
import eCommerceStoreConsole.services.implementations.DefaultUserManagementService;

public class CustomerListMenu implements Menu {
	
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		User[] users = userManagementService.getUsers();
		
		if (users.length == 0) {
			System.out.println("Unfortunately, there are no customers");
		} else {
			for (User user : users) {
				System.out.println(user);
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println();
		System.out.println("**** USERS ****");
	}
}
