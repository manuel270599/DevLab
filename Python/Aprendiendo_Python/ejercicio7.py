lista = [1,2,3,4,5,6,7,8,9,10]
pares = []
impares = []
for n in lista:
    if(n%2==0):
        pares.append(n)
        
    else: 
        impares.append(n)
        
    pass
print(f"numeros impares:{impares}")
print(f"Numeros pares:{pares}")