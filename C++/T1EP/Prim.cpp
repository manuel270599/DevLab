#include <iostream>
using namespace std;

int encontrarMinimo(int* costos, bool* incluido, int n) {
    int minimo = INT_MAX;
    int minimoIndice;

    for (int v = 0; v < n; v++) {
        if (!incluido[v] && costos[v] < minimo) {
            minimo = costos[v];
            minimoIndice = v;
        }
    }

    return minimoIndice;
}

void imprimirMST(int* padre, int** grafo, int n) {
    cout << "Aristas del arbol de expansion minima:" << endl;
    for (int i = 1; i < n; i++) {
        cout << "Arista: " << padre[i] << " - " << i << " con peso " << grafo[i][padre[i]] << endl;
    }
}

// Algoritmo de Prim para encontrar el árbol de expansión mínima
int algoritmoPrim(int** grafo, int n) {
    int* padre = new int[n];  
    int* costos = new int[n];  
    bool* incluido = new bool[n];  
    
    for (int i = 0; i < n; i++) {
        costos[i] = INT_MAX;
        incluido[i] = false;
    }

    costos[0] = 0;
    padre[0] = -1;

    for (int contador = 0; contador < n - 1; contador++) {
        int u = encontrarMinimo(costos, incluido, n);

        incluido[u] = true;

        for (int v = 0; v < n; v++) {
            if (grafo[u][v] && !incluido[v] && grafo[u][v] < costos[v]) {
                padre[v] = u;
                costos[v] = grafo[u][v];
            }
        }
    }

    // Calcular el costo total del árbol de expansión mínima
    int costoTotal = 0;
    for (int i = 1; i < n; i++) {
        costoTotal += grafo[i][padre[i]];
    }

    // Imprimir el árbol de expansión mínima
    imprimirMST(padre, grafo, n);

    return costoTotal;
}

int main() {
    int n = 8; 
    int** grafo = new int*[n];
    for (int i = 0; i < n; i++) {
        grafo[i] = new int[n];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            grafo[i][j] = 0;
        }
    }

    // ejemplo
    grafo[0][1] = 32;
    grafo[1][0] = 32;
    grafo[0][2] = 29;
    grafo[2][0] = 29;
    grafo[0][5] = 60;
    grafo[5][0] = 60;
    grafo[0][6] = 53;
    grafo[6][0] = 53;
    grafo[0][7] = 31;
    grafo[7][0] = 31;
    grafo[1][7] = 21;
    grafo[7][1] = 21;
    grafo[3][4] = 34;
    grafo[4][3] = 34;
    grafo[4][5] = 40;
    grafo[5][4] = 40;
    grafo[5][3] = 18;
    grafo[3][5] = 18;
    grafo[6][4] = 51;
    grafo[4][6] = 51;
    grafo[7][4] = 46;
    grafo[4][7] = 46;
    grafo[7][6] = 25;
    grafo[6][7] = 25;


    int costoMST = algoritmoPrim(grafo, n);

    cout << "El costo total del arbol de expansion minima es: " << costoMST << endl;

    return 0;
}
