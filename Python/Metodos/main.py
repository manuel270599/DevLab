import numpy as np
from scipy.optimize import minimize

# Función objetivo original
def objective(x):
    return x[0]**2

# Restricción de igualdad
def constraint(x):
    return x[0] - 1

# Función objetivo penalizada
def penalized_objective(x, r):
    return objective(x) + (1/(2*r)) * constraint(x)**2

# Inicialización de variables
r = 1.0  # Parámetro de penalización inicial
x0 = np.array([0.0])  # Punto inicial
epsilon = 1e-6  # Tolerancia para la restricción
beta = 10  # Factor de reducción de penalización

# Proceso iterativo
for i in range(10):
    # Minimización usando scipy.optimize.minimize
    res = minimize(penalized_objective, x0, args=(r,))
    
    # Mostrar resultados de la iteración
    print(f"Iteración {i+1}: x = {res.x[0]}, f(x) = {res.fun}, g(x) = {constraint(res.x)}")
    
    # Verificar la restricción
    if abs(constraint(res.x)) < epsilon:
        print("Restricción satisfecha. Termina el algoritmo.")
        break
    
    # Reducir el parámetro de penalización
    r /= beta

# Resultado final
print("Solución óptima:", res.x[0])
