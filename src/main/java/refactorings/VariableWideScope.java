package refactorings;

@SuppressWarnings("unused")
public class VariableWideScope {

	public static void main(String[] args) {
		double a = 3;
		double b = 4;
		double c = 7;
		double d = 13;
		double e = 25;
		double f = 14;

		/*
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 */

		double r = a + b;
		r = r / c;
		r = r + d;
		r = r / f;
		r = r - f / 14;
		
		System.out.println(r);
	}
}