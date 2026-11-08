#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

// Estructura para representar los objetos
struct Objeto {
    int peso;
    int valor;
    double relacion; // Relación valor/peso
};

// Función de comparación para ordenar los objetos según la relación valor/peso de forma descendente
bool compararRelacion(const Objeto& a, const Objeto& b) {
    return (a.relacion > b.relacion);
}

// Función para resolver el Problema de la Mochila utilizando Branch and Bound
int mochilaBranchAndBound(vector<Objeto>& objetos, int capacidadMaxima, vector<int>& objetosUsados) {
    // Ordena los objetos según su relación valor/peso de forma descendente
    sort(objetos.begin(), objetos.end(), compararRelacion);

    int n = objetos.size();
    int valorTotal = 0;
    int pesoActual = 0;

    for (int i = 0; i < n; ++i) {
        if (pesoActual + objetos[i].peso <= capacidadMaxima) {
            pesoActual += objetos[i].peso;
            valorTotal += objetos[i].valor;
            objetosUsados.push_back(i); // Guarda el índice del objeto seleccionado
        } else {
            int pesoRestante = capacidadMaxima - pesoActual;
            valorTotal += objetos[i].valor * (pesoRestante / objetos[i].peso);
            break;
        }
    }

    return valorTotal;
}

// Función principal
int main() {
    int capacidadMaxima = 10; // Capacidad máxima de la mochila

    // Crear y llenar el vector de objetos utilizando métodos compatibles con C++98
    vector<Objeto> *objetos = new vector<Objeto>();
    objetos->push_back({4, 10});
    objetos->push_back({3, 8});
    objetos->push_back({7, 15});
    objetos->push_back({2, 6});

    // Calcular la relación valor/peso para cada objeto
    for (size_t i = 0; i < objetos->size(); ++i) {
        (*objetos)[i].relacion = (*objetos)[i].valor / (*objetos)[i].peso;
    }

    vector<int> objetosUsados;
    int mejorValor = mochilaBranchAndBound(*objetos, capacidadMaxima, objetosUsados);

    cout << "Mejor valor obtenido en la mochila: " << mejorValor << endl;
    cout << "Objetos usados con sus pesos:" << endl;
    for (size_t i = 0; i < objetosUsados.size(); ++i) {
        cout << "Objeto " << (objetosUsados[i] + 1) << ": Peso = " << (*objetos)[objetosUsados[i]].peso << ", valor = " << (*objetos)[objetosUsados[i]].valor<<endl;
    }

    delete objetos; // Liberar la memoria del vector de objetos

    return 0;
}

