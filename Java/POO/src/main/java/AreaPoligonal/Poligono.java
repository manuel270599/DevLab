package AreaPoligonal;

public abstract class Poligono {
    protected int numlado;

    public Poligono(int numlado) {
        this.numlado = numlado;
    }

    public int getNumlado() {
        return numlado;
    }

    public String MostrarDatos(){
        return "numero de lados:"+numlado;
    }

    @Override
    public String toString() {
        return "numlado=" +numlado ;
    }
    public abstract double area();
}
