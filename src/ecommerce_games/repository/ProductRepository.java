package ecommerce_games.repository;

import ecommerce_games.model.Product;

public interface ProductRepository {
	
	public void listAll();
	public void searchById(int id);
	public void register(Product product);	
	public void edit(Product product);
	public void delete(int id);

}
