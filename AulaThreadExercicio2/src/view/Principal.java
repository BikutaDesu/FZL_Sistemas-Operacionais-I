package view;

import java.util.Random;

import controller.ThreadConversaoController;

public class Principal {

	public static void main(String[] args) {

		Random rand = new Random();
		int[] codigos = new int[10];
		float[] temperaturas = new float[10];
		
		for (int i = 0; i < 10; i++) {
			codigos[i] = rand.nextInt(3) + 1;
			temperaturas[i] = rand.nextFloat() * 50;
			
			Thread threadConversao = new ThreadConversaoController(codigos[i], temperaturas[i], i);
			threadConversao.start();
		}
		
	}

}
