package ecommerce_games.controller;

import java.util.ArrayList;
import java.util.List;

import ecommerce_games.model.Product;
import ecommerce_games.repository.ProductRepository;

public class ProductController implements ProductRepository {

	private List<Product> productsList = new ArrayList<Product>();
	int id = 0;

	@Override
	public void listAll() {
		for (var product : productsList) {
			product.viewProduct();
		}

	}

	@Override
	public void searchById(int id) {

		var product = searchInCollection(id);

		if (product != null) {
			product.viewProduct();
		} else {
			System.out.printf("\nA Produto de ID: %d não foi encontrado!%n", id);
		}

	}

	@Override
	public void register(Product product) {

		productsList.add(product);
		System.out.printf("O Produto %s foi criada com sucesso!%n", product.getName());

	}

	@Override
	public void edit(Product product) {

		var searchProduct = searchInCollection(product.getId());

		if (searchProduct != null) {
			productsList.set(productsList.indexOf(searchProduct), product);
		} else {
			System.out.printf("O Produto de Id: %d não foi encontrado!%n", id);
		}

	}

	@Override
	public void delete(int id) {

		var product = searchInCollection(id);

		if (product != null) {
			if (productsList.remove(product) == true) {
				System.out.printf("O Produto de ID: %d foi deletada com sucesso!%n", id);
			}
		} else {
			System.out.printf("O Produto de ID: %d não foi encontrado!%n", id);
		}

	}

	public int generateId() {
		return ++id;
	}

	public Product searchInCollection(int id) {
		for (var product : productsList) {
			if (product.getId() == id) {
				return product;
			}
		}

		return null;
	}

}
