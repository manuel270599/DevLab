def metodo_secante(f, x0, x1, tol=1e-5, max_iter=100):
    for i in range(max_iter):
        if abs(f(x1) - f(x0)) < tol:
            print("Riesgo de división por cero.")
            return None
        # Calcular la siguiente aproximación
        x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0))
        # Verificar si se ha alcanzado la convergencia
        if abs(x2 - x1) < tol:
            return x2
        # Actualizar valores para la siguiente iteración
        x0, x1 = x1, x2
    print("Se alcanzó el número máximo de iteraciones.")
    return None

# Ejemplo de uso:
f = lambda x: x**3 - 6*x**2 + 11*x - 6  # Función de ejemplo
raiz = metodo_secante(f, 2.5, 3.5)
print(f"Raíz encontrada: {raiz}")
