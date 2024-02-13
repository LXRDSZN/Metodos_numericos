
package derivadas_integrales;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
import java.util.Scanner;
/**
 *
 * @author lxrdszn
 */
public class Derivadas {
    public void derivadas(){
    Scanner sc = new Scanner(System.in);
    String funcion = "";
        // DJep es la clase encargada de la derivacion en su escencia
         DJep djep;
         Node nodoFuncion;
         Node nodoDerivada;
        System.out.print("┌─[DIGITA TU FUNCION A DERIVAR]─[~]\n" +"└──╼ ");
        funcion = sc.nextLine();
        System.out.print(funcion);
    }
    
}
