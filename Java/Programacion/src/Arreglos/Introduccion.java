package Arreglos;

public class Introduccion {
    public static void main(String[] args) {
        int[] lista = {1,3,4};
        int[] numeros = new int[3];
        numeros[0] = 7;
        numeros[1] = 2;
        numeros[2] = 4;

        for (int i = 0; i < 3; i++) {
            System.out.print(numeros[i]);
            System.out.print("  ");
            System.out.println(lista[i]);
        }
    }

}
