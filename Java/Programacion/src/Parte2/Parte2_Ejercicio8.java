package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio8 {
    public static void main(String[] args) {
        int numero;
        JOptionPane.showMessageDialog(null, "BIENVENIDO\nEste codigo calcula la cantidad de cifras\n");
        numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese un numero de 0 a 99999:"));
            if ((numero >= 0) && (numero <= 9)){
                JOptionPane.showMessageDialog(null, "el numero es de una cifra");
            }
            if ((numero >= 10) && (numero <= 99)) {
                JOptionPane.showMessageDialog(null, "el numero es de dos cifras");
            }
            if ((numero >= 100) && (numero <= 999)) {
                JOptionPane.showMessageDialog(null, "el numero es de tres cifras");
            }
            if ((numero >= 1000) && (numero <= 9999)) {
                JOptionPane.showMessageDialog(null, "el numero es de cuatro cifras");
            }
            if ((numero >= 10000) && (numero <= 99999)){
            JOptionPane.showMessageDialog(null, "el numero es de cinco cifras");
            }
            if ((numero>=99999)){
                JOptionPane.showMessageDialog(null, "el numero tiene mas de cinco cifras");
            }

        }
}
