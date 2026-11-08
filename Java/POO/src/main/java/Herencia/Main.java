package Herencia;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        String a,b;
        int c,d;
        float e;
        Scanner entrada = new Scanner(System.in);
        System.out.print("ingrese el nombre:");
        a=entrada.nextLine();
        System.out.print("ingrese el apellido:");
        b=entrada.nextLine();
        System.out.print("ingrese la edad:");
        c=entrada.nextInt();
        System.out.print("ingrese el codigo de estudiante:");
        d=entrada.nextInt();
        System.out.println("ingrese la nota final del estudiante");
        e=entrada.nextFloat();

        Estudiante estudiante = new Estudiante(a,b,c,d,e);
        estudiante.mostrarDatos();
    }
}
