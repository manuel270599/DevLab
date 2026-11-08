#include <iostream>
using namespace std;

bool bicolorable(int** grafo, int n);

bool dfsColor(int** grafo, int* color, int n, int v, int c);

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
 //Ejemplo
    grafo[0][4] = 1;
    grafo[4][0] = 1;
    grafo[1][2] = 1;
    grafo[2][1] = 1;
    grafo[2][6] = 1;
    grafo[6][2] = 1;
    grafo[0][7] = 1;
    grafo[7][0] = 1;
    grafo[7][5] = 1;
    grafo[5][7] = 1;
    grafo[5][3] = 1;
    grafo[3][5] = 1;

    if (bicolorable(grafo, n)) {
        cout << "Grafo bicolorable." << endl;
    } else {
        cout << "Grafo no bicolorable." << endl;
    }

    return 0;
}

bool dfsColor(int** grafo, int* color, int n, int v, int c) {
    color[v] = c;

    for (int w = 0; w < n; w++) {
        if (grafo[v][w] == 1) {
            if (color[w] == -1) {
                if (!dfsColor(grafo, color, n, w, 1 - c)) {
                    return false;
                }
            } else if (color[w] == color[v]) {
                return false;
            }
        }
    }

    return true;
}

bool bicolorable(int** grafo, int n) {
    int* color = new int[n];

    for (int v = 0; v < n; v++) {
        color[v] = -1;
    }

    for (int v = 0; v < n; v++) {
        if (color[v] == -1) {
            if (!dfsColor(grafo, color, n, v, 0)) {
                delete[] color;
                return false;
            }
        }
    }

    delete[] color;
    return true;
}

