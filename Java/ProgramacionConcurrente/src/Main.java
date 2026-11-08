public class Main {
    public static void main(String[] args) {
        int terminos = 1000000000;
        double[] resultados = new double[2];

        long startTime = System.nanoTime();

        Thread sumaThread = new Thread(() -> {
            resultados[0] = calcularSuma(terminos);
        });

        Thread restaThread = new Thread(() -> {
            resultados[1] = calcularResta(terminos);
        });

        sumaThread.start();
        restaThread.start();

        try {
            sumaThread.join();
            restaThread.join();
            double pi = resultados[0] - resultados[1];
            System.out.println("Valor estimado de pi: " + pi);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.nanoTime();
        double executionTime = (endTime - startTime) / 1e9;
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