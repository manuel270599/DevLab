package Parte2;

import javax.swing.*;

public class Condicionales {
    public static void main(String[] args){
        int numero;
        numero=Integer.parseInt(JOptionPane.showInputDialog("Digite un numero:"));
        switch (numero){
            case 1:JOptionPane.showMessageDialog(null,"el numero es 1");
            break;
            case 2:JOptionPane.showMessageDialog(null,"el numero es 2");
            break;
            case 3:JOptionPane.showMessageDialog(null,"el numero es 3");
            break;
            case 4: JOptionPane.showMessageDialog(null,"el numero es 4");
            break;
            case 5: JOptionPane.showMessageDialog(null,"el numero es 5");
            break;
            default: JOptionPane.showMessageDialog(null,"el numero no esta en lista");

        }
    }
}
