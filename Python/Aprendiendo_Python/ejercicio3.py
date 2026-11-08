inicio = int(input("ingresa el numero de inicio:"))
final =  int(input("ingrese el numero de fin:"))

for n in range(inicio,final+1):
    if(n%2==0):
        print(n, end=" ")
    