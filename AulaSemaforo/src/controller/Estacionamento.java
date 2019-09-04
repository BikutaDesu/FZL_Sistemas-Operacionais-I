package controller;

import java.util.concurrent.Semaphore;

public class Estacionamento {

	public static void main(String[] args) {
		
		int permissoes = 3;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for (int idCarro = 0; idCarro < 10; idCarro++) {
			Thread carro = new ThreadCarro(idCarro, semaforo);
			carro.start();
		}
	}

}