package Ejercicio5;

public class Triangulo {
    private double base;
    private double lado;

    public Triangulo(double base, double lado){
        this.base=base;
        this.lado = lado;

    }
    public double ObtenerPerimetro(){
        double perimetro= 2*lado+base;
        return perimetro;
    }
    public double ObtenerArea(){
        double area=(base*Math.sqrt((lado*lado)-((base*base)/4)))/2;
        return area;
    }
    public String MostrarDatos(){
        return "base:"+base+",lado:"+lado+",area:"+ObtenerArea()+",perimetro:"+ObtenerPerimetro();
    }
}
