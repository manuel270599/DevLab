package EntradaDatos;

import java.util.Scanner;

public class primeraparte {
    public static void  main(String args[]){
        Scanner entrada= new Scanner(System.in);
        int numero;
        float flotante;
        boolean booleano;
        String nombre="jose manuel montalvo espinoza";
        char letra='p';
        System.out.print("digite un numero:");
        numero= entrada.nextInt();
        System.out.print("digite un flotante");
        flotante= entrada.nextFloat();
        System.out.print("verdadero o falso?:");
        booleano=entrada.hasNext();

        System.out.println("el numero es:"+numero);
        System.out.println("el flotante es:"+flotante);
        System.out.println("el booleano es:"+booleano);

        System.out.println(nombre);
    }
}
