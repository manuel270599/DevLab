package Constructor;

public class Persona {
    //Atributos
    int edad;
    String nombre;
    //Metodo constuctor
    public Persona(String _nombre, int _edad){
        nombre = _nombre;
        edad = _edad;
    }
    //metodo
    public void mostrarDatos(){
        System.out.println(nombre);
        System.out.println(edad);
    }
}
