package Ejercicio3;

import java.util.Scanner;

public class Main {

    public static int Cochebarato(VehiculoClass coches[]){
        float precio;
        int indice=0;
        precio = coches[0].getPrecio();
        for(int i=0;i<coches.length;i++){
            if(coches[i].getPrecio()<precio){
                precio=coches[i].getPrecio();
                indice=i;
            }
        }
        return indice;

    }
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        String marca,modelo;
        float precio;
        int cantidad;
        int indicebarato;
        System.out.print("digita la cantidad de vehiculos:");
        cantidad=entrada.nextInt();

        VehiculoClass coches[] = new VehiculoClass[cantidad];
        for (int i=0;i<cantidad;i++){
            entrada.nextLine();
            System.out.println ("Digite la caracteristicas del coche n°"+(i+1));
            System.out.print("marca:");
            marca = entrada.nextLine();
            System.out.print("modelo:");
            modelo = entrada.nextLine();
            System.out.print("precio:");
            precio = entrada.nextInt();
            coches[i] = new VehiculoClass(marca,modelo,precio);
        }
        indicebarato = Cochebarato(coches);
        System.out.println("el coche mas barato es "+coches[indicebarato].MostrarDatos());
    }
}
