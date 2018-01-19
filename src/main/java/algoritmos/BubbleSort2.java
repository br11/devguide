package algoritmos;

public class BubbleSort2 {

	public static void main(String[] args) {
		//char[] dados = { 'H', 'A', 'F', 'D', 'B', 'I', 'C', 'G', 'K', 'E', 'J', 'L' };
		char[] dados = { 'L', 'K', 'J', 'I', 'H', 'G', 'F', 'E', 'D', 'C', 'B', 'A' };

		System.out.println(dados);

		int contador = 0;
		boolean a = true;
		for (int i = 0; i < dados.length - 1; i++) {
			if (a) {
				a = false;
				for (int j = 0; j < dados.length - 1; j++) {
					contador++;
					if (dados[j + 1] < dados[j]) {
						char aux = dados[j];
						dados[j] = dados[j + 1];
						dados[j + 1] = aux;
						a = true;
						
					}
				}
			}
		}

		System.out.println(dados);
		System.out.println(contador);
	}
}
