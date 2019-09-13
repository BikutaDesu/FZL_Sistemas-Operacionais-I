package view;

import java.util.Scanner;

import controller.ProcessController;

public class Main {

	public static void main(String[] args) {
		ProcessController processController = new ProcessController();
		Scanner sc = new Scanner(System.in);
		String osName = processController.getOS();
		
		int opc = 0;
		System.out.println("----------Ex 02----------");
		System.out.println("Olá, digite o número correspondente a ação do menu");
		do {
			System.out.println("\n1 - listar processos");
			System.out.println("2 - matar processo");
			System.out.print("escolha: ");
			opc = sc.nextInt();
			if (opc == 1) {
				processController.getProcesses(osName);
			}else if (opc == 2) {
				System.out.println("Digite o nome ou PID do processo");
				String processName = sc.next();
				processController.killProcess(processName, osName);
			}else if (opc < 0 || opc > 2) {
				System.out.println("Digite uma opção válida... \n\n");
			}
		} while (opc != 0);
		
		
	}

}
