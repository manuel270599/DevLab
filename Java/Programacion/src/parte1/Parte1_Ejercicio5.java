package parte1;

import java.util.Scanner;

public class Parte1_Ejercicio5 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        double participacion,primerparcial,segundoparcial,examenfinal,notafinal;
        System.out.println("INGRESANDO NOTAS....");
        System.out.print("Ingrese la nota de participacion:");
        participacion=entrada.nextFloat();
        System.out.print("Ingrese la nota del primer parcial:");
        primerparcial = entrada.nextFloat();
        System.out.print("Ingrese la nota del segundo parcial:");
        segundoparcial = entrada.nextFloat();
        System.out.print("Ingrese la nota del examen final:");
        examenfinal = entrada.nextFloat();

        notafinal = 0.1*participacion + 0.25*primerparcial + 0.25*segundoparcial + 0.4*examenfinal;

        System.out.println("el promedio final del curso es:"+notafinal);


    }
}
