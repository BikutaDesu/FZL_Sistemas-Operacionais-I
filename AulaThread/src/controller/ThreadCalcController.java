package controller;

public class ThreadCalcController extends Thread {

	private int a;
	private int b;
	private int operacao;

	public ThreadCalcController(int a, int b, int operacao) {
		this.a = a;
		this.b = b;
		this.operacao = operacao % 4;
	}

	private void calcular() {
		String op = "";
		int res = 0;
		switch (operacao) {
		case 0:
			res = a + b;
			op = "+";
			break;
		case 1:
			res = a - b;
			op = "-";
			break;
		case 2:
			res = a * b;
			op = "*";
			break;
		case 3:
			res = a / b;
			op = "/";
			break;
		}
		System.out.printf("%d %s %d = %d\n", a, op, b, res);
	}

	@Override
	public void run() {
		calcular();
	}
}
