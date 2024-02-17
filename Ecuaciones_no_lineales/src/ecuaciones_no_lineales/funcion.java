package ecuaciones_no_lineales;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Scanner;
import java.util.function.Function;
public class funcion {
    public void funcion() {
        Scanner sc = new Scanner(System.in);
        String funcionbiseccion;
        double valor_a, valor_b;
        System.out.print("┌──(DIGITA TU FUNCION)-[~]\n" +"└─  ");
        funcionbiseccion = sc.nextLine();
        //entrada de la funcion
                Function<Double, Double> function;
        function = x -> {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");
            try {
                if (engine == null) {
                    throw new RuntimeException("No se pudo encontrar el motor de script adecuado.");
                }
                engine.eval("var x = " + x + ";");
                return Double.valueOf(engine.eval(funcionbiseccion).toString());
            } catch (ScriptException e) {
                e.printStackTrace();
                return null;
            }
        };
        //entrada de los valores a y b para la tabla 
        
         System.out.print("┌──(DIGITA EL VALOR INICIAL DE X)-[~]\n" +"└─  ");
         valor_a = sc.nextDouble();
         System.out.print("┌──(DIGITA EL VALOR FINAL DE X)-[~]\n" +"└─  ");
         valor_b = sc.nextDouble();
    }

}