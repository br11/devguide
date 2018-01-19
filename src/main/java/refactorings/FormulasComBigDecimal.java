package refactorings;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class FormulasComBigDecimal {

	static MathContext MATH_CONTEXT = new MathContext(15, RoundingMode.HALF_UP);
	static BigDecimal BIG_1 = new BigDecimal("1");

	public static void main(String[] args) {
		BigDecimal fv = futureValue(new BigDecimal("100"), new BigDecimal("0.1"), 12);
		System.out.println(fv);
	}

	private static BigDecimal futureValue(BigDecimal presentValue, BigDecimal interestRate, int periods) {
		return presentValue.multiply(BIG_1.add(interestRate, MATH_CONTEXT).pow(12), MATH_CONTEXT);
	}

	BigDecimal calculate(BigDecimal taxaJurosC1) {
		MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
		BigDecimal taxaJurosNominal = new BigDecimal("1").add(taxaJurosC1.divide(new BigDecimal("1200"), mc)).pow(12)
				.subtract(new BigDecimal("1")).round(mc);
		return taxaJurosNominal;
	}
}
