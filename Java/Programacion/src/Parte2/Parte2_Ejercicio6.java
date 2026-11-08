package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio6 {
    public static void main(String[] args){
        int num1,num2;
        num1=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el primer numero:"));
        num2=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el segundo numero:"));
        if(num1%2==0){
            if(num2%2==0){
                JOptionPane.showMessageDialog(null,"Ambos numeros son pares");
            }
            if(num2%2!=0){
                JOptionPane.showMessageDialog(null,"El numero "+num1+" es par y el numero "+num2+" es impar");
            }
        }else{
            if (num2%2==0){
                JOptionPane.showMessageDialog(null,"El numero "+num1+" es impar y el numero "+num2+" es par.");
            } else {
                JOptionPane.showMessageDialog(null,"Ambos numero son impares");

            }

        }
    }
}
