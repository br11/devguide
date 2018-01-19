package refactorings;

import org.junit.Before;
import org.junit.Test;

import refactorings.ExceptionAccountService.Costumer;

public class ExceptionAccountServiceSafeTest {

	ExceptionAccountService accService;
	Costumer c;

	@Before
	public void setUp() throws Exception {
		accService = new ExceptionAccountService();
		accService.accountBalances.put("001-1", 10.0);
		accService.accountBalances.put("002-2", 0.0);
		accService.accountBalances.put("003-3", null);
		accService.accountBalances.put(null, 20.0);

		accService.tax = 2.0;

		c = new Costumer();
	}

	@Test
	public void testGetBalanceSafe_001() {
		c.name = "João";
		c.account = "001";
		accService.getBalanceSafe(c);
	}

	@Test
	public void testGetBalanceSafe_002() {
		c.name = "João";
		c.account = "002";
		accService.getBalanceSafe(c);
	}

	@Test
	public void testGetBalanceSafe_003() {
		c.name = "João";
		c.account = "003";
		accService.getBalanceSafe(c);
	}

	@Test
	public void testGetBalanceSafe_nullAccount() {
		c.name = null;
		c.account = null;
		accService.getBalanceSafe(c);
	}

	@Test
	public void testGetBalanceSafe_nullCustomer() {
		c = null;
		accService.getBalanceSafe(c);
	}

	@Test
	public void testGetBalanceSafe_nullBalance() {
		accService.accountBalances.replace(null, null);
		c.account = null;
		accService.getBalanceSafe(c);
	}

	@Test
	public void testGetBalanceSafe_invalidAccount() {
		c.account = "01";
		accService.getBalanceSafe(c);
	}

}
