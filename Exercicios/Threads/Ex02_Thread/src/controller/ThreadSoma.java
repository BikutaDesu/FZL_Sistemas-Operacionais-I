package controller;

public class ThreadSoma extends Thread{

	private int linha;
	private int[][] m;
	
	public ThreadSoma(int linha, int[][] m) {
		this.linha = linha;
		this.m = m;
	}
	
	private void somarLinha() {
		int r = 0;
		for (int i = 0; i < m[linha].length; i++) {
			r+= m[linha][i];
		}
		System.out.printf("A soma da linha %d é %d\n", linha, r);
	}
	
	@Override
	public void run() {
		somarLinha();
	}
	
}
