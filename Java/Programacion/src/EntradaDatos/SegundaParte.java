package EntradaDatos;

import java.util.Scanner;

public class SegundaParte {
    public static void main(String args[]){
        Scanner entrada = new Scanner(System.in);

        int numero;
        float decimal;
        char letra;
        String cadena;

        System.out.print("ingrese el numero:");
        numero= entrada.nextInt();
        System.out.print("ingrese el flotante:");
        decimal = entrada.nextFloat();
        System.out.print("ingrese la letra:");
        letra = entrada.next().charAt(0);
        System.out.println("ingrese la palabra:");
        cadena = entrada.nextLine();



        System.out.print("el numero es "+numero);
        System.out.print("el flotante es:"+decimal);
        System.out.print("la letra es:"+letra);
        System.out.print(cadena);



    }
}
