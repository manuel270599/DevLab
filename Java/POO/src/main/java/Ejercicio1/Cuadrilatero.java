package Ejercicio1;

public class Cuadrilatero {
    private float lado1;
    private float lado2;
    private String tipo;

    public Cuadrilatero(float lado1, float lado2, String tipo) {
        this.lado1=lado1;
        this.lado2=lado2;
        this.tipo=tipo;
    }

    public Cuadrilatero(float lado1 ,String tipo) {
        this.lado1=this.lado2=lado1;
        this.tipo=tipo;
    }

    public float getPerimetro(){
        float perimetro = 2*(lado2+lado1);
        return perimetro;
    }
    public float getArea(){
        float area = lado1*lado2;
        return area;
    }

    public String getTipo(){
        return tipo;
    }
}

