package Ejercicio5;

import java.util.Scanner;

public class Main {
    public static double mayorArea(Triangulo triangulos[]){
        double area;
        area=triangulos[0].ObtenerArea();
        for(int i=0;i< triangulos.length;i++){
            if(triangulos[i].ObtenerArea()>area){
                area =triangulos[i].ObtenerArea();
            }
        }
        return area;
    }
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        double base, lado;
        int numTriangulos;
        System.out.print("ingrese la cantidad de triangulos:");
        numTriangulos=entrada.nextInt();
        Triangulo triangulos[]=new Triangulo[numTriangulos];
        for (int i=0;i<triangulos.length;i++){
            System.out.println("digite los valores del triangulo");
            System.out.print("ingrese la base:");
            base=entrada.nextDouble();
            System.out.print("ingrese el lado:");
            lado=entrada.nextDouble();
            triangulos[i]=new Triangulo(base,lado);
            System.out.println("el perimetro del triangulo es:"+triangulos[i].ObtenerPerimetro());
            System.out.println("el area del triangulo es:"+triangulos[i].ObtenerArea());
        }
        System.out.println("el area de mayor superficie es "+mayorArea(triangulos));
    }
}
