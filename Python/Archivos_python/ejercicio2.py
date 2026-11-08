archivo = open("C:/Users/Hp/Desktop/python/Archivos_python/archivo_2.txt" ,"w")
archivo.write("espinoza")
archivo.close()

archivo = open("C:/Users/Hp/Desktop/python/Archivos_python/archivo_2.txt" ,"r")
contenido = archivo.read()
print(contenido)

archivo.close()