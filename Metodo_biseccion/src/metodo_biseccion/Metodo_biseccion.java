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
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| A\t                | B\t               | XR\t                | F(A)\t                | F(B)\t                | F(XR)\t               | F(XR)*F(A)\t         | ERP\t                     |");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        double ERP=0.00000000000001;
        double valorxr = 0.0;
        double funcion_de_a;
        double funcion_de_b;
        double funcion_de_xr;
        double funcion_fxr_x_fa;
        double anterior_xr = 0; // Variable para almacenar XR de la iteración anteriorvalorxr=(valor_a+valor_b)/2;
        // Iteraciones del método de bisección
         double erp = Double.MAX_VALUE;
                       while(erp > ERP){
                       //sacamos xr
                       valorxr=(valor_a+valor_b)/2;
          
                       // Calculamos el ERP
                       erp = Math.abs((valorxr - anterior_xr) / valorxr) * 100;


                        // Actualizamos el valor de A, B y XR para la siguiente iteración
                        Expression expression = new ExpressionBuilder(funcion)
                        .variables("x")
                        .build();

                        expression.setVariable("x", valor_a);
                        funcion_de_a = expression.evaluate();

                        expression.setVariable("x", valor_b);
                        funcion_de_b = expression.evaluate();

                         expression.setVariable("x", valorxr);
                        funcion_de_xr = expression.evaluate();

                        funcion_fxr_x_fa = funcion_de_xr * funcion_de_a;

                        // Imprimir los valores de las iteraciones en una sola fila
                        System.out.printf("| %.20f\t| %.20f\t| %.20f\t| %.20f\t| %.20f\t| %.20f\t| %.30f\t| %.20f\t|\n",
                        valor_a, valor_b, valorxr, funcion_de_a, funcion_de_b, funcion_de_xr, funcion_fxr_x_fa, erp);
                           // Actualizamos A y B para la siguiente iteración
                          if (funcion_fxr_x_fa < 0) {
                                valor_b = valorxr;
                            } else {
                                    valor_a = valorxr;
                            }

                        // Actualizamos XR anterior
                        anterior_xr = valorxr;
        }
              System.out.println("Valor final de XR: " + valorxr);
              
              
String funcion_new = "";
while (funcion_new.isEmpty()) {
    System.out.print("┌─[DIGITA TU FUNCION NUEVAMENTE SIN EL ULTIMO NUMERO]─[~]\n└──╼ ");
    funcion_new = scanner.nextLine().trim();
}

// Construir la expresión de la nueva función   
Expression expression_new = new ExpressionBuilder(funcion_new)
    .variables("x")
    .build()
    .setVariable("x", valorxr);

// Evaluar la nueva función con el valor final de XR
double resultado_new = expression_new.evaluate();

// Redondear resultado_new a dos decimales
double resultado_redondeado = Math.round(resultado_new * 100.0) / 100.0;

// Imprimir el resultado redondeado de la evaluación
System.out.println("Resultado de la evaluación de la nueva función (redondeado): " + resultado_redondeado);
    }
}
    