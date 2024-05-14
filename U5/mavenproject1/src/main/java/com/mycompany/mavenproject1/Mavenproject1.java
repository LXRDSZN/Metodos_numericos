package com.mycompany.mavenproject1;
import java.util.Scanner;

public class Mavenproject1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("┌─[LXRDSZN]─[Digita la cantidad de numeros]\n└──╼ ");
        int numerotabla = sc.nextInt();

        double[] tabla_x = new double[numerotabla];
        double[] tabla_y = new double[numerotabla];
        double suma_x = 0, suma_y = 0, media_x, media_y;

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
        
        System.out.print("\n\nMedia de x : "+ media_x +"\nmedia de y :" + media_y + "\n" );

        // Realizar la resta de la media con cada uno de los elementos de los arreglos x e y y mostrar el resultado
        System.out.println("\nTabla de valores restados por la media:\n");
        System.out.println("---------------------------------");
        System.out.println("|   x - media_x |  y - media_y  |");
        System.out.println("---------------------------------");
        
        double multiplicacionacom, sumaacomulada=0,  x_exp=0, xexp_acom=0;
        
        for(int i = 0; i < tabla_x.length; i++){
            double resta_x = tabla_x[i]- media_x;
            double resta_y = tabla_y[i]- media_y;
            System.out.printf("| %.5f\t| %.5f\t|\n", resta_x, resta_y);
            
            multiplicacionacom = resta_x * resta_y;
            sumaacomulada += multiplicacionacom;
            x_exp = resta_x * resta_x;
            xexp_acom += x_exp;
        }
       
       double valor_b = sumaacomulada / xexp_acom;
       double valor_a =  media_y - valor_b * media_x;
        System.out.print("\nEl Valor de b es: "+valor_b+"\n");
        System.out.print("El Valor de a con  a = "+ media_y + " - " +  valor_b +" * " + media_x + " es: " + valor_a+"\n");
        System.out.print("El Valor de Y = " + valor_a+ " + " + valor_b  + " X " );
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
