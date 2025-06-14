package eCommerceStoreConsole.configurations;

import eCommerceStoreConsole.entities.User;
import eCommerceStoreConsole.menus.Menu;

public class ApplicationContext {
	
	private static ApplicationContext instance;
	
	private User loggedInUser;
	private Menu mainMenu;
	private Cart sessionCart;

}
