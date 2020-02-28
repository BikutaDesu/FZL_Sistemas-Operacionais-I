package controller;

import java.util.concurrent.Semaphore;

public class PessoaThread extends Thread {

	private int idThread;

	private int distMax = 200;
	private int distPer;

	private Semaphore semaphore;

	public PessoaThread(int idThread, Semaphore semaphore) {
		this.idThread = idThread;
		this.semaphore = semaphore;
		distPer = 0;
	}

	@Override
	public void run() {
		andar();
	}

	private void andar() {

		while (distPer < distMax) {
			int dist = (int) (Math.random() * 4);
			float temp = (float) (Math.random() * 2);

			distPer += dist;

			System.out.printf("Pessoa %d andou %d metros\n", idThread, distPer);

			try {
				System.out.printf("Pessoa %d esperando %.2fs\n", idThread, temp);
				Thread.sleep(1000 * (long) temp);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (distPer >= distMax) {
			try {
				semaphore.acquire();
				abrirPorta();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}
	}

	private void abrirPorta() {
		System.out.printf("Pessoa %d acaba de abrir a porta\n", idThread);
	}

}
