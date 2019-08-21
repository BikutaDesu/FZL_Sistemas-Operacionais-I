package view;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redesController = new RedesController();
		
		System.out.println(redesController.getIP());
		
		System.out.println(redesController.getPing("www.google.com.br"));
	}

}
