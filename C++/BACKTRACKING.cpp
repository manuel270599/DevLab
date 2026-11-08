Funcion TSP(distancias):
    n = longitud(distancias)
    visitado = [Falso] * n
    visitado[0] = Verdadero
    mejor_distancia = Infinito

    Funcion viaje(actual, visitados, distancia_actual):
        if longitud(visitados)=n & actual=0:
            if distancia_actual < mejor_distancia:
                mejor_distancia = distancia_actual
            Detener 
        
        Para cada vecino no visitado en rango(n):
            Si no visitados[vecino]:
                visitados[vecino] = Verdadero
                nueva_distancia = distancia_actual + distancias[actual][vecino]
                viaje(vecino, visitados, nueva_distancia)
                visitados[vecino] = Falso

    viaje(0, visitado, 0)
    Devolver mejor_distancia

