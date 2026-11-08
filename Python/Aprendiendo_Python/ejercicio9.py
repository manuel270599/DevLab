palabra = input("ingresa la palabra:")
inversa = palabra[::-1]

if(palabra == inversa): print(f"La palabra {palabra} es palindroma")
else: print(f"La palabra {palabra} no es palindroma")