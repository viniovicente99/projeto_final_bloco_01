package ecommerce_games;

import java.util.Scanner;

public class Menu {

	private static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

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

			option = input.nextInt();

			if (option == 0) {
				System.out.println("\nKabun com N - O maior e-commerce gamer do Brasil!");
				input.close();
				System.exit(0);
			}

			switch (option) {
			case 1:
				System.out.println("Cadastrar Produto\n\n");

				break;
			case 2:
				System.out.println("Listar todos os Produtos\n\n");

				break;
			case 3:
				System.out.println("Buscar Produto por ID\n\n");

				break;
			case 4:
				System.out.println("Atualizar Dados do Produto\n\n");

				break;
			case 5:
				System.out.println("Excluir Produto\n\n");

				break;
			default:
				System.out.println("\nOpção Inválida!\n");
				break;
			}

		}

	}

}
