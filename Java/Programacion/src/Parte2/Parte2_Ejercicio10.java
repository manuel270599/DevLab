package Parte2;

import javax.swing.*;

public class Parte2_Ejercicio10 {
    public static void main(String[] args) {
        int dia, mes, año;
        dia = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el dia:"));
        mes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el mes:"));
        año = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año:"));

        if (dia > 0 && dia < 32) {
            if(año > 0 && año < 2024){
                if (mes > 0 && mes < 13){
                    if (mes==2){
                        JOptionPane.showMessageDialog(null,"Mes:Febrero("+mes+")\nAño:"+año+"\nDia:"+dia);
                    }
                switch (mes){
                    case 1: JOptionPane.showMessageDialog(null,"Mes:Enero("+mes+")\nAño:"+año+"\nDia:"+dia);
                    break;
                    case 2: JOptionPane.showMessageDialog(null,"Mes:Febrero("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 3: JOptionPane.showMessageDialog(null,"Mes:Marzo("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 4: JOptionPane.showMessageDialog(null,"Mes:Abril("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 5: JOptionPane.showMessageDialog(null,"Mes:Mayo("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 6: JOptionPane.showMessageDialog(null,"Mes:Junio("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 7: JOptionPane.showMessageDialog(null,"Mes:Julio("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 8: JOptionPane.showMessageDialog(null,"Mes:Agosto("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 9: JOptionPane.showMessageDialog(null,"Mes:Septiembre("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 10: JOptionPane.showMessageDialog(null,"Mes:Octubre("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 11: JOptionPane.showMessageDialog(null,"Mes:Noviembre("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;
                    case 12: JOptionPane.showMessageDialog(null,"Mes:Diciembre("+mes+")\nAño:"+año+"\nDia:"+dia);
                        break;



                }
                }else{
                    JOptionPane.showMessageDialog(null,"Año incorrecto");
                }
            }else{
                JOptionPane.showMessageDialog(null,"Mes incorrecto");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Dia incorrecto");
        }
    }
}
