package parte1;

import java.util.Scanner;

public class Parte1_Ejercicio1 {
    public static void main(String[] args){
        int num1,num2,num3;
        float suma;
        Scanner entrada = new Scanner(System.in);
        System.out.print("ingrese el numero 1:");
        num1 = entrada.nextInt();
        System.out.print("Ingrese el numero 2:");
        num2 = entrada.nextInt();
        System.out.print("ingrese el numero 3:");
        num3 = entrada.nextInt();

        suma = (num1+num2+num3);

        System.out.println("La suma es:"+suma);
        System.out.println("suma:"+(num1+num2+num3));
    }
}
