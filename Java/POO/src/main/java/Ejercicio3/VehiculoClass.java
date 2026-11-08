package Ejercicio3;

public class VehiculoClass {
    private String marca;
    private String modelo;
    private float precio;

    public VehiculoClass(String marca, String modelo,float precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    public float getPrecio(){
        return precio;
    }
    public String MostrarDatos() {
        return "marca:" + marca + ".\nprecio:" + precio + ".\nmodelo:" + modelo;
    }
}
