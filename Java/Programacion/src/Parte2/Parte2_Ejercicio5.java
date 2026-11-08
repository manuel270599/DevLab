package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio5 {
    public static void main(String[] args){
        double salario,horas_extra;
        String nombre;
        float horas;
        nombre = JOptionPane.showInputDialog(null,"bienvenido,ingrese su nombre:");
        if(nombre.equals("jose")|| nombre.equals("luis") || nombre.equals("pedro")){
        horas = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite el numero de horas trabajadas:"));

            if(horas<=40){
                salario = horas *16;
                JOptionPane.showMessageDialog(null,"Su salario sera de"+salario+"$.");
            }else {
                horas_extra = horas-40;
                salario=40*16 + horas_extra*20;
                JOptionPane.showMessageDialog(null,"El salario a cobra es "+salario+"$.");
            }
        }else {
            JOptionPane.showMessageDialog(null, "El nombre indicado es incorrecto!");
        }
        JOptionPane.showMessageDialog(null,"¡gracias por su uso!");
    }
}
