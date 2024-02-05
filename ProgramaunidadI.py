from fractions import Fraction

# Función para convertir la entrada a fracción si es posible
def convertir_a_fraccion(numero):
    try:
        return Fraction(numero)
    except ValueError:
        return None

# Solicitar al usuario el valor verdadero en fracción
entrada_valor_verdadero = input("┌─[DIGITA EL VALOR VERDADERO]\n└──╼ ")
valor_verdadero_fraccion = convertir_a_fraccion(entrada_valor_verdadero)

# Solicitar al usuario el valor aproximado en fracción
entrada_valor_aproximado = input("┌─[DIGITA EL VALOR APROXIMADO]\n└──╼ ")
valor_aproximado_fraccion = convertir_a_fraccion(entrada_valor_aproximado)

# Verificar si las entradas son válidas
if valor_verdadero_fraccion is None or valor_aproximado_fraccion is None:
    print("Por favor, ingresa valores válidos.")
else:
    # Calcular el resultado
    resultado = ((valor_verdadero_fraccion - valor_aproximado_fraccion) / valor_verdadero_fraccion) * 100

    # Imprimir el resultado formateado
    if resultado > 0:
        print("La respuesta es:", resultado, "%")
    else:
        nuevoresultado = resultado * -1
        print("El resultado es:", nuevoresultado, "%")
