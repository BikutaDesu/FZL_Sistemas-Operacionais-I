package view;

import java.util.concurrent.Semaphore;

import controller.PessoaThread;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaphore = new Semaphore(1);
		PessoaThread[] listPessoa = new PessoaThread[4];
		
		for (int i = 0; i < listPessoa.length; i++) {
			listPessoa[i] = new PessoaThread(i, semaphore);
			listPessoa[i].start();
		}
	}

}
