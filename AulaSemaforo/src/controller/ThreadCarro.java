package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	
	private int idCarro;
	private static int posChegada;
	private static int posSaida;
	
	private Semaphore semaforo;
	
	public ThreadCarro(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro; 
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		moverCarro();
		try {
			semaforo.acquire();
			pararCarro(); // Só 3 Threads podem executar este método por vez
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			sairCarro();
		}
	}
	
	private void moverCarro() {
		int distFinal = (int)((Math.random() * 2001) + 1000);
		int variacaoDist = 100;
		int tempo = 30;
		int distPercorrida = 0;
		
		while(distPercorrida < distFinal) {
			distPercorrida += variacaoDist;
			
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.printf("Carro #%d já andou %d m.\n", idCarro, distPercorrida);
		}
		posChegada++;
		System.out.printf("O carro #%d foi o %d° a chegar\n", idCarro, posChegada);
	}
	
	private void pararCarro() {
		System.out.printf("O carro #%d estacionou!\n", idCarro);
		int tempoParado = (int)((Math.random() * 2001) + 2000);
		
		try {
			Thread.sleep(tempoParado);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void sairCarro() {
		posSaida++;
		System.out.printf("O carro %d foi o %d° a sair.\n", idCarro, posSaida);
	}
}
