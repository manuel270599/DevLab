import numpy as np
import matplotlib.pyplot as plt

def gps(f, x0, delta=1.0, tol=1e-5, max_iter=100):
    n = len(x0)  # Dimensión del problema
    directions = np.identity(n)  # Direcciones estándar (vectores de base canónica)
    
    x = np.array(x0)
    f_values = []  # Para almacenar los valores de la función en cada iteración
    deltas = []    # Para almacenar los valores del tamaño de paso en cada iteración
    iterations = []  # Almacenar el número de iteraciones
    
    for i in range(max_iter):
        improved = False
        iterations.append(i)
        f_values.append(f(x))  # Guardar valor de la función en x
        deltas.append(delta)   # Guardar el tamaño de paso actual
        
        print(f"Iteración {i+1}: x = {x}, f(x) = {f(x)}, delta = {delta}")
        
        # Búsqueda en las direcciones positivas y negativas
        for d in directions:
            for sign in [1, -1]:
                x_new = x + sign * delta * d
                if f(x_new) < f(x):
                    x = x_new
                    improved = True
                    break
            if improved:
                break
        
        if not improved:
            # Reducir el tamaño de paso si no se encontró mejora
            delta /= 2
        
        # Verificar convergencia
        if delta < tol:
            print("Convergencia alcanzada.")
            break
    
    return x, f_values, iterations, deltas

# Ejemplo de función a minimizar (una parábola en 2D)
def funcion_ejemplo(x):
    return (x[0] - 2)**2 + (x[1] - 3)**2

# Uso del método GPS
x0 = [0, 0]  # Punto inicial
solucion, f_values, iterations, deltas = gps(funcion_ejemplo, x0)

print(f"Solución encontrada: {solucion}")

# Gráfico de la evolución de f(x) en las iteraciones
plt.figure(figsize=(12, 6))
plt.subplot(1, 2, 1)
plt.plot(iterations, f_values, label="f(x)", marker='o')
plt.title("Evolución del valor de f(x)")
plt.xlabel("Iteraciones")
plt.ylabel("f(x)")
plt.grid(True)
plt.legend()

# Gráfico del tamaño de paso
plt.subplot(1, 2, 2)
plt.plot(iterations, deltas, label="Tamaño de paso (delta)", marker='o', color='orange')
plt.title("Evolución del tamaño de paso")
plt.xlabel("Iteraciones")
plt.ylabel("Delta")
plt.grid(True)
plt.legend()

plt.tight_layout()
plt.show()

