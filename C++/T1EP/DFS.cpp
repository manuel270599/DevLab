#include <iostream>
using namespace std;

class Grafo {
public:
    int n; 
    int** adyacencia; 

    Grafo(int n) : n(n) {
        adyacencia = new int*[n];
        for (int i = 0; i < n; ++i) {
            adyacencia[i] = new int[n];
            for (int j = 0; j < n; ++j) {
                adyacencia[i][j] = 0;
            }
        }
    }

    void agregarArista(int u, int v) {
        adyacencia[u][v] = adyacencia[v][u] = 1;
    }

    ~Grafo() {
        for (int i = 0; i < n; ++i) {
            delete[] adyacencia[i];
        }
        delete[] adyacencia;
    }
};

class DFS {
public:
    int* pre;

    DFS(Grafo& G) : grafo(G) {
        pre = new int[grafo.n];
        for (int i = 0; i < grafo.n; ++i) {
            pre[i] = -1;
        }
    }

    void iniciarBusqueda() {
        int cont = 0;
        for (int v = 0; v < grafo.n; ++v) {
            if (pre[v] == -1) {
                DFS_Visitar(v, cont);
            }
        }
    }

    void DFS_Visitar(int v, int& cont) {
        pre[v] = cont++;
        cout << "Visitando nodo " << v << " (pre[" << v << "] = " << pre[v] << ")" << endl;
        for (int w = 0; w < grafo.n; ++w) {
            if (grafo.adyacencia[v][w] && pre[w] == -1) {
                DFS_Visitar(w, cont);
            }
        }
    }

    ~DFS() {
        delete[] pre;
    }

private:
    Grafo& grafo;
};

int main() {
    int n = 8; //numero de nodos
    Grafo grafo(n);
    grafo.agregarArista(0, 2);
    grafo.agregarArista(0, 7);
    grafo.agregarArista(2, 6);
    grafo.agregarArista(7, 1);
    grafo.agregarArista(7, 4);
    grafo.agregarArista(6, 4);
    grafo.agregarArista(4, 3);
    grafo.agregarArista(4, 5);
    grafo.agregarArista(5, 0);
    grafo.agregarArista(7, 0);

    DFS dfs(grafo);
    dfs.iniciarBusqueda();

    return 0;
}
