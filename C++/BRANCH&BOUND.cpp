#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

// Definición de la estructura para representar un objeto con peso y valor
struct Objeto {
    int peso;
    int valor;
    Objeto(int p, int v) : peso(p), valor(v) {}
};

// Función comparadora para ordenar los objetos en base a su valor/peso (usada en el algoritmo)
bool comparadorObjetos(const Objeto& a, const Objeto& b) {
    return (static_cast<double>(a.valor) / a.peso) > (static_cast<double>(b.valor) / b.peso);
}

// Estructura para representar un nodo en el algoritmo de Branch and Bound
struct Nodo {
    int nivel;      // Nivel en el árbol de decisiones
    int valor;      // Valor acumulado hasta este nodo
    int peso;       // Peso acumulado hasta este nodo
    double bound;   // Límite superior (bound) para este nodo
};

// Función para calcular el límite superior (bound) de un nodo en el algoritmo
double calcularBound(Nodo nodo, int capacidadMochila, vector<Objeto>& objetos) {
    int pesoRestante = capacidadMochila - nodo.peso;
    double bound = nodo.valor;  // El bound comienza con el valor acumulado

    int nivel = nodo.nivel + 1;
    // Añadir valores fraccionarios basados en los objetos restantes que caben completamente
    while (nivel < objetos.size() && pesoRestante >= objetos[nivel].peso) {
        pesoRestante -= objetos[nivel].peso;
        bound += objetos[nivel].valor;
        nivel++;
    }

    // Si hay espacio pero no cabe completo un objeto, añadir fracción del siguiente objeto
    if (nivel < objetos.size() && pesoRestante > 0) {
        bound += pesoRestante * (static_cast<double>(objetos[nivel].valor) / objetos[nivel].peso);
    }

    return bound;
}

struct ComparadorNodos {
    bool operator()(const Nodo& a, const Nodo& b) const {
        return a.bound < b.bound;
    }
};

// Función principal para resolver el problema de la mochila usando Branch and Bound
vector<Objeto> resolverMochilaBranchAndBound(vector<Objeto>& objetos, int capacidadMochila) {
    // Ordenar los objetos por su valor/peso usando la función comparadora
    sort(objetos.begin(), objetos.end(), comparadorObjetos);

    // Cola de prioridad para explorar los nodos de manera eficiente
    priority_queue<Nodo, vector<Nodo>, ComparadorNodos> colaPrioridad;

    // Crear el nodo raíz y agregarlo a la cola de prioridad
    Nodo raiz = { -1, 0, 0, 0.0 };
    colaPrioridad.push(raiz);

    // Variables para almacenar la mejor combinación de objetos encontrada
    vector<Objeto> mejorMochila;
    Nodo mejorNodo;

    // Algoritmo de Branch and Bound
    while (!colaPrioridad.empty()) {
        Nodo nodoActual = colaPrioridad.top();
        colaPrioridad.pop();

        if (nodoActual.nivel == -1) {
            mejorNodo = nodoActual;
        }

        if (nodoActual.nivel == objetos.size() - 1) {
            continue;  // Ya se exploraron todos los objetos
        }

        // Generar el siguiente nodo (tomando el siguiente objeto disponible)
        Nodo siguienteNodo = { nodoActual.nivel + 1, nodoActual.valor + objetos[nodoActual.nivel + 1].valor,
                               nodoActual.peso + objetos[nodoActual.nivel + 1].peso, 0.0 };
        siguienteNodo.bound = calcularBound(siguienteNodo, capacidadMochila, objetos);

        // Si el nodo es factible y mejora la mejor solución encontrada hasta ahora
        if (siguienteNodo.peso <= capacidadMochila && siguienteNodo.valor > mejorNodo.valor) {
            mejorNodo = siguienteNodo;
            mejorMochila.clear();
            for (int i = 0; i <= siguienteNodo.nivel; ++i) {
                mejorMochila.push_back(objetos[i]);
            }
        }

        //Empieza la poda
        if (siguienteNodo.bound > mejorNodo.valor) {
            colaPrioridad.push(siguienteNodo);
        }
    }

    // Retornar los objetos que componen la mejor mochila encontrada
    return mejorMochila;
}

int main() {
    //ejemplo
    vector<Objeto> objetos;
    objetos.push_back(Objeto(2, 6));
    objetos.push_back(Objeto(4, 10));
    objetos.push_back(Objeto(3, 8));
    objetos.push_back(Objeto(7, 15));

    // Capacidad máxima de la mochila
    int capacidadMochila = 10;

    // Llamada a la función para resolver el problema de la mochila
    vector<Objeto> mejorMochila = resolverMochilaBranchAndBound(objetos, capacidadMochila);

    cout << "Mejor mochila:" << endl;
    int pesoTotal = 0;
    int valorTotal = 0;
    for (size_t i = 0; i < mejorMochila.size(); ++i) {
        Objeto obj = mejorMochila[i];
        cout << "Peso=" << obj.peso << ", Valor=" << obj.valor << endl;
        pesoTotal += obj.peso;
        valorTotal += obj.valor;
    }
    // vista
    cout << "Peso total de la mochila: " << pesoTotal << endl;
    cout << "Valor total de la mochila: " << valorTotal << endl;

    return 0;
}


