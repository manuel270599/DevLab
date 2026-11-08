import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

# Función objetivo: f(x) = sin(x) + x^2
def function(x):
    return np.sin(x) + x**2

# Gradiente de la función f(x) = sin(x) + x^2
def gradient(x):
    return np.cos(x) + 2 * x

# Implementación de Adagrad para una sola variable
def adagrad(x_init, learning_rate=0.1, epochs=1000, epsilon=1e-8):
    x = x_init
    G = 0  # Inicialización del acumulador de gradientes
    data = []

    for i in range(epochs):
        grad = gradient(x)
        G += grad ** 2  # Acumulación del gradiente al cuadrado
        adjusted_learning_rate = learning_rate / (np.sqrt(G) + epsilon)  # Tasa de aprendizaje ajustada
        x = x - adjusted_learning_rate * grad  # Actualización del valor de x

        # Guardar los resultados de cada iteración para la tabla
        data.append([i + 1, x, grad, adjusted_learning_rate])

    # Crear un DataFrame para mostrar los datos en formato de tabla
    df = pd.DataFrame(data, columns=['Iteración', 'Valor de x', 'Gradiente', 'Tasa de aprendizaje ajustada'])
    return df

# Función para generar el gráfico de la función y las iteraciones
def plot_function_and_iterations(df, x_range=(-5, 5)):
    x_vals = np.linspace(x_range[0], x_range[1], 400)
    y_vals = function(x_vals)

    plt.figure(figsize=(10, 6))
    
    # Gráfico de la función f(x) = sin(x) + x^2
    plt.plot(x_vals, y_vals, label='f(x) = sin(x) + x^2', color='blue')
    
    # Añadir los puntos de las iteraciones sobre la curva
    plt.scatter(df['Valor de x'], function(df['Valor de x']), color='red', zorder=5, label='Iteraciones Adagrad')
    
    # Conectar los puntos de las iteraciones
    plt.plot(df['Valor de x'], function(df['Valor de x']), color='red', linestyle='--', zorder=4)
    
    # Añadir etiquetas y título
    plt.title('Adagrad optimizando f(x) = sin(x) + x^2')
    plt.xlabel('x')
    plt.ylabel('f(x)')
    
    # Añadir leyenda
    plt.legend()
    
    # Mostrar el gráfico
    plt.grid(True)
    plt.show()

# Ejemplo de uso
if __name__ == "__main__":
    x_init = 3.0  # Valor inicial de x (puedes cambiarlo para ver diferentes resultados)
    learning_rate = 0.1
    epochs = 1000  # Aumenta el número de iteraciones

    # Ejecutar Adagrad y generar la tabla
    result_table = adagrad(x_init, learning_rate, epochs)

    # Imprimir la tabla
    print(result_table)

    # Generar el gráfico de la función y las iteraciones
    plot_function_and_iterations(result_table)
