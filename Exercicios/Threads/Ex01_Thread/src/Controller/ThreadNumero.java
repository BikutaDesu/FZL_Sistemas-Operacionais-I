package Controller;

public class ThreadNumero extends Thread{
	
	private int n;
	
	public ThreadNumero(int n) {
		this.n = n;
	}
	
	@Override
	public void run() {
		System.out.printf("Meu n�mero �: %d\n", n);
	}
}
