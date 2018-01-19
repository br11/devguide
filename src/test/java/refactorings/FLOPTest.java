package refactorings;

import org.junit.Before;
import org.junit.Test;

public class FLOPTest {

	FLOP flop;

	@Before
	public void setUp() throws Exception {
		flop = new FLOP();
	}

	@Test
	public void testCalculateBigDecimal() {
		System.out.println("resultado com BigDecimal: " + flop.calculateBigDecimal());
	}

	@Test
	public void testCalculateDouble() {
		System.out.println("resultado com double: " + flop.calculateDouble());
	}

	@Test
	public void testCalculateBigDecimalTime() {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100_000_000; i++) {
			flop.calculateBigDecimal();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("tempo com BigDecimal 15 casas dec.: " + (t2 - t1));
	}

	@Test
	public void testCalculateBigDecimalTimeP6() {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100_000_000; i++) {
			flop.calculateBigDecimal_P6();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("tempo com BigDecimal 6 casas dec.: " + (t2 - t1));
	}

	@Test
	public void testCalculateDoubleTime() {
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < 100_000_000; i++) {
			flop.calculateDouble();
		}
		long t2 = System.currentTimeMillis();
		System.out.println("tempo com double: " + (t2 - t1));
	}

}
