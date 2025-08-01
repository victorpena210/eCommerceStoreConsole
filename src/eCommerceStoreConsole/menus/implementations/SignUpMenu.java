package eCommerceStoreConsole.menus.implementations;

import java.util.Scanner;

import eCommerceStoreConsole.entities.*;
import eCommerceStoreConsole.entities.implementations.DefaultUser;
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
		System.out.print("Please, enter your email: ");
		String email = scanner.next();
		
		User user = new DefaultUser(firstName, lastName, password, email);
		userManagementService.registerUser(user);
		}

	@Override
	public void printMenuHeader() {
		System.out.println("**** Signup Menu ****");
	}

}
