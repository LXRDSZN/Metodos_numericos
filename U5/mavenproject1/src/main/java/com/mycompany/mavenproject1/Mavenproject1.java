package com.mycompany.mavenproject1;
import java.util.Scanner;

public class Mavenproject1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("┌─[LXRDSZN]─[Digita la cantidad de numeros]\n└──╼ ");
        int numerotabla = sc.nextInt();

        float[] tabla_x = new float[numerotabla];
        float[] tabla_y = new float[numerotabla];
        float suma_x = 0, suma_y = 0, media_x, media_y;

        // Datos para el arreglo de x
        for(int i = 0; i < tabla_x.length; i++){
            System.out.print("Digita los valores de x: ");
            tabla_x[i] = sc.nextFloat();
            suma_x += tabla_x[i];
        }

        System.out.print("\nValores para y\n\n");

        // Datos para el arreglo de y
        for(int i = 0; i < tabla_y.length; i++){
            System.out.print("Digita los valores de y: ");
            tabla_y[i] = sc.nextFloat();
            suma_y += tabla_y[i];
        }

        // Llamamos a la instancia para mostrar el encabezado de la tabla
        Mensaje encabezado = new Mensaje();
        encabezado.encabezado_table();

        // Bucle para mostrar los valores del arreglo en forma de tabla
        for(int i = 0; i < tabla_x.length; i++){
            System.out.printf("| %.5f\t| %.5f\t|\n", tabla_x[i], tabla_y[i]);
        }

        // Sacamos la media con respecto al valor de x e y
        media_x = suma_x / numerotabla;
        media_y = suma_y / numerotabla;

        // Realizar la resta de la media con cada uno de los elementos de los arreglos x e y y mostrar el resultado
        System.out.println("\nTabla de valores restados por la media:");
        System.out.println("---------------------------------");
        System.out.println("|   x - media_x |  y - media_y  |");
        System.out.println("---------------------------------");

        for(int i = 0; i < tabla_x.length; i++){
            float resta_x = tabla_x[i]- media_x;
            float resta_y = tabla_y[i]- media_y;
            System.out.printf("| %.5f\t| %.5f\t|\n", resta_x, resta_y);
        }
    }
}

class Mensaje {
    void encabezado_table(){
        System.out.print("\nValores de la tabla\n");
        System.out.println("---------------------------------");
        System.out.println("| x\t        | y\t        |");
        System.out.println("---------------------------------");
    }
}
