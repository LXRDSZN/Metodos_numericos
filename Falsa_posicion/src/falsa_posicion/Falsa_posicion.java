/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package falsa_posicion;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Scanner;

/**
 *
 * @author lxrdszn
 */
public class Falsa_posicion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        double valorxrmul;
        double valorxrpos;
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
                        //sacamos xr
                       valorxr = valor_a-((funcion_de_a)*(valor_b-valor_a)/(funcion_de_b)-(funcion_de_a));

                        // Imprimir los valores de las iteraciones en una sola fila
                        System.out.printf("| %.14f\t| %.14f\t| %.14f\t| %.14f\t| %.14f\t| %.14f\t| %.14f\t| %.14f\t|\n",
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
                       System.out.print("La raiz es :"+valorxr+"\n");
    }
    
}
