package Encapsulamiento;

public class Principal {
    public static void main(String[] args){
        Persona objeto1 = new Persona("manuel", 22);
        objeto1.setEdad(23);
        System.out.println(objeto1.getEdad());
        System.out.println(objeto1.getNombre());
    }
}
