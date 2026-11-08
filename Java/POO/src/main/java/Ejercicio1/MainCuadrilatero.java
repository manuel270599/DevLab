package Ejercicio1;

import javax.swing.*;

public class MainCuadrilatero {

    public static void main(String[] args){
        Cuadrilatero objeto;
        float lado1,lado2;
        String tipo;
        lado1=Float.parseFloat(JOptionPane.showInputDialog(null,"ingrese el lado1:"));
        lado2=Float.parseFloat(JOptionPane.showInputDialog(null,"ingrese el lado 2:"));
        if(lado1==lado2){
            tipo="cuadrado";
            objeto= new Cuadrilatero(lado1,tipo);
        }else{
            tipo="rectangulo";
            objeto = new Cuadrilatero(lado1,lado2,tipo);
        }
        System.out.println("tipo:"+objeto.getTipo());
        System.out.println("perimetro:"+objeto.getPerimetro());
        System.out.println("area:"+objeto.getArea());
    }

}
