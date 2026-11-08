package org.example;

import javax.swing.*;

public class Objeto3 {
    public static void main(String[] args){
        int n1 = Integer.parseInt(JOptionPane.showInputDialog(null,"numero:"));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog(null,"numero:"));

        Operacion3 op =new Operacion3();

        System.out.println(op.sumar(n1,n2));
        System.out.println(op.restar(n1,n2));
        System.out.println(op.producto(n1,n2));
        System.out.println(op.cociente(n1,n2));


    }
}
