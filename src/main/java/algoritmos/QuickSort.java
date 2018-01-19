package algoritmos;

public class QuickSort {

	static int esforco = 0;
	static int vezes = 0;

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

	static void ordenar(char[] dados) {
		System.out.println("\n");
		esforco = 0;
		vezes = 0;
		System.out.println(dados);
		ordenar(dados, 0, dados.length - 1);
		System.out.println("vezes: " + vezes);
		System.out.println("esforco: " + esforco);
		System.out.println(dados);
	}

	static void ordenar(char[] dados, int inicio, int end) {

		if (inicio >= end) {
			return;
		}
		vezes++;
		int pivot = end;
		int wall = inicio;
		for (int i = inicio; i < end; i++) {
			esforco++;
			if (dados[i] < dados[pivot]) {
				char troca = dados[wall];
				dados[wall] = dados[i];
				dados[i] = troca;
				wall++;
			}
		}

		char troca = dados[wall];
		dados[wall] = dados[pivot];
		dados[pivot] = troca;

		ordenar(dados, inicio, wall - 1);
		ordenar(dados, wall + 1, end);
	}
}
