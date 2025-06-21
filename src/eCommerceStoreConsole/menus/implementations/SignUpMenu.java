package eCommerceStoreConsole.menus.implementations;

import java.util.Scanner;

import eCommerceStoreConsole.configurations.ApplicationContext;
import eCommerceStoreConsole.menus.Menu;
import eCommerceStoreConsole.services.UserManagementService;
import eCommerceStoreConsole.services.implementations.DefaultUserManagementService;

public class SignUpMenu implements Menu {
	
	private UserManagementService userManagementService;
	private ApplicationContext context;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		
		printMenuHeader();
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Please, enter your first name: ");
		String firstName = scanner.next();
		System.out.print("Please, enter your last name: ");
		String lastName = scanner.next();
		System.out.print("Please, enter your password: ");
		String password = scanner.next();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("**** Signup Menu ****");
	}

}
