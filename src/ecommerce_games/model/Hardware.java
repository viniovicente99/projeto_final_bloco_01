package ecommerce_games.model;

public class Hardware extends Product {

	private String brand;

	public Hardware(int id, String name, int type, double price, int stock, String brand) {
		super(id, name, type, price, stock);
		this.brand = brand;
	}

	public String getBrand() {
		return brand;
	}

	public void setType(String brand) {
		this.brand = brand;
	}

	public void viewProduct() {
		super.viewProduct();
		System.out.println("Marca do Hardware: " + this.brand);
	}

}
