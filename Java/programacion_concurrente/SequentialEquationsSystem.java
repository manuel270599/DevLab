public class SequentialEquationsSystem {
    static final int L = 10;
    static double[][] A = {
            {3, 2, -4, 1, 5, -2, 6, 1, -3, 2, 20},
            {2, 3, 3, -2, 1, 4, -1, 5, 2, -1, 34},
            {5, -3, 1, 3, -4, 2, 1, -2, 3, 4, 10},
            {1, 4, -2, 2, 3, -3, 2, 1, -1, 5, 25},
            {-3, 2, 1, -4, 2, 1, -5, 3, 2, -2, -15},
            {4, -1, 2, 3, -2, 5, 1, -3, 4, 1, 40},
            {2, 3, 4, -1, 1, 2, 3, -2, -3, 4, 50},
            {1, 1, -3, 2, 4, -2, 5, 3, -1, 2, 30},
            {-2, 3, 1, 1, 2, -3, 4, -1, 5, -2, 18},
            {3, -1, 2, 4, -3, 1, -2, 3, 1, 2, 27}
    };

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        gaussianElimination();
        backSubstitution();

        long endTime = System.nanoTime();
        double elapsedTimeMs = (endTime - startTime) / 1_000_000.0;

        System.out.printf("\nTiempo de ejecución (secuencial): %.4f ms\n", elapsedTimeMs);
    }

    public static void gaussianElimination() {
        for (int k = 0; k < L - 1; k++) {
            // Pivoteo parcial
            int maxRow = k;
            for (int i = k + 1; i < L; i++) {
                if (Math.abs(A[i][k]) > Math.abs(A[maxRow][k])) {
                    maxRow = i;
                }
            }

            // Intercambiar filas
            double[] temp = A[k];
            A[k] = A[maxRow];
            A[maxRow] = temp;

            // Eliminación
            for (int i = k + 1; i < L; i++) {
                double factor = A[i][k] / A[k][k];
                for (int j = k; j <= L; j++) {
                    A[i][j] -= factor * A[k][j];
                }
            }
        }
    }

    public static void backSubstitution() {
        double[] x = new double[L];

        for (int i = L - 1; i >= 0; i--) {
            x[i] = A[i][L];
            for (int j = i + 1; j < L; j++) {
                x[i] -= A[i][j] * x[j];
            }
            x[i] /= A[i][i];
        }

        System.out.println("Solución:");
        for (int i = 0; i < L; i++) {
            System.out.printf("x[%d] = %.4f\n", i, x[i]);
        }
    }
}
