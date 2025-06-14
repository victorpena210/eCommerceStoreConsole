package eCommerceStoreConsole.entities;

public interface Cart {
	
	boolean isEmpty();
	
	void addProduct(Product productById);

	void clear();

}
