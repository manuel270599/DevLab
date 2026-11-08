package org.example;

import javax.swing.*;

public class Operacion {
    int num1;
    int num2;
    int sum;
    int resta;
    int multiplicacion;
    int dividir;

    public void LeerNumeros(){
        num1=Integer.parseInt(JOptionPane.showInputDialog("num1:"));
        num2=Integer.parseInt(JOptionPane.showInputDialog("num2:"));
    }
    public void sum(){
        sum = num1+num2;
    }
    public void resta(){
        resta = num1-num2;
    }
    public void Multiplicacion(){
        multiplicacion = num1*num2;
    }
    public void dividir(){
        dividir = num1/num2;
    }
    public void MostrarResultados(){
        System.out.println(sum);
        System.out.println(resta);
        System.out.println(multiplicacion);
        System.out.println(dividir);
    }
}
