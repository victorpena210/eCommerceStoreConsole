package eCommerceStoreConsole;

import eCommerceStoreConsole.menus.Menu;
import eCommerceStoreConsole.menus.implementations.MainMenu;


public class Main {

	public static final String EXIT_COMMAND = "exit";
	
	public static void main(String[] args) {
		Menu mainMenu = new MainMenu();
		mainMenu.start();	
		}

}
