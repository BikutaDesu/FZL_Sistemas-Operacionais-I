
public class Exemplo1 {
	static int a = 8;
	static int b = 3;
	
	static Thread tSoma = new Thread() {
		public void run() {
			int res = a + b;
			System.out.printf("%d + %d = %d\n", a, b, res);
		}
	};
	static Thread tSub = new Thread() {
		public void run() {
			int res = a - b;
			System.out.printf("%d - %d = %d\n", a, b, res);
		}
	};
	static Thread tMult = new Thread() {
		public void run() {
			int res = a * b;
			System.out.printf("%d * %d = %d\n", a, b, res);
		}
	};
	static Thread tDiv = new Thread() {
		public void run() {
			float res = a / b;
			System.out.printf("%d / %d = %.2f\n", a, b, res);
		}
	};
	
	public static void main(String[] args) {
		tSoma.start();
		tSub.start();
		tMult.start();
		tDiv.start();
		
	}
}
