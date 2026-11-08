package CursoJavaLibro;

import com.sun.jdi.IntegerValue;

public class Metodos {
    public static void main(String[] args){
        int numClientes = Integer.valueOf(args[0]);
        int numEmpleados = Integer.valueOf(args[1]);
        int numSillas = Integer.valueOf(args[2]);
        int numMesas = Integer.valueOf(args[3]);
        int numContratos = Integer.valueOf(args[4]);
        int numReclamaciones = Integer.valueOf(args[5]);
        int numPersonas=numClientes+numEmpleados;
        int numMuebles= numMesas+numSillas;
        int numExpedientes= numContratos+numReclamaciones;

        System.out.println( "tenemos"+numPersonas+"personas,"+numMuebles+"muebles y "+numExpedientes+"expedientes.");
    }
}
