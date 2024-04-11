/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package newton_raphson;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import java.util.Scanner;
public class Newton_Raphson {
    int iteracion;
    double erp = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("┌─[DIGITA TU FUNCION]─[~]\n" +"└──╼ ");
        String funcion = sc.nextLine();
        System.out.print("┌─[DIGITA UN VALOR]─[~]\n" +"└──╼ ");
        double valor_x = sc.nextDouble();  
        // Crea una instancia de Derivadas_complement y calcula la derivada
        Derivadas_complement derivada = new Derivadas_complement();
        derivada.setFuncionADerivar(funcion);
        derivada.derivar();
       // Obtiene el resultado de la derivada como un String
        String resultadoDerivada = derivada.getFuncionDerivada();
        System.out.println("Resultado de la derivada: " + resultadoDerivada);
        double resultadoFuncion = Funciondex.funciondex(funcion, valor_x);
        // Imprimir la cabecera de la tabla de iteraciones
        System.out.println("---------------------------------------------------------");
        System.out.println("| Iteracion\t|Xn \t                | ERP\t        |");
        System.out.println("---------------------------------------------------------");
        int iteracion = 1;
        double xn = valor_x;
        double erp = 100.0;
        while (erp > 0.01) {
            // Calcula la derivada y la función en cada iteración
            double resiultadoenderivacion = Funcionderivadax.dFuncionderivadax(resultadoDerivada, xn);
            resultadoFuncion = Funciondex.funciondex(funcion, xn);

            double xn_anterior = xn;
            xn = xn - (resultadoFuncion / resiultadoenderivacion);
            erp = Math.abs((xn - xn_anterior) / xn) * 100.0;

            // Mostrar los valores de la iteración en la tabla
            System.out.printf("| %d\t        | %.15f\t|%.8f%%\t|\n", iteracion, xn, erp);

            iteracion++;
        }
    }
    
}

class Funcionderivadax{
   public static double dFuncionderivadax(String resultadoDerivada, double valor_x){
               double resultadoderivadoengx = 0.0;
        try {
            Expression expression = new ExpressionBuilder(resultadoDerivada)
                    .variables("x")
                    .build()
                    .setVariable("x", valor_x);

            resultadoderivadoengx = expression.evaluate();

        } catch (IllegalArgumentException e) {
            System.out.println("Error al evaluar la función: " + e.getMessage());
        }
        return resultadoderivadoengx;
    }
}

class Funciondex {
    public static double funciondex(String funcion, double valor_x) {
        double resultado = 0.0;
        try {
            Expression expression = new ExpressionBuilder(funcion)
                    .variables("x")
                    .build()
                    .setVariable("x", valor_x);

            resultado = expression.evaluate();

     
        } catch (IllegalArgumentException e) {
            System.out.println("Error al evaluar la función: " + e.getMessage());
        }
        return resultado;
    }
}

//clase para la derivacion de la funcion perteneciente al String funcion
class Derivadas {
    public void derivadas(String funcion){
    Scanner sc = new Scanner(System.in);
    //String funcion = "";
        Derivadas_complement derivada;
        if(!funcion.isEmpty()){
            derivada = new Derivadas_complement();
            derivada.setFuncionADerivar(funcion);
            derivada.derivar();
            System.out.print("LA DERIVADA ES : "+derivada.getFuncionDerivada()+"\n");

        }else{
            System.out.print("DIGITA UNA ENTRADA VALIDA\n");
        }
       
    }
    
}
class Derivadas_complement {
     //Variable que almacena las funciones a derivar
    private String funcion = "";
    // DJep es la clase encargada de la derivacion en su escencia
    DJep djep;
    Node nodoFuncion;
    Node nodoDerivada;
    
    public Derivadas_complement() {
        //...
    }
     public void setFuncionADerivar(String funcion) {
        this.funcion = funcion;
    }

    public String getFuncionDerivada() {
        return this.funcion;
    }
  public void derivar() {

        try {

            this.djep = new DJep();
            // agrega funciones estandares cos(x), sin(x)
            this.djep.addStandardFunctions();

            // agrega constantes estandares, pi, e, etc
            this.djep.addStandardConstants();

            // por si existe algun numero complejo
            this.djep.addComplex();

            // permite variables no declarables
            this.djep.setAllowUndeclared(true);

            // permite asignaciones
            this.djep.setAllowAssignment(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.setImplicitMul(true);

            // regla de multiplicacion o para sustraccion y sumas
            this.djep.addStandardDiffRules();

            // coloca el nodo con una funcion preestablecida
            this.nodoFuncion = this.djep.parse(this.funcion);

            // deriva la funcion con respecto a x
            Node diff = this.djep.differentiate(nodoFuncion, "x");

            // Simplificamos la funcion con respecto a x
            this.nodoDerivada = this.djep.simplify(diff);

            // Convertimos el valor simplificado en un String
            this.funcion = this.djep.toString(this.nodoDerivada);

        } catch (ParseException e) {
            this.funcion = "NaN";
            System.out.println("Error: " + e.getErrorInfo());
        }
    }
}
