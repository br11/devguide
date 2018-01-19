package br.com.santander.devguide.rdbms;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        Integer[] intdata = new Integer[] { 2, 3, 4, 5, 1, 2, 9, 5 };
        minimoMaximo(intdata);
        System.out.println("\n\n");

        Character[] chardata = new Character[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J' };
        procurar(chardata, 'E');
        System.out.println("\n\n");

        substituir(chardata, 'E', 'X');
        System.out.println("\n\n");

        inverter(chardata);
        System.out.println("\n\n");

        trianguloVazado('*', 6);
        System.out.println("\n\n");
    }

    static void minimoMaximo(Integer[] data) {
        System.out.println("Mínimo e máximo \n------------------------------------------");
        System.out.println("data: " + Arrays.asList(data));

        int min = data[0];
        int max = data[0];
        for (int i = 0; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
            if (data[i] > max) {
                max = data[i];
            }
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }

    static void procurar(Character[] data, Character procurado) {
        System.out.println("Procurar \n------------------------------------------");
        System.out.println("data: " + Arrays.asList(data));
        System.out.println("procurado: " + procurado);

        int index = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i] == procurado) {
                index = i;
            }
        }

        System.out.println("index: " + index);
    }

    static void substituir(Character[] data, Character atual, Character substituto) {
        System.out.println("Substituir \n------------------------------------------");
        System.out.println("data: " + Arrays.asList(data));
        System.out.println("busca: " + atual);
        System.out.println("troca: " + substituto);

        for (int i = 0; i < data.length; i++) {
            if (data[i] == atual) {
                data[i] = substituto;
            }
        }

        System.out.println("data: " + Arrays.asList(data));
    }

    static void inverter(Character[] data) {
        System.out.println("Inverter \n------------------------------------------");
        System.out.println("data: " + Arrays.asList(data));

        Character[] inverso = new Character[data.length];

        for (int i = 0; i < data.length; i++) {
            inverso[i] = data[data.length - i - 1];
        }

        System.out.println("inverso: " + Arrays.asList(inverso));
    }

    static void trianguloVazado(Character c, int size) {
        System.out.println("Triangulo vazado \n------------------------------------------");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1 || j == i || i == size) {
                    System.out.print(c);
                } else {
                    System.out.print(' ');
                }
            }
            System.out.print("\n");
        }
    }
}
