package parte1;

import java.util.Scanner;

public class Parte1_Ejercicio6 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int num1,num2;
        double suma=0;
        System.out.print("ingrese el primer numero:");
        num1 = entrada.nextInt();
        System.out.print("ingrese el segundo numero:");
        num2 = entrada.nextInt();
        suma = Math.pow(num1,2)+Math.pow(num2,2)+ 2 * num1* num2;
        System.out.print("la suma al cuadrado de ambos numeros es:"+suma);
    }
}
