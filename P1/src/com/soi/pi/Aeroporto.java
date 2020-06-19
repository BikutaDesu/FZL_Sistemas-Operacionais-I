package com.soi.pi;

import java.util.concurrent.Semaphore;

public class Aeroporto {

	public static void main(String[] args) {
		Semaphore semaforoAreaDecolagem = new Semaphore(2);
		
		Semaphore[] semaforoPista = new Semaphore[2];
		for (int i = 0; i < semaforoPista.length; i++) {
			semaforoPista[i] = new Semaphore(1);
		}
		
		ThreadAviao[] aviao = new ThreadAviao[12];
		for (int i = 0; i < aviao.length; i++) {
			aviao[i] = new ThreadAviao(i, semaforoAreaDecolagem, semaforoPista);
			aviao[i].start();
		}
	}
}
