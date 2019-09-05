package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{
	
	private int idCarro;
	private String dirInicio;
	private String dirDestino;
	
	private Semaphore semaforo;
	
	public ThreadCarro(int idCarro, String dirInicio, String dirDestino, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.dirInicio = dirInicio;
		this.dirDestino = dirDestino;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {

	}
	
	private void moverCarro() {
		
	}
	
	private void pararCarro() {
		
	}
	
	private void sairCarro() {
		
	}
	
}
