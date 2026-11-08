package parte1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Operaciones {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        float suma,resta,multiplicacion,division,numero1,numero2;
        System.out.println("digite el primer numero:");
        numero1= entrada.nextFloat();
        System.out.println("digite el segundo numero:");
        numero2 = entrada.nextFloat();

        suma=numero1+numero2;
        resta = numero1-numero2;
        multiplicacion = numero1*numero2;
        division = numero1/numero2;
        System.out.println("la suma es:"+suma);
        System.out.println("la resta es:"+resta);
        System.out.println("el producto es:"+multiplicacion);
        System.out.println("la division es:"+division);

    }
}
