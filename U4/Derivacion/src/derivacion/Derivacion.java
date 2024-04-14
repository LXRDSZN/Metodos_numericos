/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package derivacion;

import java.util.Scanner;

/**
 *
 * @author lxrdszn
 */
public class Derivacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("funcionde ln(x)tan(x)\n");
        System.out.print("┌─[LXRDSZN]─[Digita el valor de X]\n└──╼ ");
            int valor_x = sc.nextInt();
        System.out.print("┌─[LXRDSZN]─[Digita el valor de h (0.1 por defecto)]\n└──╼ ");
            double valor_h = sc.nextDouble();
            
            //creacion de un objeto para derivacion_adelante 
            Derivacion_adelante Derivacion_a = new Derivacion_adelante();
            Derivacion_a.Derivacion_adelante(valor_x, valor_h);
            
            //creacion de un objeto para derivacion_centrado
            Derivacion_centrada Derivacion_b = new Derivacion_centrada();
            Derivacion_b.Derivacion_centrada(valor_x, valor_h);
            //creacion de un objeto para derivacion_atras
            Derivacion_atras Derivacion_c = new Derivacion_atras();
            Derivacion_c.Derivacion_atras(valor_x, valor_h);
    }
    
}
//clase funcion 
class funcion_de_x{
    public void funcion_de_x(int valor_x, double valor_h){
        
    }
}
// clase para la derivacion adelante 
class Derivacion_adelante{
    public void Derivacion_adelante(int valor_x, double valor_h){
        double funciondexmash = valor_x + valor_h;       
        //aplicamos ln x+h por tan x+h
       double logdexmash  = Math.log(funciondexmash);
       double tandexmash  = Math.tan(funciondexmash);
       double fxh_mas_fxh = logdexmash * tandexmash;
        //aplicamos log x y tan x
        
        double logde_x = Math.log(valor_x);
        double tan_x   = Math.tan(valor_x);
        double flogx_ftanx = logde_x * tan_x;
        //aplicamos la formula para la derivacionadelante 
        double derivacion_evaluada = (fxh_mas_fxh-flogx_ftanx)/valor_h;
        //mostramos el resultado 
        System.out.print("\nLa derivacion adelante es : "+ derivacion_evaluada );
        
    }
}
//clase para la derivacion centrada
class Derivacion_centrada{
    public void Derivacion_centrada(int valor_x, double valor_h){
       double funciondexmash = valor_x + valor_h;   
        double funciondexmenosh = valor_x - valor_h;
         //aplicamos ln x+h por tan x+h
       double logdexmash  = Math.log(funciondexmash);
       double tandexmash  = Math.tan(funciondexmash);
       double fxh_mas_fxh = logdexmash * tandexmash;
       //aplicamos la evalucacionde log x-h y tan x-h
        double logde_x = Math.log(funciondexmenosh);
        double tan_x   = Math.tan(funciondexmenosh);
        double flogx_ftanx = logde_x * tan_x;
        
        //aplicamos la formula para la derivacionadelante 
        double derivacion_evaluada = (fxh_mas_fxh-flogx_ftanx)/(2*valor_h);
        //mostramos el resultado 
        System.out.print("\nLa derivacion centrada es : "+ derivacion_evaluada );
        
    }
}
//clase para la derivacion atras
class Derivacion_atras{
    public void Derivacion_atras(int valor_x, double valor_h){
        double funciondexmenosh = valor_x - valor_h;
        //funcion de log x por tan x 
        double logde_x = Math.log(valor_x);
        double tande_x   = Math.tan(valor_x);
        double flogx_ftanx = logde_x * tande_x;
        
        // funcion de la resta de x - h
        double log_x = Math.log(funciondexmenosh);
        double tan_x   = Math.tan(funciondexmenosh);
        double fxmenosh = log_x * tan_x;
        
        //aplicamos la formula para la derivacionadelante 
        double derivacion_evaluada = (flogx_ftanx-fxmenosh)/valor_h;
        //mostramos el resultado 
        System.out.print("\nLa derivacion atras es    : "+ derivacion_evaluada +"\n");
    }
}