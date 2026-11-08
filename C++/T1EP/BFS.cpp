#include <iostream>
using namespace std;

int** grafo; // Matriz de adyacencia (usando puntero doble)
int* ord;
int* cola;
int frente = 0;
int fin = 0;

void insertaCola(int v) {
    cola[fin++] = v;
}

int sacarCola() {
    return cola[frente++];
}

bool colaVacia() {
    return frente == fin;
}

void BFS(int n, int inicio) {
    int cont = 0;

    // Inicializa el arreglo 'ord' con -1 para indicar que ningún vértice ha sido visitado aún.
    for (int i = 0; i < n; i++) {
        ord[i] = -1;
    }

    insertaCola(inicio);

    while (!colaVacia()) {
        int v = sacarCola();

        if (ord[v] == -1) {
            ord[v] = cont++;

            // Recorre todos los vecinos de v
            for (int w = 0; w < n; w++) {
                if (grafo[v][w] && ord[w] == -1) {
                    insertaCola(w);
                }
            }
        }
    }
}

int main() {
    int n = 8; // n según el número de vértices en tu grafo

    // Reserva memoria dinámica para la matriz de adyacencia (grafo)
    grafo = new int*[n];
    for (int i = 0; i < n; i++) {
        grafo[i] = new int[n];
    }

    // Reserva memoria dinámica para los arreglos 'ord' y 'cola'
    ord = new int[n];
    cola = new int[n];

    // Inicializa la matriz de adyacencia del grafo
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            grafo[i][j] = 0;
        }
    }
    grafo[0][2] = 1;
    grafo[0][7] = 1;
    grafo[0][5] = 1;
    grafo[2][6] = 1;
    grafo[7][1] = 1;
    grafo[5][3] = 1;
    grafo[5][4] = 1;
    grafo[3][4] = 1;

    int inicio = 0; // Cambia el vértice de inicio según tus necesidades

    BFS(n, inicio);

    // Imprime las ordenaciones de los vértices
    for (int i = 0; i < n; i++) {
        cout << "orden[" << i << "] = " << ord[i] << endl;
    }

    for (int i = 0; i < n; i++) {
        delete[] grafo[i];
    }
    delete[] grafo;
    delete[] ord;
    delete[] cola;
    return 0;
}
