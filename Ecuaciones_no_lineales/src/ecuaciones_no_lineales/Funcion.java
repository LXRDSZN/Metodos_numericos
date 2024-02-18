package ecuaciones_no_lineales;
import java.util.Scanner;
import java.util.function.Function;

public class Funcion {
    public void funcion() {
        Scanner sc = new Scanner(System.in);
        String funcion;

        System.out.print("┌──(DIGITA TU FUNCION)-[~]\n" +"└─  ");
        funcion = sc.nextLine();

        // Definir la función a partir de la cadena ingresada
        Function<Double, Double> function = x -> evaluar(funcion, x);

        // Pedir al usuario los límites del intervalo
        double valor_a, valor_b;
        System.out.print("┌──(DIGITA EL VALOR INICIAL DE X)-[~]\n" +"└─  ");
        valor_a = sc.nextDouble();
        System.out.print("┌──(DIGITA EL VALOR FINAL DE X)-[~]\n" +"└─  ");
        valor_b = sc.nextDouble();

        // Definir la precisión deseada
        double epsilon = 0.0001;

        // Generar la tabla de valores
        System.out.println("|    x    |    y    |");
        System.out.println("--------------------");
        for (double x = valor_a; x <= valor_b; x += 1) {
            double y = function.apply(x);
            System.out.printf("|  %.2f  |  %.2f  |\n", x, y);
        }

        // Resolver la función mediante el método de bisección
        double raiz = biseccion(function, valor_a, valor_b, epsilon);
        System.out.println("\nRaíz encontrada mediante el método de bisección: " + raiz);
    }

    private double evaluar(String funcion, double x) {
        // Dividir la cadena de la función en términos separados
        String[] terminos = funcion.split("\\+");

        double resultado = 0.0;
        for (String termino : terminos) {
            resultado += evaluarTermino(termino, x);
        }
        return resultado;
    }

    private double evaluarTermino(String termino, double x) {
        String[] partes = termino.split("x\\^");

        if (partes.length == 1) {
            // Si el término no tiene el formato "coeficiente*x^exponente", asumimos que el exponente es 1
            if (termino.matches("[0-9]+x?")) {
                if (termino.contains("x")) {
                    return Double.parseDouble(termino.replace("x", "")) * Math.pow(x, 1);
                } else {
                    return Double.parseDouble(termino) * Math.pow(x, 0);
                }
            } else {
                throw new IllegalArgumentException("Término inválido: " + termino);
            }
        } else if (partes.length == 2) {
            // Si el término tiene el formato "coeficiente*x^exponente", procedemos como antes
            double coeficiente;
            try {
                coeficiente = Double.parseDouble(partes[0].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Coeficiente inválido en el término: " + termino, e);
            }

            double exponente;
            try {
                exponente = Double.parseDouble(partes[1].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Exponente inválido en el término: " + termino, e);
            }

            return coeficiente * Math.pow(x, exponente);
        } else {
            throw new IllegalArgumentException("Término inválido: " + termino);
        }
    }

    private double biseccion(Function<Double, Double> function, double a, double b, double epsilon) {
        double fa = function.apply(a);
        double fb = function.apply(b);

        if (fa * fb > 0) {
            System.out.println("No se puede garantizar la existencia de una raíz en el intervalo dado.");
            return Double.NaN;
        }

        while (b - a >= epsilon) {
            double c = (a + b) / 2;
            double fc = function.apply(c);

            if (Math.abs(fc) < epsilon) {
                return c;
            }

            if (fa * fc < 0) {
                b = c;
            } else {
                a = c;
            }
        }

        return (a + b) / 2;
    }

    public static void main(String[] args) {
        Funcion funcion = new Funcion();
        funcion.funcion();
    }
}
