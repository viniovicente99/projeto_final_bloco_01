package ecommerce_games.model;

public class Game extends Product {

	private String platform;

	public Game(int id, String name, int type, double price, int stock, String platform) {
		super(id, name, type, price, stock);
		this.platform = platform;

	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public void viewProduct() {
		super.viewProduct();
		System.out.println("Plataforma do Jogo: " + this.platform);
	}

}
