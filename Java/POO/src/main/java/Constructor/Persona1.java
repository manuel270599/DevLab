package Constructor;

public class Persona1 {
    String nombre;
    int edad;
    String dni;

    public Persona1(String nombre, int edad,String dni){
        this.nombre=nombre;
        this.edad=edad;
        this.dni=dni;

    }
    public void correr(){
        System.out.println(nombre + edad + dni);
    }
    public int e_ad(int edad){
        return edad;
    }


}
