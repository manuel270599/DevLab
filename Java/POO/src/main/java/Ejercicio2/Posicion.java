package Ejercicio2;

public class Posicion {
    private Integer x,y;
    private String movimiento;

    public Posicion(Integer x, Integer y, String movimiento) {
        this.movimiento=movimiento;
        this.x=x;
        this.y=y;
    }
    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

}
