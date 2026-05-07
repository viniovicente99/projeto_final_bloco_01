package ecommerce_games;

import java.util.InputMismatchException;
import java.util.Scanner;

import ecommerce_games.controller.ProductController;
import ecommerce_games.model.Game;
import ecommerce_games.model.Hardware;
import ecommerce_games.model.Product;

public class Menu {

	private static final Scanner input = new Scanner(System.in);
	private static final ProductController productController = new ProductController();

	public static void main(String[] args) {

		createTestProducts();

		int option;

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                KABUM COM N                			 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Cadastrar Produto                    ");
			System.out.println("            2 - Listar todos os Produtos             ");
			System.out.println("            3 - Buscar Produto por ID              	 ");
			System.out.println("            4 - Atualizar Dados do Produto           ");
			System.out.println("            5 - Excluir Produto                      ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			try {
				option = input.nextInt();
				input.nextLine();

			} catch (InputMismatchException e) {
				option = -1;
				System.out.println("\nDigite um número inteiro!");
				input.nextLine();
			}

			if (option == 0) {
				System.out.println("\nKabun com N - O maior e-commerce gamer do Brasil!");
				input.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println("Cadastrar Produto\n\n");

				registerProduct();

				keyPress();
				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");

				listProducts();

				keyPress();
				break;
			case 3:
				System.out.println("Buscar Produto por ID\n\n");

				searchProductById();

				keyPress();
				break;
			case 4:
				System.out.println("Atualizar Dados do Produto\n\n");

				editProduct();
				keyPress();
				break;
			case 5:
				System.out.println("Excluir Produto\n\n");
				
				deleteProduct();
				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida!\n");

				keyPress();
				break;
			}

		}

	}

	private static void listProducts() {

		productController.listAll();

	}

	public static void registerProduct() {

		System.out.println("Digite o nome do Produto: ");
		String name = input.nextLine();

		System.out.println("Digite o tipo do Produto (1 - Hardware | 2 - Jogo): ");
		int type = input.nextInt();

		System.out.println("Digite o Preço do Produto: ");
		float price = input.nextFloat();

		System.out.println("Digite a Quantidade em Estoque do Produto: ");
		int stock = input.nextInt();

		switch (type) {
		case 1 -> {
			System.out.println("Digite a Marca do Produto: ");
			input.nextLine();
			String brand = input.nextLine();
			productController.register(new Hardware(productController.generateId(), name, type, price, stock, brand));
		}
		case 2 -> {
			System.out.println("Digite a Plataforma do Jogo: ");
			input.nextLine();
			String platform = input.nextLine();
			productController.register(new Game(productController.generateId(), name, type, price, stock, platform));
		}
		default -> System.out.println("Tipo de Produto inválido!");
		}
	}

	public static void searchProductById() {

		System.out.print("Digite o ID do Produto: ");
		int id = input.nextInt();
		input.nextLine();

		productController.searchById(id);
	}

	public static void editProduct() {

		System.out.println("Digite o ID do Produto: ");
		int id = input.nextInt();
		input.nextLine();

		Product product = productController.searchInCollection(id);

		if (product != null) {

			String name = product.getName();
			int type = product.getType();
			double price = product.getPrice();
			int stock = product.getStock();

			System.out.printf("Nome atual: %s\nNovo Nome do Produto (pressione ENTER para manter): ", name);
			String userInput = input.nextLine();
			name = userInput.isEmpty() ? name : userInput;

			System.out.printf("Preço atual: %s\nNovo Preço do Produto (pressione ENTER para manter): ", price);
			userInput = input.nextLine();
			price = userInput.isEmpty() ? price : Float.parseFloat(userInput.replace(',', '.'));

			System.out.printf(
					"Estoque atual: %s\nNova Quantidade de Estoque do Produto (pressione ENTER para manter): ", stock);
			userInput = input.nextLine();
			stock = userInput.isEmpty() ? stock : Integer.parseInt(userInput);

			switch (type) {
			case 1 -> {
				String brand = ((Hardware) product).getBrand();

				System.out.printf("Marca atual: %s\nAlterar Marca do Hardware (pressione ENTER para manter): ", brand);
				userInput = input.nextLine();
				brand = userInput.isEmpty() ? brand : userInput;

				productController.edit(new Hardware(id, name, type, price, stock, brand));
			}
			case 2 -> {
				String platform = ((Game) product).getPlatform();

				System.out.printf("Plataforma atual: %s\nNova Plataforma do Jogo (pressione ENTER para manter): ",
						platform);
				userInput = input.nextLine();
				platform = userInput.isEmpty() ? platform : userInput;

				productController.edit(new Game(id, name, type, price, stock, platform));
			}
			default -> System.out.println("Tipo de Produto inválido!");
			}

		} else {
			System.out.printf("\nO Produto de ID %d não foi encontrada!\n", id);
		}

	}

	public static void deleteProduct() {

		System.out.print("Digite o ID do Produto: ");
		int id = input.nextInt();
		input.nextLine();

		System.out.print("\nTem certeza que deseja excluir este Produto? (S/N): ");
		String confirmation = input.nextLine();

		if (confirmation.equalsIgnoreCase("S")) {
			productController.delete(id);
		} else {
			System.out.print("\nOperação cancelada.");
		}
	}

	private static void createTestProducts() {
		productController.register(new Game(productController.generateId(), "Dying Light 2", 2, 189.00f, 20, "PC"));
		productController
				.register(new Hardware(productController.generateId(), "RX 7600 8GB", 1, 1899.00f, 100, "AMD"));
	}

	public static void keyPress() {
		System.out.println("\n\nPressione Enter para Continuar...");
		input.nextLine();
	}

}
