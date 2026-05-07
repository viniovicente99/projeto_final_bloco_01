package ecommerce_games.model;

public abstract class Product {

	private int id;
	private String name;
	private int type;
	private double price;
	private int stock;

	public Product(int id, String name, int type, double price, int stock) {
		this.id = id;
		this.name = name;
		this.type  = type;
		this.price = price;
		this.stock = stock;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return type;
	}

	public void setName(int type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public void viewProduct() {
		
		String type = "";

		switch (this.type) {
		case 1:
			type = "Hardware";
			break;
		case 2:
			type = "Jogo";
			break;
		}

		System.out.println("\n\n***********************************************************");
		System.out.println("Dados do Produto:");
		System.out.println("***********************************************************");
		System.out.println("ID do Produto: " + this.id);
		System.out.println("Nome do Produto: " + this.name);
		System.out.println("Tipo do Produto: " + type);
		System.out.printf("Preço do Produto: R$ %.2f%n", this.price);
		System.out.println("Quantidade em Estoque: " + this.stock);

	}

}
