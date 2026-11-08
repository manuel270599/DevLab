package Arreglos;

import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args){
        int numero;
        Scanner entrada = new Scanner(System.in);
        System.out.print("ingrese la cantidad de numeros:");
        numero = entrada.nextInt();
        int[] lista = new int[numero];

        for(int i=0;i<lista.length;i++){
            System.out.print("numero:");
            lista[i]=entrada.nextInt();
        }
        System.out.println("impresion de la lista (->)");
        for(int i=0;i< lista.length;i++){
            System.out.print(lista[i]+"-");
        }
        System.out.println("\nimpresion de la lista (<-)");
        for(int i= lista.length;i>0;i--){
            System.out.print(lista[i-1]+"-");
        }
    }
}