package Ejercicio2;

import javax.swing.*;

public class MainPosicion {
    public static void main(String[] args) {
        Posicion objeto1 = null;
        String movimiento;
        Integer x = 0, y = 0;
        JOptionPane.showMessageDialog(null,"bienvenido al tablero uni");

        do {
            movimiento = JOptionPane.showInputDialog(null,"ingrese el movimiento siguiente:");

            if (movimiento.equals("w")) {
                y++;
                objeto1 = new Posicion(x, y, "w");
            } else if(movimiento.equals("s")) {
                    y--;
                    objeto1 = new Posicion(x, y, "s");
            }else if(movimiento.equals("d")) {
                x++;
                objeto1 = new Posicion(x, y, "d");
            }else if(movimiento.equals("a")) {
                x--;
                objeto1 = new Posicion(x, y, "a");
            }else {
                System.out.println("movimiento no permitido\nIntente de nuevo.");
            }
            System.out.println("posicion:" + objeto1.getX() + "," + objeto1.getY());
        }
        while (!movimiento.equals("p"));

    }
}
