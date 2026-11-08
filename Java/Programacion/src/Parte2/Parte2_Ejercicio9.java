package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio9 {
    public static void main(String[] args){
        int dia,mes,año;
        dia = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el dia:"));
        mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes:"));
        año = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el año:"));
        if(dia>0 && dia<31){
            if(mes>0 && mes<=12){
                if (año!=0){
                    JOptionPane.showMessageDialog(null,"La fecha es correcta");
                }else{
                    JOptionPane.showMessageDialog(null,"La fecha es incorrecta, el año no existe");
                }
            }else{
                JOptionPane.showMessageDialog(null,"la fecha es incorrecta, el mes no es el adecuado!");
            }
        }else{
            JOptionPane.showMessageDialog(null,"La fecha es incorrecta, el dia es incorrecto!");
        }
    }
}
