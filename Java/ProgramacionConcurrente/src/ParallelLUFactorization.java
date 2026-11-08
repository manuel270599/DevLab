public class ParallelLUFactorization {
    public static void main(String[] args) {
        int size = 5000;
        int numThreads = 4; // Puedes modificar esta variable para ajustar el número de hilos
        double[][] A = generateMatrix(size);

        long startTime = System.nanoTime();

        double[][][] LU = decomposeLU(A, numThreads);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Duración en milisegundos

        System.out.println("Time taken for LU decomposition with " + numThreads + " threads: " + duration + " milliseconds");
    }

    public static double[][] generateMatrix(int size) {
        double[][] matrix = new double[size][size];
        // Llena la matriz con algún dato aleatorio o con tu lógica para generar la matriz
        return matrix;
    }

    public static double[][][] decomposeLU(double[][] A, int numThreads) {
        int size = A.length;

        double[][] L = new double[size][size];
        double[][] U = new double[size][size];

        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            threads[i] = new Thread(new LUDecompositionTask(A, L, U, i, numThreads));
            threads[i].start();
        }

        try {
            for (int i = 0; i < numThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        double[][][] result = {L, U};
        return result;
    }

    static class LUDecompositionTask implements Runnable {
        private double[][] A;
        private double[][] L;
        private double[][] U;
        private int startRow;
        private int numThreads;

        public LUDecompositionTask(double[][] A, double[][] L, double[][] U, int startRow, int numThreads) {
            this.A = A;
            this.L = L;
            this.U = U;
            this.startRow = startRow;
            this.numThreads = numThreads;
        }

        @Override
        public void run() {
            int size = A.length;
            for (int i = startRow; i < size; i += numThreads) {
                // Calcular matriz L
                for (int j = 0; j <= i; j++) {
                    double sum = 0.0;
                    for (int k = 0; k < j; k++) {
                        sum += (L[i][k] * U[k][j]);
                    }
                    L[i][j] = A[i][j] - sum;
                }

                // Calcular matriz U
                for (int j = i; j < size; j++) {
                    double sum = 0.0;
                    for (int k = 0; k < i; k++) {
                        sum += (L[i][k] * U[k][j]);
                    }
                    if (Math.abs(L[i][i]) < 1e-10) {
                        throw new ArithmeticException("Divide by zero or nearly zero");
                    }
                    U[i][j] = (A[i][j] - sum) / L[i][i];
                }
            }
        }
    }
}
