package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio4 {
    public static void main(String[] args){
        double compra,precio=0;
        compra = Integer.parseInt(JOptionPane.showInputDialog("ingrese el valor de su compra:"));

        if(compra>300){
            precio = 0.8*compra ;
            JOptionPane.showMessageDialog(null,"Total a pagar "+precio+"$");
        }else{
            JOptionPane.showMessageDialog(null,"No accede al descuento");
            JOptionPane.showMessageDialog(null,"Monto a pagar :"+compra+"$");

        }
        JOptionPane.showMessageDialog(null, "Gracias por su compra, vuelva pronto!");
    }
}
