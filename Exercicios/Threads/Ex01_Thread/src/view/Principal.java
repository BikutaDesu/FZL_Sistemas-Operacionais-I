package view;

import Controller.ThreadNumero;

public class Principal {

	public static void main(String[] args) {
		Thread[] threadList = new ThreadNumero[5];
		
		for (int i = 0; i < threadList.length; i++) {
			threadList[i] = new ThreadNumero(i);
			threadList[i].start();
		}
	}
	
}
