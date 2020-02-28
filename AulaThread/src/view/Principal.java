package view;

import controller.ThreadCalcController;

public class Principal {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 2;
//		int operacao = 4;
		
		for (int operacao = 0; operacao < 4; operacao++) {
			Thread calcThread = new ThreadCalcController(a, b, operacao);
			calcThread.start();
		}
	}
}
