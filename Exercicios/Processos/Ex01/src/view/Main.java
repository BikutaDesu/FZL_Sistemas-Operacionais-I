package view;

import java.util.Scanner;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		RedesController redesController = new RedesController();
		
		int opc = 0;
		do {
			System.out.println("----------Ex 01----------");
			System.out.println("Olá, digite o número correspondente a ação do menu");
			System.out.println("1 - ping");
			System.out.println("2 - listar os IPs");
			System.out.println("0 - sair");
			System.out.print("escolha: ");
			opc = sc.nextInt();
			if (opc == 1) {
				System.out.println("Informe o site...");
				String site = sc.next();
				System.out.println("\nTempo de resposta: ");
				System.out.println(redesController.getPing(site));
			}else if(opc == 2) {
				System.out.println("\nLista de IPs: ");
				System.out.println(redesController.getIP());
			}else if (opc < 0 || opc > 2) {
				System.out.println("Digite uma opção válida... \n\n");
			}
		} while (opc != 0);
		System.out.println("Encerrando...");
		
	}

}
