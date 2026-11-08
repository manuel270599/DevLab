package CursoJavaLibro;

import java.util.Scanner;

public class Libro_Ejercicio1_a {
    public static void main(String[] args){
        int n;
        Scanner entrada = new Scanner(System.in);
        System.out.print("INGRESE EL NUMERO:");
        n = entrada.nextInt();
        switch (n){
            case 1:
                System.out.println("Mes:Enero(31dias)");
                break;
            case 2:
                System.out.println("Mes:febrero(29dias)");
                break;
            case 3:
                System.out.println("Mes:Marzo(31dias)");
                break;
            case 4:
                System.out.println("Mes:Abril(30dias)");
                break;
            case 5:
                System.out.println("Mes:Mayo(31dias)");
                break;
            case 6:
                System.out.println("Mes:Junio(30dias)");
                break;
            case 7:
                System.out.println("Mes:Julio(31dias)");
                break;
            case 8:
                System.out.println("Mes:agosto(31dias)");
                break;
            case 9:
                System.out.println("Mes:Septiembre(30dias)");
                break;
            case 10:
                System.out.println("Mes:Octubre(31dias)");
                break;
            case 11:
                System.out.println("Mes:Noviembre(30dias)");
                break;
            case 12:
                System.out.println("Mes:Diciembre(31dias)");
                break;
            default:
                System.out.println("Mes no valido\nFIN DE PROGRAMA");
                        break;

        }
    }
}
