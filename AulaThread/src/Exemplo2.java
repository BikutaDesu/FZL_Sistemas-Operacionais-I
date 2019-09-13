
public class Exemplo2 {
	static int a = 10;
	static int b = 2;

	public static void calc(int a, int b, int opc) {
		int res = 0;
		String op = "";
		switch (opc) {
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
		
		int tempoEspera = (int) (Math.random() * 1000);
		
		try {
			Thread.sleep(tempoEspera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("%d %s %d = %d\n", a, op, b, res);
	}

	static Thread tSoma = new Thread() {
		public void run() {
			calc(a, b, 0);
		}
	};
	static Thread tSub = new Thread() {
		public void run() {
			calc(a, b, 1);		}
	};
	static Thread tMult = new Thread() {
		public void run() {
			calc(a, b, 2);		}
	};
	static Thread tDiv = new Thread() {
		public void run() {
			calc(a, b, 3);		}
	};

	public static void main(String[] args) {
		tSoma.start();
		tSub.start();
		tMult.start();
		tDiv.start();

	}
}
