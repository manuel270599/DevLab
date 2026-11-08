import random

# Datos del problema
valores = [10, 40, 30, 20]
pesos = [4, 3, 5, 2]
capacidad_max = 8
n = len(valores)

def valor_total(sol):
    return sum(valores[i] for i in range(n) if sol[i] == 1)

def peso_total(sol):
    return sum(pesos[i] for i in range(n) if sol[i] == 1)

def generar_vecinos(sol):
    vecinos = []
    for i in range(n):
        vecino = sol.copy()
        vecino[i] = 1 - vecino[i]  # cambiar de 0 a 1 o de 1 a 0
        if peso_total(vecino) <= capacidad_max:
            vecinos.append(vecino)
    return vecinos

def busqueda_local(min_iter=3):
    # Generar solución inicial válida
    while True:
        sol_actual = [random.randint(0, 1) for _ in range(n)]
        if peso_total(sol_actual) <= capacidad_max:
            break

    mejor_valor = valor_total(sol_actual)
    iteraciones = 0

    print(f"Iteración {iteraciones}: solución = {sol_actual}, valor = {mejor_valor}, peso = {peso_total(sol_actual)}")

    while True:
        vecinos = generar_vecinos(sol_actual)
        mejor_vecino = sol_actual
        valor_vecino = mejor_valor

        for vecino in vecinos:
            val = valor_total(vecino)
            if val > valor_vecino:
                mejor_vecino = vecino
                valor_vecino = val

        if valor_vecino > mejor_valor:
            sol_actual = mejor_vecino
            mejor_valor = valor_vecino
        else:
            # Si no mejora, seguimos iterando solo si no se ha llegado al mínimo
            if iteraciones + 1 < min_iter:
                sol_actual = random.choice(vecinos)  # movernos aleatoriamente
                mejor_valor = valor_total(sol_actual)
            else:
                break

        iteraciones += 1
        print(f"Iteración {iteraciones}: solución = {sol_actual}, valor = {mejor_valor}, peso = {peso_total(sol_actual)}")

    return sol_actual, mejor_valor, peso_total(sol_actual)

# Ejecutar
solucion, valor, peso = busqueda_local()

# Mostrar resultado final
print("\n✅ Mejor solución encontrada:")
print("Solución:", solucion)
print("Valor total:", valor)
print("Peso total:", peso)
