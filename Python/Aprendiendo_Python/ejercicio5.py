def primo(numero):
    for n in range(2,numero):
        if(numero%n==0):
            return False
    return True

numero = int(input("ingresa el numero:"))
if(primo(numero)):print("el numero es primo")
else:print("el numero no es primo")