package com.soi.pi;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class ThreadAviao extends Thread {

	private int idAviao;

	private Semaphore semaforoAreaDecolagem;
	private Semaphore[] semaforoPista;
	private String[] direcaoPista = {"Norte", "Sul"};
	private int tempo;

	public ThreadAviao(int idAviao, Semaphore semaphoreAeroporto, Semaphore[] semaphorePista) {
		this.idAviao = idAviao;
		this.semaforoAreaDecolagem = semaphoreAeroporto;
		this.semaforoPista = semaphorePista;
	}

	@Override
	public void run() {
		irAreaDecolagem();
	}
	
	private void irAreaDecolagem() {
		int idPista = new Random().nextInt(2);
		try {
			semaforoAreaDecolagem.acquire();
			System.out.printf("O Avião #%d está indo para a área de decolagem!\n", idAviao);
			
			if (!semaforoPista[idPista].tryAcquire()) {
				if (idPista == 0) {
					idPista = 1;
					semaforoPista[idPista].acquire();
				}else {
					idPista = 0;
					semaforoPista[idPista].acquire();
				}
				
			}
			System.out.printf("O Avião #%d vai para a pista %s!\n", idAviao, direcaoPista[idPista]);
			
			manobrarAviao();
		}catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforoPista[idPista].release();
			semaforoAreaDecolagem.release();
		}
		
	}

	
	private void manobrarAviao() {
		System.out.printf("O Avião #%d está manobrando!\n", idAviao);
		tempo = (int)((Math.random() * 4001) + 3000);
		esperar(tempo);
		taxiarAviao();
	}

	private void taxiarAviao() {
		System.out.printf("O Avião #%d está taxiando!\n", idAviao);
		tempo = (int)((Math.random() * 5001) + 5000);
		esperar(tempo);
		decolarAviao();
	}

	private void decolarAviao() {
		System.out.printf("O Avião #%d está decolando!\n", idAviao);
		tempo = (int)((Math.random() * 3001) + 1000);
		esperar(tempo);
		afastarAviao();
	}

	private void afastarAviao() {
		tempo = (int)((Math.random() * 5001) + 3000);
		esperar(tempo);
		System.out.printf("O Avião #%d está se afastando do aeroporto!\n", idAviao);
	}
	
	private void esperar(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
