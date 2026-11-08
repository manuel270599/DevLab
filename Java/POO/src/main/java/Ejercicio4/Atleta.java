package Ejercicio4;

public class Atleta {
    private int numero;
    private String nombre;
    private float tiempo;

    public Atleta(int numero, String nombre, float tiempo) {
        this.numero = numero;
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    public String MostrarDatos(){
        return "numero:"+numero+", nombre:"+nombre+", tiempo:"+tiempo;
    }

    public float getTiempo() {
        return tiempo;
    }

}
