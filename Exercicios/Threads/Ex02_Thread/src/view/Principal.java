package view;

import java.util.Random;

import controller.ThreadSoma;

public class Principal {

	public static void main(String[] args) {
		
		int[][] m = new int[3][5];
		
		Random random = new Random();
		
		Thread[] tSomaList = new ThreadSoma[3];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = random.nextInt(100);
			}
		}
		
		for (int i = 0; i < tSomaList.length; i++) {
			tSomaList[i] = new ThreadSoma(i, m);
			tSomaList[i].start();
		}
		
	}
	
}
