from scipy.optimize import linprog
import numpy as np

def is_integer(val, tol=1e-5):
    return abs(val - round(val)) <= tol

def branch_and_bound(c, A, b, bounds, integer_vars):
    best_solution = None
    best_z = -np.inf
    stack = [([], [])]  # lista de tuplas (A_extra, b_extra)

    iterations = 0

    while stack:
        A_extra, b_extra = stack.pop()
        A_total = A + A_extra
        b_total = b + b_extra

        res = linprog(c=c, A_ub=A_total, b_ub=b_total, bounds=bounds, method='highs')

        iterations += 1
        print(f"\nIteración {iterations}:")

        if not res.success:
            print("   → Inviable")
            continue

        x = res.x
        z = -res.fun
        print(f"   → Solución: x = {x}, Z = {z:.4f}")

        if all(is_integer(x[i]) for i in integer_vars):
            print("   → Solución entera encontrada.")
            if z > best_z:
                best_z = z
                best_solution = x
        else:
            # Elegir la primera variable entera que no sea entera
            for i in integer_vars:
                if not is_integer(x[i]):
                    xi = x[i]
                    xi_floor = np.floor(xi)
                    xi_ceil = np.ceil(xi)

                    # Rama 1: xi ≤ floor(xi)
                    A1 = A_extra + [[int(j == i) for j in range(len(x))]]
                    b1 = b_extra + [xi_floor]

                    # Rama 2: xi ≥ ceil(xi) → -xi ≤ -ceil
                    A2 = A_extra + [[-int(j == i) for j in range(len(x))]]
                    b2 = b_extra + [-xi_ceil]

                    stack.append((A1, b1))
                    stack.append((A2, b2))
                    print(f"   → Ramificando sobre x{i} = {xi:.4f} ⇒ x{i} ≤ {xi_floor} y x{i} ≥ {xi_ceil}")
                    break

    if best_solution is not None:
        print("\n✅ Mejor solución entera encontrada:")
        print("   x =", best_solution.round(4))
        print("   Z =", best_z)
    else:
        print("\n❌ No se encontró solución entera.")

    return best_solution, best_z



# max x1 + 3x2
# s.a 4x1 + 12x2 ≤ 33
#     10x1 + 4x2 ≤ 35
#     x1, x2 ≥ 0
#     x1, x2 ∈ Z

c = [-1, -3]  # Max → -c para linprog (min)
A = [
    [4, 12],
    [10, 4]
]
b = [33, 35]
bounds = [(0, None), (0, None)]
integer_vars = [0, 1]

branch_and_bound(c, A, b, bounds, integer_vars)
