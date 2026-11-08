package CursoJavaLibro;

import java.util.Scanner;

public class Libro_Ejercicio1_b {
    public static void main(String[] args){
        int n;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese el numero de mes:");
        n = entrada.nextInt();

        if(n==1){
            System.out.println("Mes:Enero(31dias)");
        }
        if (n==2){
            System.out.println("Mes:Febrero(29dias)");
        }
        if(n==3){
            System.out.println("Mes:MARZO(31dias)");
        }
        if(n==4){
            System.out.println("Mes:ABRIL(30dias)");
        }
        if(n==5){
            System.out.println("Mes:MAYO(31dias)");
        }
        if(n==6){
            System.out.println("Mes:JUNIO(30dias)");
        }
        if(n==7){
            System.out.println("Mes:JULIO(31dias)");
        }
        if(n==8){
            System.out.println("Mes:AGOSTO(31dias)");
        }
        if(n==9){
            System.out.println("Mes:SEPTIEMBRE(30dias)");
        }
        if(n==10){
            System.out.println("Mes:OCTUBRE(31dias)");
        }
        if(n==11){
            System.out.println("Mes:NOVIEMBRE(30dias)");
        }
        if(n==12){
            System.out.println("Mes:DICIEMBRE(31dias)");
        }
        if(n==1){
            System.out.println("Mes:Enero(31dias)");
        }
        if (n>12 || n<0){
            System.out.println("Mes no valido\nFIN DE PROGRAMA");
        }
    }
}
