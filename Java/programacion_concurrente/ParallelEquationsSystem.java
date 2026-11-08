public class ParallelEquationsSystem {

    static final int L = 10; // Tamaño de la matriz (L x L)
    static final int h = 4;  // Número de hilos

    public static void main(String[] args) {
        double[][] A = new double[L][L];
        double[] B = new double[L];

        // Generar sistema con solución conocida
        double[] solution = new double[L];
        for (int i = 0; i < L; i++) {
            solution[i] = Math.random() * 20 - 10; // valores reales aleatorios
        }

        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                A[i][j] = Math.random() * 10;
            }
        }

        for (int i = 0; i < L; i++) {
            B[i] = 0;
            for (int j = 0; j < L; j++) {
                B[i] += A[i][j] * solution[j];
            }
        }

        long start = System.nanoTime();
        solveGaussParallel(A, B);
        long end = System.nanoTime();

        System.out.println("Solución:");
        for (int i = 0; i < L; i++) {
            System.out.printf("x[%d] = %.4f%n", i, B[i]);
        }

        System.out.printf("%nTiempo de ejecución (paralelo con %d hilos): %.4f ms%n",
                h, (end - start) / 1e6);
    }

    // Método de eliminación Gaussiana en paralelo
    public static void solveGaussParallel(double[][] A, double[] B) {
        for (int pivot = 0; pivot < L - 1; pivot++) {
            normalizePivotRow(A, B, pivot);

            Thread[] threads = new Thread[h];
            int rows = L - pivot - 1;
            int chunk = (rows + h - 1) / h; // distribución equitativa

            for (int i = 0; i < h; i++) {
                final int fromRow = pivot + 1 + i * chunk;
                final int toRow = Math.min(pivot + 1 + (i + 1) * chunk, L);
                final int currentPivot = pivot;

                threads[i] = new Thread(() -> {
                    for (int row = fromRow; row < toRow; row++) {
                        double factor = A[row][currentPivot];
                        for (int col = currentPivot; col < L; col++) {
                            A[row][col] -= factor * A[currentPivot][col];
                        }
                        B[row] -= factor * B[currentPivot];
                    }
                });
                threads[i].start();
            }

            // Esperar a que todos los hilos terminen
            for (Thread thread : threads) {
                try {
                    if (thread != null) thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        // Sustitución hacia atrás
        for (int i = L - 1; i >= 0; i--) {
            for (int j = i + 1; j < L; j++) {
                B[i] -= A[i][j] * B[j];
            }
            B[i] /= A[i][i];
        }
    }

    // Normalizar fila pivote (hacer A[pivot][pivot] = 1)
    private static void normalizePivotRow(double[][] A, double[] B, int pivot) {
        double divisor = A[pivot][pivot];
        for (int col = pivot; col < L; col++) {
            A[pivot][col] /= divisor;
        }
        B[pivot] /= divisor;
    }
}
