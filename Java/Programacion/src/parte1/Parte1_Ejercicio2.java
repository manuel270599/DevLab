package parte1;

import java.util.Scanner;

public class Parte1_Ejercicio2 {
    public static void main(String[] args){
        float horas,horas_extra,salario;
        int nivel;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el numero de horas de trabajo realizadas:");
        horas = entrada.nextFloat();
        System.out.print("Horas extra realizadas a la semana:");
        horas_extra = entrada.nextFloat();
        System.out.println("---Nivel de empleado---");
        System.out.println("1.Obreros");
        System.out.println("2.Encargados");
        System.out.println("3.Administrativos");
        System.out.println("4.Limpieza y saneamiento");
        System.out.print("Ingrese su nivel de empleado:");
        nivel =  entrada.nextInt();

        if(nivel==1){
            salario = horas*30+horas_extra*45;
            System.out.println("El salario correspondiente es:"+salario);;
        }
        if (nivel==2){
            salario = horas*35 + horas_extra*52;
            System.out.println("El salario corrspondiente es:"+salario);
        }
        if(nivel==3){
            salario = horas*40 + horas_extra*60;
            System.out.println("El salario correspondiente es:"+salario);
        }
        if(nivel==4){
            salario = horas*28 + horas_extra*42;
            System.out.println("El salario correspondiente es:"+salario);
        }
        System.out.println("---------------Gracias por la verificacion salarial----------------");
    }
}
