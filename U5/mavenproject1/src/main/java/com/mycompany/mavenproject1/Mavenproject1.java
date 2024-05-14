
package com.mycompany.mavenproject1;
import java.util.Scanner;
public class Mavenproject1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Definimos el tamaño del arreglo para la tabla de x e y con base a la s necesidades del usuario 
        
        System.out.print("┌─[LXRDSZN]─[Digita  la cantidad de numeros]\n└──╼ ");
        int numerotabla = sc.nextInt();
        
        //arreglo para la dimension con respecto a la cantidad de numero con x 
        int [] tabla_x = new int[numerotabla]; 
        //arrglo para la dimension con re4specto a la cantidad de numeros con y
        int [] tabla_y = new int[numerotabla];
        int suma_x = 0, suma_y = 0, media_x, media_y;
         
        //Datos para el arreglo de x
        for(int i = 0; i < tabla_x.length;i++){
            System.out.print("Digita los valores de x: ");
            tabla_x[i] = sc.nextInt();  
            suma_x += tabla_x[i];           
        }
        
         System.out.print("\nValores para y\n\n");
        
        //Datos para el arreglo de y
        for(int i = 0; i < tabla_x.length;i++){
            System.out.print("Digita los valores de y: ");
            tabla_y[i] = sc.nextInt(); 
            suma_y += tabla_y[i];
        }
        //Llamamos a la instalncia para mostrar el encabezado de la tabla
        Mensaje encabezado = new Mensaje();
            encabezado.encabezado_table();
            
            //Bucle para mostrar los valores del arreglo en forma de tabla
           for(int i = 0; i < tabla_x.length; i++){
            System.out.printf("| %.1f\t| %.1f\t|\n", (float)tabla_x[i], (float)tabla_y[i]); 
        }
       //sacamos la media con respecto al valor de x e y 
       media_x = suma_x/numerotabla;
       media_y = suma_y/numerotabla;
       
       
    }
}


class Mensaje{
    void encabezado_table(){
        System.out.print("\nValores de la tabla\n");
        System.out.println("-----------------");
        System.out.println("| x\t| y\t|");
        System.out.println("-----------------");
    }
}

