package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
		ProcController procController = new ProcController();
		System.out.printf("SO: %s \n", procController.getOS());
		System.out.printf("Versão: %s \n", procController.getOsVersion());
		System.out.printf("Arquitetura: %s \n", procController.getOsArch());
		System.out.println();

		String process = "mspaint.exe";
//		procController.callProcess(process);
		procController.readProcess("tasklist /fo table");
		
//		TASKLIST /FO TABLE - Tarefas
//		process = "ping -t www.google.com.br";
//		procController.getProcess(process);
		
		process = "notepad.exe";
		procController.killProcess(process);
		
	}

}