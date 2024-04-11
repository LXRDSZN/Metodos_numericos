/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package derivada;

/**
 *
 * @author lxrdszn
 */
import org.matheclipse.core.expression.F;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.eval.ExprEvaluator;

import java.util.Scanner;

public class Derivada {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca la función matemática de la cual desea calcular la derivada con respecto a x:");

        String inputFuncion = scanner.nextLine();
        
        // Crear una instancia de ExprEvaluator, que se utiliza para evaluar las expresiones
        ExprEvaluator util = new ExprEvaluator();

        // Construir la expresión para la derivada. Por ejemplo, si el usuario introduce "Sin[x]", esto construye "D[Sin[x], x]".
        String derivadaExpresion = "D[" + inputFuncion + ", x]";
        
        // Evaluar la expresión de la derivada
        IExpr result = util.evaluate(derivadaExpresion);

        System.out.println("La derivada de la función ingresada con respecto a x es: " + IExpr.toString());
    }
}
