package parte1;

import java.util.Scanner;

public class Parte1_Ejercicio7 {
    public static void main(String[] args){
        int horas,semanas,dias,horas_1;
        Scanner entrada = new Scanner(System.in);
        System.out.println("-----CALCULADOR DE TIEMPO------");
        System.out.print("Ingrese la cantidad de horas:");
        horas = entrada.nextInt();
        semanas = horas/168;
        dias = (horas-semanas*168)/24;
        horas_1 = horas - semanas*168 - dias*24;
        System.out.println("En esa cantidad de horas se obtiene: ");
        System.out.println(+semanas+"semanas,"+dias+"dias y "+horas_1+"horas");
    }
}
