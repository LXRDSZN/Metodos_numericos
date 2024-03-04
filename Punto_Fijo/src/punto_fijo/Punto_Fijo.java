/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package punto_fijo;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Scanner;
/**
 *
 * @author lxrdszn
 */
public class Punto_Fijo {
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
       //DIGITAMOS LOS VALORES DE CONFANZA
          System.out.print("┌─[DIGITA EL VALOR DE A]─[~]\n└──╼ ");
        double valor_a = scanner.nextDouble();

          System.out.print("┌─[DIGITA EL VALOR DE B]─[~]\n└──╼ ");
        double valor_b = scanner.nextDouble();
        
        //sacamos punto medio
        double punto_medio = (valor_a + valor_b)/2;
        //Despejamos g(x)
        
        //despejamos la segunda g(x)
        
        
        
    }
    
}
