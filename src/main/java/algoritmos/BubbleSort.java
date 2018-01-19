package algoritmos;

public class BubbleSort {

	public static void main(String[] args) {
		char[] dados1 = { 'H', 'A', 'F', 'D', 'B', 'I', 'C', 'G', 'K', 'E', 'J', 'L' };
		char[] dados2 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L' };
		char[] dados3 = { 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };
		char[] dados4 = new char[500];
		for (int i = 0; i < dados4.length; i++) {
			char c = (char) (65 + Math.round((Math.random() * 25)));
			dados4[i] = c;
		}
		char[] dados5 = new char[250];
		for (int i = 0; i < dados5.length; i++) {
			char c = (char) (249-i);
			dados4[i] = c;
		}
		
		ordenar(dados1);
		ordenar(dados2);
		ordenar(dados3);
		ordenar(dados4);
		ordenar(dados5);
	}

	private static void ordenar(char[] dados) {
		System.out.println("\n");
		System.out.println(dados);

		int esforco = 0;
		for (int i = 0; i < dados.length - 1; i++) {
			for (int j = 0; j < dados.length - 1; j++) {
				esforco++;
				if (dados[j + 1] < dados[j]) {
					char aux = dados[j];
					dados[j] = dados[j + 1];
					dados[j + 1] = aux;
				}
			}
		}

		System.out.println("esforco: " + esforco);
		System.out.println(dados);
	}
}
