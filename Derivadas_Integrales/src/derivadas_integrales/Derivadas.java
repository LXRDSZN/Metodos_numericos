
package derivadas_integrales;
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
        System.out.print("┌─[DIGITA TU FUNCION A DERIVAR]─[~]\n" +"└──╼ ");
        funcion = sc.nextLine();
        Derivadas_complement derivada;
        if(!funcion.isEmpty()){
            derivada = new Derivadas_complement();
            derivada.setFuncionADerivar(funcion);
            derivada.derivar();
            System.out.print("LA DERIVADA ES : "+derivada.getFuncionDerivada());

        }else{
            System.out.print("DIGITA UNA ENTRADA VALIDA");
        }
       
    }
    
}
