Valor_verdadero  = int(input("┌─[DIGITA EL VALOR VERDADERO]\n└──╼ "))
valor_aproximado = int(input("┌─[DIGITA EL VALOR APROXIMADO]\n└──╼ "))
resultado = ((Valor_verdadero-valor_aproximado)/Valor_verdadero)*100
if (resultado > 0):    
    print("Respuesta es:",resultado)
else:
    nuevoresultado = resultado * -1
    print("El resultado es : ",nuevoresultado)
    