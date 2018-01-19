package doubleprecision;

/**
 * Exorcismo de números de ponto flutuante.
 */
public class DoubleExorcist {

	static int SIGNIFICANDS = 16;
	static int DISCARD = 3;
	static int ADJUSTMENT = SIGNIFICANDS - DISCARD;
	
	/**
	 * Recebe um numero possuido e o retorna liberto.
	 */
	public static double exorcise(double possessedNumber) {
		int log10 = (int) Math.rint(Math.log10(possessedNumber));
		double precisionDecrement = Math.pow(10, (ADJUSTMENT - log10));
		double freeNumber = Math.rint(possessedNumber * precisionDecrement) / precisionDecrement;
		return freeNumber;
	}

	public static void main(String[] args) {

		double[] results = new double[9];
		results[0] = 1.10 - 0.25;
		results[1] = 10.0 / 3.0;
		results[2] = 1000000.0 / 3.0 + 0.0000000002;
		results[3] = 2.8 + 0.17;
		results[4] = 1.00000000000001;
		results[5] = 1.000000000000001;
		results[6] = 1.0000000000000001;
		results[7] = 1.0000000000000005;
		results[8] = 1.000000000000005;

		for (double result : results) {
			// System.out.println(result + "\n" + exorcise(result) + "\n");
		}

		test1();
		
		test2();

	}

	private static void test1() {
		double num1 = 0;
		num1 += 2.8 + 0.17;
		System.out.println(num1 + "\n" + exorcise(num1) + "\n");
		for (int i = 1; i < 100_000_000; i++) {
			num1 += 2.8 + 0.17;
		}
		System.out.println(num1 + "\n" + exorcise(num1) + "\n");
		System.out.println(num1 * 100_000_000 + "\n");
	}

	private static void test2() {
		double num1 = 0;
		num1 += 2.8 + 0.17;
		System.out.println(num1 + "\n" + exorcise(num1) + "\n");
		for (int i = 1; i < 100_000_000; i++) {
			num1 += exorcise(2.8 + 0.17);
		}
		System.out.println(num1 + "\n" + exorcise(num1) + "\n");
		System.out.println((2.8 + 0.17) * 100_000_001 + "\n");
	}
}
