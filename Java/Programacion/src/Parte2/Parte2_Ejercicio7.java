package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio7 {
    public static void main(String[] args){
        int num1,num2,num3;
        JOptionPane.showMessageDialog(null,"¡BIENVENIDO!");
        JOptionPane.showMessageDialog(null,"En este programa se pedira 3 numeros y se mostrara en orden decreciente.");
        num1 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el primer numero:"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el segundo numero:"));
        num3 = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el tercer numero:"));
        if((num1>num2)&&(num2>num3)){
                JOptionPane.showMessageDialog(null, "El orden de los decreciente es :" +num1+"," +num2+ "," +num3);
        } else if ((num1>num3)&&(num3>num2)) {
            JOptionPane.showMessageDialog(null,"el orden de los decreciente es "+num1+","+num3+","+num2);
        } else if ((num2>num1)&&(num1>num3)) {
            JOptionPane.showMessageDialog(null,"el orden de los decreciente es "+num2+","+num1+","+num3);
        } else if ((num2>num3)&&(num3>num1)) {
            JOptionPane.showMessageDialog(null,"el orden de los decreciente es "+num2+","+num3+","+num1);
        } else if ((num3>num1)&&(num1>num2)) {
            JOptionPane.showMessageDialog(null,"el orden de los decreciente es "+num3+","+num1+","+num2);
        } else if ((num3>num1)&&(num2>num1)) {
            JOptionPane.showMessageDialog(null,"el orden de los decreciente es "+num3+","+num2+","+num1);
        }
        JOptionPane.showMessageDialog(null,"gracias por corrobar el codigo");

    }
}
