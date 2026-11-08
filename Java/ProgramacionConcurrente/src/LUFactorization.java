import java.util.Arrays;

public class LUDecomposition {
    public static void main(String[] args) {
        int size = 5000;
        double[][] A = new double[size][size];
        long startTime = System.nanoTime();
        double[][][] LU = decomposeLU(A);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1_000_000; // Duration in milliseconds

        System.out.println("Time taken for LU decomposition: " + duration + " milliseconds");
    }

    public static double[][][] decomposeLU(double[][] A) {
        int m = A.length;
        int n = A[0].length;
        int p = Math.min(m, n);

        double[][] L = new double[m][p];
        double[][] U = new double[p][n];
        double[][] T = new double[m][n];

        // Copy A to T
        for (int i = 0; i < m; i++) {
            T[i] = Arrays.copyOf(A[i], n);
        }

        for (int k = 0; k < p; k++) {
            for (int i = 0; i < m; i++) {
                L[i][k] = (1 / T[k][k]) * T[i][k];
            }
            for (int j = 0; j < n; j++) {
                U[k][j] = T[k][j];
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    double Z = L[i][k] * U[k][j];
                    T[i][j] -= Z;
                }
            }
        }

        double[][][] result = {L, U};
        return result;
    }
}



