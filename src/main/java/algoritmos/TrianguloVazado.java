package algoritmos;

public class TrianguloVazado {

	char caracter;
	int tamanho;

	TrianguloVazado(char c, int t) {
		caracter = c;
		tamanho = t;
	}

	void desenhar() {
		for (int i = 0; i < tamanho; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0 || i == tamanho - 1 || j == i) {
					System.out.print(caracter);
				} else {
					System.out.print(' ');
				}
			}
			System.out.print('\n');
		}
	}

	public static void main(String[] args) {
		TrianguloVazado triagnulo = new TrianguloVazado('$', 5);
		triagnulo.desenhar();
	}
}
