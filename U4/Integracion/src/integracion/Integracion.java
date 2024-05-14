package integracion;
import java.util.Scanner;
/**
 *
 * @author lxrdszn
 */
public class Integracion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Integrales definidas\n");
        
        System.out.print("┌─[LXRDSZN]─[Digita el valor de b]\n└──╼ ");
            double valor_b = sc.nextDouble();
        System.out.print("┌─[LXRDSZN]─[Digita el valor de a]\n└──╼ ");
            double  valor_a = sc.nextDouble();
        System.out.print("┌─[LXRDSZN]─[Digita el numero de particiones (n)]\n└──╼ ");
            double particiones_n = sc.nextDouble();
            
        //evaluamos b-a/n para sacar el resultado 
        double valor_h = (valor_b - valor_a)/particiones_n;
        
        //imptimimos los valores de la tabla para ver los resultados que hay en ella 
        Tabla ver_tabla = new Tabla();
            ver_tabla.Tabla(valor_h, valor_a,valor_b, particiones_n);
    }
    
}
class Tabla {
    public void Tabla(double valor_h, double valor_a,double valor_b, double particiones_n) {
        int y = 0;
        if(particiones_n == 1){          
           double valor_fa  = Math.pow(valor_a, 3);
           double valor_fb = Math.pow(valor_b, 3);
           double valor_hn = (valor_h/2)*(valor_fa + valor_fb);
           
           System.out.print("El valor aproximado es : " + valor_hn + "\n");
            
        } else {
            // Imprimir la cabecera de la tabla de iteraciones
            System.out.println("-----------------------------------------------------------------");
            System.out.println("|Xn\t        |x \t        | f(x)\t        |fx*2\t        |");
            System.out.println("-----------------------------------------------------------------");
            
            double x0 = 0; // Iniciar contador para las iteraciones
            double x = valor_a; // Iniciar x con el valor inicial
            double suma_fx2 = 0; // Variable para almacenar la suma de fx*2
            
            while (x <= valor_b) { // Iterar hasta que x alcance valor_b
                // Calcular f(x) = 1 / (x^2) 
                 double denominador = Math.sqrt(1+Math.pow(1/x,2));
                double fx = denominador;
                
                // Calcular fx*2
                double fx2;
                if (x0 == 0 || x == valor_b) {
                    fx2 = fx; // Para el primer y último valor, fx*2 es igual a fx
                } else {
                    fx2 = fx * 2; // Para los valores intermedios, fx*2 es el doble de fx
                }
                
                suma_fx2 += fx2; // Acumular el valor de fx*2
                System.out.printf("| %.5f\t| %.5f\t| %.5f\t| %.5f\t|\n", x0, x, fx, fx2); 
                // Incrementar x por valor_h para la próxima iteración
                x += valor_h;
                x0++;
            }
            
            // Imprimir la suma de fx*2      
            double aproximacion_integral = (valor_h / 2) * suma_fx2;
            System.out.println("\nEl valor aproximado usando la formula general de integracion es: " + aproximacion_integral);
        }
    }
}
