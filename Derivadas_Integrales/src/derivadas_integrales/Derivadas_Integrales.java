/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package derivadas_integrales;
import java.util.Scanner;

/**
 *
 * @author lxrdszn
 */
public class Derivadas_Integrales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        int opcion;
      while(true){
          System.out.print("\n===============================MENU==============================================\n");
          System.out.print("1) Derivadas                                                                      |\n");
          System.out.print("2) Integrales                                                                     |");
          System.out.print("\n================================================================================\n");
          System.out.print("┌─[DIGITA UNA OPCION]─[~]\n" +"└──╼ ");
          opcion = sc.nextInt();
          switch(opcion){
            case 1:
                  Derivadas derivadas = new Derivadas();
                  derivadas.derivadas();
                    break;
            case 2:
                    break;
            default:
                    break;
            } 
        }
    }
    
}
