package Parte2;

import javax.swing.*;

public class SwitchClass {
    public static void main(String[] args){
        String letra;
        letra = JOptionPane.showInputDialog(null,"ingrese una letra");
        switch (letra){
            case "a" : JOptionPane.showMessageDialog(null,"la letra es A");
            break;
            case "e" : JOptionPane.showMessageDialog(null,"la letra es E");
            break;
            case "i" : JOptionPane.showMessageDialog(null,"la leta es I");
            break;
            case "o" : JOptionPane.showMessageDialog(null,"la letra es o");
            break;
            case "u" : JOptionPane.showMessageDialog(null,"la letra es U");
            break;
            default: JOptionPane.showMessageDialog(null, "la letra no es parte del abecedario");
            break;
        }
    }
}
