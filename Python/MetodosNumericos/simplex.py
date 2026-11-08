from scipy.optimize import linprog
import numpy as np

# Función objetivo: maximizar 10x1 + 40x2 + 30x3 + 20x4
c = [-10, -40, -30, -20]  # negativo porque linprog minimiza

# Restricciones: 4x1 + 3x2 + 5x3 + 2x4 <= 8
A = [[4, 3, 5, 2]]
b = [8]

# Rango inicial: 0 <= xi <= 1
bounds = [(0, 1) for _ in range(4)]

# Función de Branch and Bound
mejor_valor = -np.inf
mejor_sol = None

def es_entera(x):
    return all(abs(i - round(i)) < 1e-6 for i in x)

def branch_and_bound(c, A, b, bounds):
    global mejor_valor, mejor_sol

    res = linprog(c, A_ub=A, b_ub=b, bounds=bounds, method="highs")

    if not res.success:
        return  # rama inválida

    valor = -res.fun
    x = res.x

    if valor <= mejor_valor:
        return  # no mejora

    if es_entera(x):
        mejor_valor = valor
        mejor_sol = [int(round(i)) for i in x]
        return

    # Elegir variable fraccional para ramificar
    for i in range(len(x)):
        if abs(x[i] - round(x[i])) > 1e-6:
            xi = x[i]
            # Rama 1: xi <= floor(xi)
            bounds_izq = bounds.copy()
            bounds_izq[i] = (bounds[i][0], np.floor(xi))
            branch_and_bound(c, A, b, bounds_izq)

            # Rama 2: xi >= ceil(xi)
            bounds_der = bounds.copy()
            bounds_der[i] = (np.ceil(xi), bounds[i][1])
            branch_and_bound(c, A, b, bounds_der)
            break  # solo una rama a la vez

# Ejecutar
branch_and_bound(c, A, b, bounds)

# Mostrar resultado
print(" Mejor solución entera encontrada:")
print("x =", mejor_sol)
print("Valor máximo =", mejor_valor)
print("Peso total =", sum([mejor_sol[i] * [4, 3, 5, 2][i] for i in range(4)]))