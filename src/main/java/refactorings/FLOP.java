package refactorings;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Frederick Brooks’ “The Mythical Man-Month” p. 102.
 * 
 * Representation is the Essence of Programming
 * 
 * Much more often, strategic breakthrough will come from redoing the
 * representation of the data or tables. This is where the heart of your program
 * lies. Show me your flowcharts and conceal your tables, and I shall be
 * continued to be mystified. Show me your tables, and I won’t usually need your
 * flowcharts; they’ll be obvious.
 *
 * Frederick Brooks’ “The Mythical Man-Month” p. 102.
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
