package parte1;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Parte1_Ejercicio4 {

    public static void main(String[] args) {
        String name;
        float auxiliar = 0;
        float numCarros, valorCarro = 0, sueldo, total = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("----------------Bienvenido----------------");
        System.out.println("   Este programa contribuye al calculo     ");
        System.out.println("    del pago mensual de cada empleado      ");
        System.out.print("Ingrese el nombre del empleado correctamente en mayusculas:");
        name = entrada.nextLine();
        if (name.equals("MANUEL") || name.equals("PEDRO") || name.equals("CARLOS")||name.equals("MIGUEL")) {
            System.out.print("Ingrese el numero de autos vendidos:");
            numCarros = entrada.nextFloat();
            for (int i = 0; i < numCarros; i++) {
                System.out.print("ingrese el precio del auto N°" +(i+1)+":");
                valorCarro = entrada.nextFloat();
                auxiliar = auxiliar + valorCarro;
            }
            total = auxiliar;
            sueldo = 1000 + 150 * numCarros + (5 * total) / 100;
            System.out.println("El pago mensual para el empleado es:" + sueldo);
            //System.out.println(total);

        }else{
            System.out.println("¡ERROR!");
            System.out.println("No tenemos registrado a nadie con el nombre de "+name);
            System.out.println("Por favor verifique la informacion e ingresela de manera adecuada");
            System.out.println("REINICIE EL CODIGO");

        }
    }
}
