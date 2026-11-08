package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio3 {
    public static void main(String[] args){
        char letra;
        letra = JOptionPane.showInputDialog("Digite una letra").charAt(0);

        if(Character.isUpperCase(letra)){
            JOptionPane.showMessageDialog(null,"es una letra mayuscula");
        }
        else{
            JOptionPane.showMessageDialog(null,"no es una letra mayuscula");
        }
    }
}
