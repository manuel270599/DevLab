#include <iostream>
#include <vector>

using namespace std;

// Estructura del objeto que tiene peso y valor
struct Objeto {
    int peso;
    int valor;
};

// Definición de la estructura del grafo
struct Nodo {
    Objeto* objeto;
    vector<Nodo*> conexiones;
};

// Clase para resolver el problema de la mochila utilizando un grafo
class GrafoMochila {
private:
    vector<Nodo*> nodos;

    // Función recursiva de backtracking para encontrar la mejor combinación
    void backtracking(Nodo* nodoActual, vector<Objeto*>& mochilaActual, vector<Objeto*>& mejorMochila, int pesoActual, int& mejorValor, int capacidadMochila) {
        // Condición de parada: si llegamos al final del grafo o se excede la capacidad de la mochila
        if (nodoActual == NULL || pesoActual >= capacidadMochila) {
            int valorActual = 0;
            int pesoTotal = 0;
            // Calcular el valor y el peso total de la mochila actual
            for (size_t i = 0; i < mochilaActual.size(); ++i) {
                Objeto* obj = mochilaActual[i];
                valorActual += obj->valor;
                pesoTotal += obj->peso;
            }
            // Si el valor actual es mejor, actualizamos la mejor mochila encontrada
            if (valorActual > mejorValor) {
                mejorValor = valorActual;
                mejorMochila.clear(); // Limpiamos la mejor mochila anterior
                // Copiamos los objetos de la mochila actual a la mejor mochila
                for (size_t i = 0; i < mochilaActual.size(); ++i) {
                    Objeto* obj = mochilaActual[i];
                    Objeto* nuevoObjeto = new Objeto;
                    nuevoObjeto->peso = obj->peso;
                    nuevoObjeto->valor = obj->valor;
                    mejorMochila.push_back(nuevoObjeto);
                }
            }
            return;
        }

        // No inlcuir el objeto actual en la mochila
        backtracking(nodoActual->conexiones.empty() ? NULL : nodoActual->conexiones[0], mochilaActual, mejorMochila, pesoActual, mejorValor, capacidadMochila);

        // Incluir el objeto actual en la mochila si no excede la capacidad
        //Acá ocurre el backtrack
        if (pesoActual + nodoActual->objeto->peso <= capacidadMochila) {
            mochilaActual.push_back(nodoActual->objeto);
            backtracking(nodoActual->conexiones.empty() ? NULL : nodoActual->conexiones[0], mochilaActual, mejorMochila, pesoActual + nodoActual->objeto->peso, mejorValor, capacidadMochila);
            mochilaActual.pop_back();
        }
    }

public:
    GrafoMochila() {}

    // Método para agregar un objeto al grafo
    void agregarObjeto(Objeto* objeto) {
        Nodo* nodo = new Nodo;
        nodo->objeto = objeto;
        nodos.push_back(nodo);
    }

    // Método para conectar dos objetos en el grafo
    void conectar(int origen, int destino) {
        nodos[origen]->conexiones.push_back(nodos[destino]);
    }

    // Método para resolver el problema de la mochila y obtener la mejor combinación de objetos
    vector<Objeto*> resolverMochila(int capacidadMochila) {
        vector<Objeto*> mochilaActual;
        vector<Objeto*> mejorMochila;
        int pesoActual = 0;
        int mejorValor = 0;

        // Llamada inicial a la función de backtracking desde el primer nodo del grafo
        backtracking(nodos.empty() ? NULL : nodos[0], mochilaActual, mejorMochila, pesoActual, mejorValor, capacidadMochila);

        return mejorMochila;
    }
};


int main() {
    // Se crea el grafo mochila
    GrafoMochila grafoMochila;

    // Creación de objetos con su respectivo peso y valor
    // EJEMPLO(4OBJETOS)
    Objeto* objeto1 = new Objeto;
    objeto1->peso = 4;
    objeto1->valor = 10;
    Objeto* objeto2 = new Objeto;
    objeto2->peso = 3;
    objeto2->valor = 8;
    Objeto* objeto3 = new Objeto;
    objeto3->peso = 7;
    objeto3->valor = 15;
    Objeto* objeto4 = new Objeto;
    objeto4->peso = 2;
    objeto4->valor = 6;

    // Agregar los objetos al grafo
    grafoMochila.agregarObjeto(objeto1);
    grafoMochila.agregarObjeto(objeto2);
    grafoMochila.agregarObjeto(objeto3);
    grafoMochila.agregarObjeto(objeto4);

    // Conectar los objetos en el grafo para representar las restricciones
    grafoMochila.conectar(0, 1);
    grafoMochila.conectar(1, 2);
    grafoMochila.conectar(2, 3);

    // Resolver el problema de la mochila con una capacidad específica (10 en este caso)
    vector<Objeto*> mejorMochila = grafoMochila.resolverMochila(10);

    //Impresion
    cout << "*|Mejor mochila|*" << endl;
    int pesoTotal = 0;
    int valorTotal = 0;
    for (size_t i = 0; i < mejorMochila.size(); ++i) {
        Objeto* obj = mejorMochila[i];
        cout << "PESO=" << obj->peso << " | VALOR=" << obj->valor << endl;
        pesoTotal += obj->peso;
        valorTotal += obj->valor;
    }
    cout << "Peso total de la mochila: " << pesoTotal << endl;
    cout << "Valor total de la mochila: " << valorTotal << endl;

    // Liberar memoria
    delete objeto1;
    delete objeto2;
    delete objeto3;
    delete objeto4;

    return 0;
}
