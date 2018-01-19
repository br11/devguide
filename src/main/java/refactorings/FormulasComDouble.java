package refactorings;

public class FormulasComDouble {

	public static void main(String[] args) {
		Double fv = futureValue(100.0, 0.1, 12);
		System.out.println(fv);

	}

	private static Double futureValue(double presentValue, double interestRate, int periods) {
		return Math.pow(1 + interestRate, periods) * presentValue;
	}

	double calculate(double taxaJurosC1) {
		double taxaJurosNominal = Math.pow(1 + taxaJurosC1 / 1200, 12);
		return taxaJurosNominal;
	}
}
