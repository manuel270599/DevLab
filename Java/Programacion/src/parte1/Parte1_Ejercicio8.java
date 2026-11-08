package parte1;

import java.util.Scanner;

public class Parte1_Ejercicio8 {
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int a,b,c;
        double sol1,sol2;
        System.out.println("Sea la ecuacion de segundo grado");
        System.out.println("ax^2+bx+c=0");
        System.out.print("Ingrese el coeficiente a:");
        a = entrada.nextInt();
        System.out.print("Ingrese el coeficiente b:");
        b = entrada.nextInt();
        System.out.print("Ingrese el coeficiente c:");
        c = entrada.nextInt();
        sol1 = (-b+Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        sol2 = (-b-Math.sqrt(Math.pow(b,2)-4*a*c))/(2*a);
        if(sol1==sol2){
            System.out.println("la solucion del sistema tiene raiz unica");
            System.out.println("{"+sol1+"}");
        }else {
            System.out.println("Las soluciones a la ecuacion son:");
            System.out.println("{" + sol1 + "," + sol2 + "}");
        }
    }
}
