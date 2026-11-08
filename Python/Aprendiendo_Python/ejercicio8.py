numero = int(input("ingrese el numero:"))

# def factorial(numero):
#     variable=1
#     for i in range(1,numero+1):
#         variable = variable*i
#     return variable
    
# print(f"El factorial de {numero} es {factorial(numero)}")

def factory(numero):
    if( numero==0 or numero==1):
        return 1
    else :
        return numero*factory(numero-1)
print(f"el factorial de {numero} es {factory(numero)}")