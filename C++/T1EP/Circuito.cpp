#include <iostream>

using namespace std;

bool buscaCircuitoDFS(int** grafo, int* visit, int n, int v, int padrev) {
    visit[v] = 1;

    for (int w = 0; w < n; w++) {
        if (grafo[v][w] == 1) {
            if (visit[w] == -1) {
                if (buscaCircuitoDFS(grafo, visit, n, w, v)) {
                    return true;
                }
            } else if (padrev != w) {
                return true;
            }
        }
    }

    return false;
}

bool existeCircuito(int** grafo, int n) {
    int* visit = new int[n];
    for (int v = 0; v < n; v++) {
        visit[v] = -1;
    }

    for (int v = 0; v < n; v++) {
        if (visit[v] == -1 && buscaCircuitoDFS(grafo, visit, n, v, -1)) {
            delete[] visit;
            return true;
        }
    }

    delete[] visit;
    return false;
}

int main() {
    int n = 7; // Cambia el valor de 'n' según el número de vértices en tu grafo

    // Crear matriz de adyacencia (grafo)
    int** grafo = new int*[n];
    for (int i = 0; i < n; i++) {
        grafo[i] = new int[n];
    }

    // Inicializa la matriz de adyacencia del grafo (ejemplo)
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            grafo[i][j] = 0;
        }
    }

    // Agrega las aristas al grafo (ejemplo)
    grafo[0][1] = 1;
    grafo[0][4] = 1;
    grafo[1][5] = 1;
    grafo[5][3] = 1;
    grafo[3][6] = 1;
    grafo[4][6] = 1;
    grafo[5][6] = 1;
    
    if (existeCircuito(grafo, n)) {
        cout << "El grafo contiene un circuito." << endl;
    } else {
        cout << "El grafo no contiene circuito." << endl;
    }

    // Liberar memoria de la matriz de adyacencia
    for (int i = 0; i < n; i++) {
        delete[] grafo[i];
    }
    delete[] grafo;

    return 0;
}
