package refactorings;

import java.util.HashMap;
import java.util.Map;

/**
 * Let it crash.
 * 
 *
 * In systems design, a fail-fast system is one which immediately reports at its
 * interface any condition that is likely to indicate a failure.
 *
 *
 * Fault tolerance is the property that enables a system to continue operating
 * properly in the event of the failure of (or one or more faults within) some
 * of its components. If its operating quality decreases at all, the decrease is
 * proportional to the severity of the failure, as compared to a naively
 * designed system in which even a small failure can cause total breakdown.
 * 
 * Crash-only software refers to computer programs that handle failures by
 * simply restarting, without attempting any sophisticated recovery.
 */
public class ExceptionAccountService {

	/*
	 * 
	 *
	 *
	 */

	public static enum Reputation {
		VeryGood, Good, NoGood
	}

	public static class Costumer {
		String name;
		String account;

		@Override
		public String toString() {
			return "{'" + name + "', '" + account + "'}";
		}
	}

	Double tax = 2.0;
	Map<String, Double> accountBalances = new HashMap<>();

	/**
	 * <b>anx·ious</b> <br/>
	 * ˈaNG(k)SHəs/ <br/>
	 * adjective <br/>
	 * 1. experiencing worry, unease, or nervousness, typically about an imminent
	 * event or something with an uncertain outcome.<br/>
	 * 2. wanting something very much, typically with a feeling of unease.<br/>
	 */
	public Double getBalanceAnxious(Costumer c) {
		System.out.println("Costumer: " + c);
		Double balance = 0.0;
		if (c != null && c.account != null && c.account.length() >= 3) {
			balance = accountBalances.get(c.account.concat("-" + c.account.charAt(2)));
			if (balance != null) {
				balance -= tax;
			}
		}
		System.out.println("Balance: " + balance);
		return balance;
	}

	public Double getBalanceSafe(Costumer c) {
		System.out.println("Costumer: " + c);
		Double balance = 0.0;
		if (c != null && c.account != null) {
			balance = accountBalances.get(c.account.concat("-" + c.account.charAt(2)));
			if (balance != null) {
				balance -= tax;
			}
		}
		System.out.println("Balance: " + balance);
		return balance;
	}

	public Double getBalanceRisky(Costumer c) {
		System.out.println("Costumer: " + c);
		Double balance = invokeService(c);
		if (balance != null) {
			balance -= tax;
		}
		System.out.println("Balance: " + balance);
		return balance;
	}

	public double getBalanceFail(Costumer c) {
		System.out.println("Costumer: " + c);
		Double balance = invokeService(c);
		balance -= tax;
		System.out.println("Balance: " + balance);
		return balance;
	}

	private Double invokeService(Costumer c) {
		return accountBalances.get(c.account.concat("-" + c.account.charAt(2)));
	}
}
