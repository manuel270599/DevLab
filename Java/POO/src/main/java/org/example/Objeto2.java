package org.example;

import javax.swing.*;

public class Objeto2 {
    public static void main(String[] args){
        int n1 = Integer.parseInt(JOptionPane.showInputDialog(null,"numero:"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog(null,"numero:"));

        Operacion2 op =new Operacion2();
        op.suma(n1,n2);
        op.resta(n1,n2);
        op.producto(n1,n2);
        op.cociente(n1,n2);
        op.VerResultados();

    }
}
