import java.util.Arrays;
import java.util.concurrent.*;

public class ParallelCountingSort {

    private static final int THRESHOLD = 1000;

    public static void countingSortParallel(int[] array) {
        if (array.length == 0) return;

        int max = Arrays.stream(array).max().getAsInt();
        // Encontrar el valor máximo en el arreglo para dimensionar los contadores

        int processors = Runtime.getRuntime().availableProcessors();
        int[][] localCounts = new int[processors][max + 1];        // Matriz para almacenar conteos locales de cada hilo


        ForkJoinPool pool = new ForkJoinPool();

        // Conteo paralelo
        pool.invoke(new CountTask(array, localCounts, 0, array.length, max + 1));

        // Fusionar resultados
        int[] count = new int[max + 1];
        for (int i = 0; i < processors; i++) {
            for (int j = 0; j <= max; j++) {
                count[j] += localCounts[i][j];
            }
        }

        // Conteo acumulativo
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        int[] output = new int[array.length];
        // Reorganizar (estable)
        for (int i = array.length - 1; i >= 0; i--) {
            output[--count[array[i]]] = array[i];
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }

//     Clase interna que extiende RecursiveAction para dividir el conteo de elementos en paralelo.

    static class CountTask extends RecursiveAction {
        int[] array;
        int[][] localCounts;
        int start, end, range;

        CountTask(int[] array, int[][] localCounts, int start, int end, int range) {
            this.array = array;
            this.localCounts = localCounts;
            this.start = start;
            this.end = end;
            this.range = range;
        }

        @Override
        protected void compute() { // Obtener el ID del hilo actual para escribir en su fila de conteo local
            if (end - start <= THRESHOLD) {
                int id = (int) Thread.currentThread().getId() % localCounts.length;
                for (int i = start; i < end; i++) {
                    localCounts[id][array[i]]++;
                }
            } else {
                // Dividir el trabajo y procesar en paralelo
                int mid = (start + end) / 2;
                invokeAll(
                        new CountTask(array, localCounts, start, mid, range),
                        new CountTask(array, localCounts, mid, end, range)
                );
            }
        }
    }

    // Ejemplo:Ordenar el siguiente arreglo {4,2,2,8,3,3,1}
    public static void main(String[] args) {
        int[] array = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Original: " + Arrays.toString(array));
        countingSortParallel(array);
        System.out.println("Ordenado: " + Arrays.toString(array));
    }
}
