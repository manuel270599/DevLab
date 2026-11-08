package Repaso;

import java.util.Scanner;

public class Repaso {
    public static void main(String[] args){
        int numero;
        boolean negativos=false;
        Scanner entrada = new Scanner(System.in);
        for(int i=1;i<=10;i++){
            System.out.println("Digite un numero:");
            numero=entrada.nextInt();
            if(numero<0){
                negativos=true;
            }
        }
        if(negativos== true){
            System.out.println("Existe al menos un numero negativo");
        }
        else{
            System.out.println("no existe ningun numero negativo");
        }
    }
}
