package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio2 {
    public static void main(String[] args){
        String nombre;
        int num1, num2;
        nombre=JOptionPane.showInputDialog("Este codigo ejecuto la comparacion de 2 numeros,permitenos tu nombre");
        JOptionPane.showMessageDialog(null, new StringBuilder().append("hola ").append(nombre).append(" ingresa la informacion3").toString());
        num1=Integer.parseInt(JOptionPane.showInputDialog("ingrese el primer numero:"));
        num2=Integer.parseInt(JOptionPane.showInputDialog("ingrese el segundo numero:"));

        if(num1==num2){
            JOptionPane.showMessageDialog(null,"los numero son iguales.");
        } else if (num1>num2) {
            JOptionPane.showMessageDialog(null,"el numero "+num1+" es mayor.");
        }
        if(num1<num2){
            JOptionPane.showMessageDialog(null,"el numero "+num2+" es mayor.");
        }
        JOptionPane.showMessageDialog(null,"gracias por hacer uso de este servicio.");
    }
}
