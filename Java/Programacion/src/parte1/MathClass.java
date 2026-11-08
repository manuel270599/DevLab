package parte1;

import java.util.Scanner;

public class MathClass {
    public static void main(String[] args){
        double numero,raiz,potencia,resultado,aleatorio;
        Scanner entrada = new Scanner(System.in);
        System.out.print("ingrese el numero a operar:");
        numero = entrada.nextDouble();
        raiz = Math.sqrt(numero);
        resultado = Math.round(raiz);
        potencia = Math.pow(numero,3);
        aleatorio = Math.random();
        System.out.println("la raiz es:"+raiz);
        System.out.println("la potencia es:"+potencia);
        System.out.println("el numero redondeado es:"+resultado);
        System.out.println("el numero random es:"+aleatorio);
    }
}
