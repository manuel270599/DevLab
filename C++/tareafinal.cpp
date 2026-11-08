#include <iostream>
#include <vector>

using namespace std;

// Definición de la estructura del objeto
struct Objeto {
    int peso;
    int valor;
};

// Función auxiliar para calcular el valor máximo utilizando backtracking
void kpBacktracking(vector<Objeto*>& objetos, vector<Objeto*>& mochilaActual, vector<Objeto*>& mejorMochila, int pesoActual, int& mejorValor, int indiceActual, int capacidadMochila) {
    // Si hemos alcanzado el final de la lista de objetos o se ha llenado la mochila
    if (indiceActual == objetos.size() || pesoActual >= capacidadMochila) {
        int valorActual = 0;
        for (int i = 0; i < mochilaActual.size(); i++) {
            valorActual += mochilaActual[i]->valor;
        }
        if (valorActual > mejorValor) {
            mejorValor = valorActual;
            mejorMochila = mochilaActual;
        }
        return;
    }

    // No incluir el objeto actual en la mochila
    kpBacktracking(objetos, mochilaActual, mejorMochila, pesoActual, mejorValor, indiceActual + 1, capacidadMochila);

    // Incluir el objeto actual en la mochila si no excede la capacidad
    if (pesoActual + objetos[indiceActual]->peso <= capacidadMochila) {
        mochilaActual.push_back(objetos[indiceActual]);
        kpBacktracking(objetos, mochilaActual, mejorMochila, pesoActual + objetos[indiceActual]->peso, mejorValor, indiceActual + 1, capacidadMochila);
        mochilaActual.pop_back();
    }
}

int main() {
    // Crear una lista de objetos con sus pesos y valores
    vector<Objeto*> objetos;
    objetos.push_back(new Objeto);
    objetos[0]->peso = 5;
    objetos[0]->valor = 10;
    objetos.push_back(new Objeto);
    objetos[1]->peso = 3;
    objetos[1]->valor = 8;
    objetos.push_back(new Objeto);
    objetos[2]->peso = 7;
    objetos[2]->valor = 15;

    // Definir la capacidad de la mochila
    int capacidadMochila = 10;

    // Variables para almacenar la mejor mochila y su valor
    vector<Objeto*> mejorMochila;
    int mejorValor = 0;

    // Llamar a la función de backtracking para calcular la mejor mochila y su valor máximo
    vector<Objeto*> mochilaActual;
    kpBacktracking(objetos, mochilaActual, mejorMochila, 0, mejorValor, 0, capacidadMochila);

    // Imprimir la mejor mochila y su valor máximo
    cout << "Mejor mochila:" << endl;
    for (int i = 0; i < mejorMochila.size(); i++) {
        cout << "Objeto " << i+1 << ": Peso=" << mejorMochila[i]->peso << ", Valor=" << mejorMochila[i]->valor << endl;
    }
    cout << "Valor máximo: " << mejorValor << endl;

    return 0;
}
