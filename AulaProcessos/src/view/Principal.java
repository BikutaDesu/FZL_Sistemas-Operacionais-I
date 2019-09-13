package view;

import controller.ProcController;

public class Principal {

	public static void main(String[] args) {
		ProcController procController = new ProcController();
		String os = procController.getOS();
		System.out.println(os);
		
		String process = "regedit.exe";
		//procController.callProcess(process);
		
//		TASKLIST /FO TABLE - Tarefas
		//process = "ping -t www.google.com.br";
		//procController.getProcess(process);
		
		process = "notepad.exe";
		procController.killProcess(process);
		
		

	}

}
