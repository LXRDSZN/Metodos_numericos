package newton_rapshon_v1;
import java.util.Scanner;


public class Newton_Rapshon_v1 {

    public static double funcion(double x) {
        return Math.pow(x, 3)-x-1;
    }

    public static double derivada(double x) {
        return Math.pow(x, 2)*3-1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double err, x_1;
        int iteracion=1;
        System.out.print("La funcion a calcular con el metodo de Newton Raphson es  (x^3-x-1)\n\n");
        System.out.print("┌─[DIGITA EL VALOR DE X0]─[~]\n└──╼ ");
        double x = sc.nextDouble();
         // Imprimir la cabecera de la tabla de iteraciones
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| Iteracion\t|Xn \t                | ERP\t                |");
        System.out.println("-----------------------------------------------------------------");
        double xn = x;
        do {
            xn = x;
            x = xn - funcion(xn) / derivada(xn);
            err = Math.abs((x - xn) / x) * 100;  // Cálculo del error relativo porcentual
            System.out.printf("| %d\t        | %.16f\t| %.16f%%\t|\n", iteracion, xn, err);
            iteracion++;
        } while (err > 0.01);
        
    }

}