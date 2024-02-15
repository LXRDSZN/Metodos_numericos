
package integrales_derivadas;

import java.util.Scanner;

/**
 *
 * @author lxrdszn
 */
public class Integrales_Derivadas {

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
