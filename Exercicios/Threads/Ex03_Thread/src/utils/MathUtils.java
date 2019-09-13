package utils;

public class MathUtils {
	
	public static int Bezier(float t, int[] pointList) {
		
		int n = pointList.length-1;
		int finalPoint = 0;
		
		for (int i = 0; i <= n; i++) {
			finalPoint += (int) (coeficienteBinomial(n, i) * Math.pow((1 - t), n - i) * Math.pow(t, i) * pointList[i]);
		}
		
		return finalPoint;
	}
	
	private static float coeficienteBinomial(int n, int i) {
		int c = 0;
		c = fatorial(n) / (fatorial(i) * fatorial(n - i));
		return c;
	}

	private static int fatorial(int n) {
		int fact = 1;
		for (int i = 2; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}
	
}
