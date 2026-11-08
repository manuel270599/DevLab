import numpy as np
import pandas as pd

# Función objetivo
def objective_function(x):
    x1, x2 = x
    return (x1 - 2)**4 + (x1 - 2*x2)**2

# Penalización (h(x))
def constraint(x):
    x1, x2 = x
    return x1**2 - x2

# Función penalizada
def penalized_function(x, mu):
    return objective_function(x) + mu * constraint(x)**2

# Gradiente de la función penalizada
def grad_penalized_function(x, mu):
    x1, x2 = x
    df_dx1 = 4*(x1-2)**3 + 2*(x1-2*x2) + mu*2*(x1**2 - x2)*2*x1
    df_dx2 = -4*(x1-2*x2) + mu*2*(x1**2 - x2)*(-1)
    return np.array([df_dx1, df_dx2])

# Hessiano de la función penalizada
def hess_penalized_function(x, mu):
    x1, x2 = x
    d2f_dx1dx1 = 12*(x1-2)**2 + 2 + mu*(4*(x1**2 - x2) + 4*x1**2)
    d2f_dx1dx2 = -4 + mu*2*2*x1*(-1)
    d2f_dx2dx1 = d2f_dx1dx2
    d2f_dx2dx2 = 8 + mu*2
    return np.array([
        [d2f_dx1dx1, d2f_dx1dx2],
        [d2f_dx2dx1, d2f_dx2dx2]
    ])

# Método de Newton
def newton_minimize(mu, x0, tol=1e-8, max_iter=50):
    x = x0.copy()
    for _ in range(max_iter):
        grad = grad_penalized_function(x, mu)
        hess = hess_penalized_function(x, mu)
        try:
            delta_x = np.linalg.solve(hess, -grad)
        except np.linalg.LinAlgError:
            print("Hessiano singular. Terminando.")
            break
        x = x + delta_x
        if np.linalg.norm(grad) < tol:
            break
    return x

# Algoritmo de penalización cuadrática con tabla
def quadratic_penalty_method(x0, mu0=0.1, beta=10.0, epsilon=1e-6, max_outer_iter=5):
    mu = mu0
    x = x0.copy()
    data = []  # Para almacenar los resultados
    
    for k in range(1, max_outer_iter + 1):
        print(f"\n--- Iteración {k} ---")
        x_new = newton_minimize(mu, x)
        f_val = objective_function(x_new)
        h_val = constraint(x_new)
        alpha = abs(h_val)
        theta = 1 + alpha
        mu_alpha = mu * alpha
        # Estimación de multiplicador de Lagrange
        v = 2 * mu * h_val
        
        print(f"x = {x_new}, f(x) = {f_val:.6f}, alpha = {alpha:.6f}, mu = {mu:.6f}, mu * alpha = {mu_alpha:.6f}, v = {v:.6f}")
        
        data.append({
            'k': k,
            'mu_k': mu,
            'x1_k': x_new[0],
            'x2_k': x_new[1],
            'f(x_k)': f_val,
            'alpha(x_k)': alpha,
            'h^2(x_k)': h_val**2,
            'theta(mu_k)': theta,
            'mu_k * alpha(x_k)': mu_alpha,
            'v_k': v
        })
        
        if mu_alpha < epsilon:
            print("\nCriterio de paro alcanzado.")
            break
        mu *= beta
        x = x_new.copy()

    table = pd.DataFrame(data)
    return table

# ----------- Ejecutar -------------------
x0 = np.array([2.0, 1.0])  # Punto inicial
result_table = quadratic_penalty_method(x0)

print("\nResumen final:")
print(result_table)
