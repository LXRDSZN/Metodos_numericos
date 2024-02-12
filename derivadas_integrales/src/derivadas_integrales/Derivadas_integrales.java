
package derivadas_integrales;
import java.util.Scanner;

import javax.sound.midi.Soundbank;
/**
 * @author lxrdszn
 */
public class Derivadas_integrales {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        while (true) {

            System.out.println("\n\n--------------------------------MENU----------------------------------------------");
            System.out.println("1) Derivadas                                                                     |");
            System.out.println("2) Integrales                                                                    |");
            System.out.println("----------------------------------------------------------------------------------");
            System.out.print("\n┌─[root@parrot]─[DIGITA UNA OPCION]\n└──╼ ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Derivadas derivadas = new Derivadas();
                    derivadas.Derivadas();                    
                    break;
                case 2:
                    Integrales integrales = new Integrales();
                    integrales.Integrales();
                    break;            
                default:
                    System.out.println("\nDigita una entrada valida");
                    break;
            }
        }
    }   
}
