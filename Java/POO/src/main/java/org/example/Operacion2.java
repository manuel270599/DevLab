package org.example;

public class Operacion2 {
    int suma;
    int resta;
    int producto;
    int cociente;

    public void suma(int num1, int num2){
    suma = num1+num2;
    }
    public void resta(int num1, int num2){
        resta=num1-num2;
    }
    public void producto(int num1, int num2){
    producto = num1*num2;
    }
    public void cociente(int num1, int num2){
        cociente = num1/num2;
    }
    public void VerResultados(){
        System.out.println(suma);
        System.out.println(resta);
        System.out.println(producto);
        System.out.println(cociente);
    }
}
