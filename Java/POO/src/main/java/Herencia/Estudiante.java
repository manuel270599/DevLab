package Herencia;

public class Estudiante extends Persona{
    private int codigo;
    private float nota_final;
//constructor
    public Estudiante(String nombre,String apellido,int edad, int codigo,float nota_final){
        super(nombre, apellido, edad);
        this.codigo = codigo;
        this.nota_final = nota_final;
    }
    public void mostrarDatos(){
        System.out.println("nombre:"+getNombre());
        System.out.println("apellido:"+getApellido());
        System.out.println("edad:"+getEdad());
        System.out.println("codigo"+codigo);
        System.out.println("nota final:"+nota_final);
    }


}
