package metodo_simpson;
import java.util.Scanner;
/**
 *
 * @author lxrdszn
 */
public class Metodo_simpson {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Integrales definidas metodo simpson\n");
        
        System.out.print("┌─[LXRDSZN]─[Digita el valor de b]\n└──╼ ");
            double valor_b = sc.nextDouble();
        System.out.print("┌─[LXRDSZN]─[Digita el valor de a]\n└──╼ ");
            double  valor_a = sc.nextDouble();
        System.out.print("┌─[LXRDSZN]─[Digita el numero de particiones (n)]\n└──╼ ");
            double particiones_n = sc.nextDouble();
            
        System.out.print("Metodo simpson \n\n1)Metodo de 1/3\n2)Metodo de 3/8\n\n");
        System.out.print("┌─[LXRDSZN]─[Digita una opcion]\n└──╼ ");
        int op = sc.nextInt();
        //evaluamos b-a/n para sacar el resultado 
        double valor_h = (valor_b - valor_a)/particiones_n;
        
        //imptimimos los valores de la tabla para ver los resultados que hay en ella 
        Tabla ver_tabla = new Tabla();
            ver_tabla.Tabla(valor_h, valor_a,valor_b, particiones_n, op);
    }
    
}
class Tabla {
    public void Tabla(double valor_h, double valor_a,double valor_b, double particiones_n, int op) {
        switch(op){
            case 1:
                System.out.print("Método de Simpson 1/3\n");

                if (particiones_n == 1) {
                    double valor_fa = Math.pow(valor_a, 3);
                    double valor_fb = Math.pow(valor_b, 3);
                    double valor_hn = (valor_h / 3) * (valor_fa + 4 * valor_fa + valor_fb);

                    System.out.print("El valor aproximado es: " + valor_hn + "\n");
                } else {
                    // Imprimir la cabecera de la tabla de iteraciones
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("|Xn\t        |x \t        | f(x)\t        |fx\t        |");
                    System.out.println("-----------------------------------------------------------------");

                    double x0 = 0; // Iniciar contador para las iteraciones
                    double x = valor_a; // Iniciar x con el valor inicial
                    double suma_fx = 0; // Variable para almacenar la suma de fx

                        while (x <= valor_b) { // Iterar hasta que x alcance valor_b
                            // Calcular f(x) = 1 / (x^2)
                            double denominador = Math.sqrt(1+Math.pow(Math.cos(x),2));
                            double fx = denominador;

                            // Calcular el peso para f(x)
                            double peso;
                            if (x0 == 0 || x == valor_b) {
                            peso = 1; // Primer y último valor, peso = 1
                            } else if (x0 % 2 == 0) {
                            peso = 2; // Nodos pares, peso = 2
                            } else {
                            peso = 4; // Nodos impares, peso = 4
                            }

                            suma_fx += peso * fx; // Acumular el valor ponderado de f(x)
                            System.out.printf("| %.5f\t| %.5f\t| %.5f\t| %.5f\t|\n", x0, x, fx, peso * fx);
                            // Incrementar x por valor_h para la próxima iteración
                            x += valor_h;
                            x0++;
                        }

                    // Imprimir la suma ponderada de f(x)
                    double aproximacion_integral = (0.3*valor_h) * suma_fx;
                    System.out.println("\nEl valor aproximado usando la fórmula general de integración es: " + aproximacion_integral);
                }

               break;
            case 2:
                System.out.print("Método de Simpson 3/8\n");
                
                if (particiones_n == 1) {          
                double valor_fa = Math.pow(valor_a, 3);
                double valor_fb = Math.pow(valor_b, 3);
                double valor_hn = (valor_h / 3) * (valor_fa + 4 * valor_fa + valor_fb);
           
                System.out.print("El valor aproximado es : " + valor_hn + "\n");
                } else {
                    // Imprimir la cabecera de la tabla de iteraciones
                    System.out.println("-----------------------------------------------------------------");
                    System.out.println("|Xn\t        |x \t        | f(x)\t        |fx*3\t        |");
                    System.out.println("-----------------------------------------------------------------");
            
                    double x0 = 0; // Iniciar contador para las iteraciones
                    double x = valor_a; // Iniciar x con el valor inicial
                    double suma_fx3 = 0; // Variable para almacenar la suma de fx*3
            
                        while (x <= valor_b) { // Iterar hasta que x alcance valor_b
                            // Calcular f(x) = 1 / (x^2) 
                            double denominador = Math.pow(x,3);
                            double fx = denominador;
                
                            // Calcular fx*3
                            double fx3;
                            if (x0 == 0 || x == valor_b) {
                                fx3 = fx; // Para el primer y último valor, fx*3 es igual a fx
                            } else {
                                fx3 = 3 * fx; // Para los valores intermedios, fx*3 es el triple de fx
                            }
                
                            suma_fx3 += fx3; // Acumular el valor de fx*3
                            System.out.printf("| %.5f\t| %.5f\t| %.5f\t| %.5f\t|\n", x0, x, fx, fx3); 
                            // Incrementar x por valor_h para la próxima iteración
                            x += valor_h;
                            x0++;
                    }       
            
                    // Imprimir la suma de fx*3
                    double aproximacion_integral = (0.375 * valor_h)*suma_fx3;
                    System.out.println("\nEl valor aproximado usando la fórmula general de integración es: " + aproximacion_integral);
                }

                break;
            default:
        }
    }
}
