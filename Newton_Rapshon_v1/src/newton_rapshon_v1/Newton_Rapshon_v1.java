package newton_rapshon_v1;
import java.util.Scanner;


public class Newton_Rapshon_v1 {

    public static double funcion(double x) {
        return  Math.cos(x) - x * x * x;
    }

    public static double derivada(double x) {
        return -Math.sin(x) - 3.0 * x * x;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double err, x_1;
        int i=0;
        System.out.println("Metodo de Newton-Raphson, Calculo de la funcion: cos(x) - x\n");
        System.out.print("┌─[DIGITA EL VALOR DE X0]─[~]\n└──╼ ");
        double x = sc.nextDouble();
         // Imprimir la cabecera de la tabla de iteraciones
        System.out.println("-----------------------------------------------------------------");
        System.out.println("| Iteracion\t|Xn \t                | ERP\t                |");
        System.out.println("-----------------------------------------------------------------");
        do {
            x_1 = x;
            x = x - funcion(x) / derivada(x);
            err = Math.abs((x - x_1)/x);            
            // Mostrar los valores de la iteración en la tabla
            System.out.printf("| %d\t        | %.16f\t|%.16f%%\t|\n", i, x_1, err);
            i++;
        } while (x!=x_1 && i<100);
        if (i==100)
            System.out.println("\nLa soluci\242n no es convergente.\n");
        else
            System.out.println("\nLa soluci\242n es " + x + "\n");
    }

}