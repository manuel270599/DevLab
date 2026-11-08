package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio1 {
    public static void main(String[] args) {
        int numero;
        numero = Integer.parseInt(JOptionPane.showInputDialog("digite un numero:"));
         if( numero%10==0){
             JOptionPane.showMessageDialog(null,"el numero es multiplo de 10");
         }else{
             JOptionPane.showMessageDialog(null,"el numero no es multiplo de 10");
         }
    }
}
