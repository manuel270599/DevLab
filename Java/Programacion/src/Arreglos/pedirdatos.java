package Arreglos;

import java.util.Scanner;

public class pedirdatos {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int cantidad;
        System.out.print("Digite la cantidad de datos del arreglo:");
        cantidad = entrada.nextInt();
        int[] lista = new int[cantidad];
        for(int i=0;i<cantidad;i++){
            System.out.print("Digite el numero:");
            lista[i]= entrada.nextInt();
        }
        System.out.println("los datos del arreglo son:");
        for(int i:lista){ //bucle for each
            System.out.print(i);
            System.out.print("  ");
        }

    }
}
