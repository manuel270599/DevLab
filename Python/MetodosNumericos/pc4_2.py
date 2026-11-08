def simplex_dual(c, A, b):
    m, n = A.shape

    A = -A
    b = -b

    slack = np.eye(m)
    A = np.hstack((A, slack))
    c_ext = np.concatenate([c, np.zeros(m)])

    base = list(range(n, n+m))
    tableau = np.hstack((A, b.reshape(-1,1)))

    iter_num = 0
    while True:
        cols = [f"x{i+1}" for i in range(n)] + [f"s{i+1}" for i in range(m)] + ["RHS"]
        index = [f"r{i+1}" for i in range(m)]
        df = pd.DataFrame(tableau, columns=cols, index=index)
        print(f"\nIteración {iter_num}:")
        print(df.round(3))

        # Si no hay RHS negativos, revisar optimalidad
        if np.all(tableau[:, -1] >= 0):
            cb = c_ext[base]
            zj = cb @ tableau[:, :-1]
            zj_cj = zj - c_ext

            print("\nZj - Cj:")
            print(pd.Series(zj_cj, index=cols[:-1]).round(3))

            if np.all(zj_cj <= 1e-10):
                print("\n✅ Solución óptima encontrada.")
                break
            else:
                # Variable entrante (Zj - Cj > 0)
                entering = np.argmax(zj_cj)
                if zj_cj[entering] <= 0:
                    print("\n❌ No existe solución óptima.")
                    return

                # Razones para variable saliente
                col = tableau[:, entering]
                rhs = tableau[:, -1]
                ratios = []
                for i in range(m):
                    if col[i] > 0:
                        ratios.append(rhs[i] / col[i])
                    else:
                        ratios.append(np.inf)

                if all(r == np.inf for r in ratios):
                    print("\n❌ Problema no acotado, no solución óptima.")
                    return

                leaving = np.argmin(ratios)
                pivot = tableau[leaving, entering]
                tableau[leaving, :] /= pivot
                for i in range(m):
                    if i != leaving:
                        tableau[i, :] -= tableau[i, entering] * tableau[leaving, :]

                base[leaving] = entering
                iter_num += 1

        else:
            # Hay RHS negativos → seleccionar fila dual (más negativo)
            leaving = np.argmin(tableau[:, -1])
            row = tableau[leaving, :-1]

            # Elegir variable entrante (coeficiente negativo con menor razón)
            candidates = []
            for j in range(len(row)):
                if row[j] < 0:
                    candidates.append(j)

            if not candidates:
                print("\n❌ Problema no tiene solución óptima (dual no factible).")
                return

            # Calcular razón Zj - Cj / coeficiente negativo
            cb = c_ext[base]
            zj = cb @ tableau[:, :-1]
            zj_cj = zj - c_ext

            ratios = []
            for j in candidates:
                ratios.append(zj_cj[j] / (-row[j]))

            entering = candidates[np.argmin(ratios)]

            pivot = tableau[leaving, entering]
            tableau[leaving, :] /= pivot
            for i in range(m):
                if i != leaving:
                    tableau[i, :] -= tableau[i, entering] * tableau[leaving, :]

            base[leaving] = entering
            iter_num += 1

    # Imprimir solución
    solution = np.zeros(n+m)
    for i, var in enumerate(base):
        solution[var] = tableau[i, -1]

    print("\nValores de las variables originales:")
    for i in range(n):
        print(f"x{i+1} = {solution[i]:.3f}")
    print(f"\nValor mínimo de Z = {c_ext[:n] @ solution[:n]:.3f}")

# Ejecutar el ejemplo
c = np.array([3,4,5])
A = np.array([
    [1, 2, 3],
    [2, 2, 1]
])
b = np.array([5,6])

simplex_dual(c, A, b)