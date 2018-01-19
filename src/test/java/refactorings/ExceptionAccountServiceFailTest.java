package refactorings;

import org.junit.Before;
import org.junit.Test;

import refactorings.ExceptionAccountService.Costumer;

public class ExceptionAccountServiceFailTest {

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
	public void testGetBalanceFail_001() {
		c.name = "João";
		c.account = "001";
		accService.getBalanceFail(c);
	}

	@Test
	public void testGetBalanceFail_002() {
		c.name = "João";
		c.account = "002";
		accService.getBalanceFail(c);
	}

	@Test
	public void testGetBalanceFail_003() {
		c.name = "João";
		c.account = "003";
		accService.getBalanceFail(c);
	}

	@Test
	public void testGetBalanceFail_nullAccount() {
		c.name = null;
		c.account = null;
		accService.getBalanceFail(c);
	}

	@Test
	public void testGetBalanceFail_nullCustomer() {
		c = null;
		accService.getBalanceFail(c);
	}

	@Test
	public void testGetBalanceFail_nullBalance() {
		accService.accountBalances.replace(null, null);
		c.account = null;
		accService.getBalanceFail(c);
	}
	
	@Test
	public void testGetBalanceFail_invalidAccount() {
		c.account = "01";
		accService.getBalanceFail(c);
	}

}
