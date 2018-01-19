package refactorings;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * 
 * 
 */
public class FLOP {

	public BigDecimal calculateBigDecimal() {
		MathContext mc = new MathContext(15, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal("1.1").add(new BigDecimal("2.2"), mc).subtract(
				new BigDecimal("3.3").multiply(new BigDecimal("4.4"), mc).divide(new BigDecimal("5.5"), mc), mc);
		return result;
	}

	public BigDecimal calculateBigDecimal_P6() {
		MathContext mc = new MathContext(6, RoundingMode.HALF_UP);
		BigDecimal result = new BigDecimal("1.1").add(new BigDecimal("2.2"), mc).subtract(
				new BigDecimal("3.3").multiply(new BigDecimal("4.4"), mc).divide(new BigDecimal("5.5"), mc), mc);
		return result;
	}

	public double calculateDouble() {
		double result = 1.1 + 2.2 - 3.3 * 4.4 / 5.5;
		return result;
	}

}
