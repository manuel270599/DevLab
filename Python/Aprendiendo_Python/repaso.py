nombre = list("JOSE manuel Montalvo ESPINOZA")

minuscula=nombre.lower()  # convierte a minusculas
mayuscula = nombre.upper() # convierte a mayusculas

busqueda = nombre.find("J") # busqueda dentro de la cadena
busqueda_index = nombre.index("o")
resultado = len(nombre) #cantidad de elementos de la lista
nombre.append("jajaja")

print(minuscula)
print(mayuscula)
print(busqueda_index)
print(resultado)
