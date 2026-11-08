package Encapsulamiento;

public class MainClase1 {
    public static void main(String[] args){
        Clase1 objeto1 = new Clase1();
        objeto1.setEdad(10);
        System.out.println(objeto1.getEdad());
        objeto1.setNombre("pedro");
        System.out.println(objeto1.getNombre());
    }
}