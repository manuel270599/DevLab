package Ejercicio4;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static int CompararTiempos(Atleta atleta[]){
        float mejorTiempo=atleta[0].getTiempo();
        int ganador=0;
        for(int i=0;i<atleta.length;i++){
            if(mejorTiempo>atleta[i].getTiempo()){
                mejorTiempo=atleta[i].getTiempo();
                ganador=i;
            }
        }
        return  ganador;
    }
    public static void main(String[] args){
        Scanner entrada = new Scanner(System.in);
        int numero;
        String nombre;
        float tiempo;
        int cantidad;
        int AtletaGanador;
        System.out.print("ingrese el numero de atletas:");
        cantidad=entrada.nextInt();
        Atleta atleta[]=new Atleta[cantidad];
        for (int i=0;i<cantidad;i++){
            entrada.nextLine();
            System.out.println("ingrese los datos del atleta"+(i+1));
            System.out.print("numero:");
            numero=entrada.nextInt();
            entrada.nextLine();
            System.out.print("ingrese el nombre del atleta:");
            nombre=entrada.nextLine();
            System.out.print("ingrese el tiempo en minutos:");
            tiempo=entrada.nextInt();
            atleta[i]= new Atleta(numero,nombre,tiempo);
        }
        AtletaGanador = CompararTiempos(atleta);
        System.out.println("el atleta con menos tiempo es el numero "+(AtletaGanador+1)+ "y sus datos son\n"+atleta[AtletaGanador].MostrarDatos());
    }
}
