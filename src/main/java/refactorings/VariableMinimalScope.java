package refactorings;

public class VariableMinimalScope {

	public static void main(String[] args) {
		double a = 3;
		double r = 4;		
		r = a + r;

		a = 7;
		r = r / a;

		a = 13;
		r = r + a;

		a = 14;
		r = r / a;
		r = r - a / 14;
		
		System.out.println(r);
	}
}