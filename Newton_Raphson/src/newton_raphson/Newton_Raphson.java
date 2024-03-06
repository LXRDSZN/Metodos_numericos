
package newton_raphson;
    //importamos las librerias que usaremos 
    import java.util.Scanner;
    import net.objecthunter.exp4j.Expression;
    import net.objecthunter.exp4j.ExpressionBuilder;

    public class Newton_Raphson {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
                System.out.print("┌─[DIGITA TU FUNCION]─[~]\n" +"└──╼ ");
                    String funcion = sc.nextLine();
                System.out.print("┌─[DIGITA UN VALOR]─[~]\n" +"└──╼ ");
                    double valor_x = sc.nextDouble();
            //funcion g(x)
            try {
                Expression expression = new ExpressionBuilder(funcion)
                        .variables("x")
                        .build()
                        .setVariable("x", valor_x);

                double resultado = expression.evaluate();

                System.out.println("El valor evaluado en la funcion es : " + resultado);
            } catch (IllegalArgumentException e) {
                System.out.println("Error al evaluar la función: " + e.getMessage());
            }
            //funcion g'(x)
            
    }
}
