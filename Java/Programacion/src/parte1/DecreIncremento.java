package parte1;

import java.util.Scanner;

public class DecreIncremento {
    public static void main(String[] args){
        int x,y,z;
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el valor de x:");
        x=entrada.nextInt();

        y = ++x;
        z = --x;
        x++;
        System.out.println("y:"+y);
        System.out.println("z:"+z);
        System.out.println("x:"+x);
    }
}
