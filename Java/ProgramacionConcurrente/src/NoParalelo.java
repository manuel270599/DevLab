public class NoParalelo {
    public static void main(String[] args) {
        int terminos = 1000000000;

        long startTime = System.nanoTime();

        double suma = calcularSuma(terminos);
        double resta = calcularResta(terminos);

        double pi = suma - resta;

        long endTime = System.nanoTime();

        double executionTime = (endTime - startTime) / 1e9; // Convertir nanosegundos a segundos

        System.out.println("Valor estimado de pi: " + pi);
        System.out.println("Tiempo de ejecución: " + executionTime + " segundos");
    }

    public static double calcularSuma(int n) {
        double suma = 0;
        for (int i = 0; i < n; i++) {
            double termino = 1.0 / (2 * i + 1);
            if (i % 2 == 0) {
                suma += termino;
            }
        }
        return 4 * suma;
    }

    public static double calcularResta(int n) {
        double resta = 0;
        for (int i = 0; i < n; i++) {
            double termino = 1.0 / (2 * i + 1);
            if (i % 2 != 0) {
                resta += termino;
            }
        }
        return 4 * resta;
    }
}

