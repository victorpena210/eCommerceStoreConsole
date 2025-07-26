package eCommerceStoreConsole.menus.implementations;

import java.util.Scanner;

import eCommerceStoreConsole.configurations.ApplicationContext;
import eCommerceStoreConsole.menus.Menu;

public class ChangePasswordMenu implements Menu {
	
	private ApplicationContext context; 
	
	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		printMenuHeader();
		Scanner scanner = new Scanner(System.in);
		String userInput = scanner.next();
		context.getLoggedInUser().setPassword(userInput);
		System.out.println("Your pasword has been successfully updated.");
	}

	@Override
	public void printMenuHeader() {
		System.out.println("**** CHANGE PASSWORD");
		System.out.print("Enter new password: " );

	}

}
