package parte1;

import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Parte1_Ejercicio3 {
    public static void main(String[] args){
        float N,luis,juan,total;
        Scanner entrada = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de dolares que tiene Guillermo:");
        N = entrada.nextFloat();
        luis = N/2;
        juan = (N+luis)/2;
        total = N + luis + juan;
        System.out.println("Luis tiene:"+luis+" dolares");
        System.out.println("juan tiene :"+juan+" dolares");
        System.out.println("guillermo tiene :"+N+" dolares");
        System.out.println("la cantidad de dinero total que poseen es "+total+" dolares");
    }
}
