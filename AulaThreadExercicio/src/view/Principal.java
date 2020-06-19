package view;

import controller.ThreadController;

public class Principal {

	public static void main(String[] args) {
		
		for (int i = 0; i < 100; i++) {
			Thread threadController = new ThreadController(i);
			threadController.start();
		}
		
	}
	
}
