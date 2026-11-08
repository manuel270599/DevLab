# f(x) =2*x**2 +1
def funcion(x):
    y = 2*(x**2)+1
    return y

def pedir():
    print("Hola esta es una funcion, ingresaras un valor y te devolvera un valor")

pedir()
x = int(input("ingrese el valor:")) 
print(funcion(x))