/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package metodo_biseccion;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Scanner;

public class Metodo_biseccion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("┌─[DIGITA TU FUNCION]─[~]\n└──╼ ");
        String funcion = scanner.nextLine();

        System.out.print("┌─[DIGITA EL VALOR DE X INICIAL]─[~]\n└──╼ ");
        double valorInicioAx = scanner.nextDouble();

        System.out.print("┌─[DIGITA EL VALOR DE X FINAL]─[~]\n└──╼ ");
        double valorFinBx = scanner.nextDouble();

        // Imprimir la tabla de valores de x e y una sola vez
        System.out.println("Tabla de valores:");
        System.out.println("x\t| y");
        System.out.println("--------------");
        for (double x = valorInicioAx; x <= valorFinBx; x++) {
            try {
                Expression expression = new ExpressionBuilder(funcion)
                        .variables("x")
                        .build()
                        .setVariable("x", x);

                double resultado = expression.evaluate();

                System.out.println(x + "\t| " + resultado);
            } catch (IllegalArgumentException e) {
                System.out.println("Error al evaluar la función: " + e.getMessage());
            }
        }

        System.out.print("┌─[DIGITA EL VALOR DE A]─[~]\n└──╼ ");
        double valor_a = scanner.nextDouble();

        System.out.print("┌─[DIGITA EL VALOR DE B]─[~]\n└──╼ ");
        double valor_b = scanner.nextDouble();

        // Imprimir la cabecera de la tabla de iteraciones
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| A\t        | B\t        | XR\t        | F(A)\t        | F(B)\t        | F(XR)\t        | F(XR)*F(A)\t| ERP\t        |");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");

        // Iteraciones del método de bisección
        double erp = Double.MAX_VALUE;
        double valorxr = 0;
        while (erp > 0.000000000000001) { // Cambiar el criterio de parada según tus necesidades
            // Calcular XR y las funciones en A, B y XR
            valorxr = (valor_a + valor_b) / 2;

            Expression expression = new ExpressionBuilder(funcion)
                    .variables("x")
                    .build()
                    .setVariable("x", valor_a);
            double funcionA = expression.evaluate();

            expression.setVariable("x", valor_b);
            double funcionB = expression.evaluate();

            expression.setVariable("x", valorxr);
            double funcionXR = expression.evaluate();

            double funcionXR_A = funcionXR * funcionA;

            // Imprimir los valores de las iteraciones en una sola fila
            System.out.printf("| %.5f\t| %.5f\t| %.5f\t| %.5f\t| %.5f\t| %.5f\t| %.5f\t| %.5f\t|\n",
                    valor_a, valor_b, valorxr, funcionA, funcionB, funcionXR, funcionXR_A, erp);

            // Actualizar los valores de A, B, XR, las funciones y ERP para la siguiente iteración
            if (funcionXR_A < 0) {
                valor_b = valorxr;
            } else {
                valor_a = valorxr;
            }

            erp = Math.abs((valor_b - valor_a) / valor_b); // Criterio de parada: Error Relativo Porcentual
        }
    }
}