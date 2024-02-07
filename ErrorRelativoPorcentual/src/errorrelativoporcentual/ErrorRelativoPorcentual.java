
package errorrelativoporcentual;
import java.util.Scanner;

public class ErrorRelativoPorcentual {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
      float entrada_valor_verdadero, entrada_valor_aproximado,resultado,nuevoresultado;
      
      System.out.print("┌─[DIGITA EL VALOR VERDADERO ]\n└──╼ ");
      entrada_valor_verdadero = sc.nextFloat();
      
      System.out.print("┌─[DIGITA EL VALOR APROXIMADO ]\n└──╼");
       entrada_valor_aproximado = sc.nextFloat();
        resultado = ((entrada_valor_verdadero - entrada_valor_aproximado) / entrada_valor_verdadero) * 100;
       
 
       if(resultado > 0){
            System.out.print("El error relativo porcentual es :"+resultado + "%");
       }else{
           nuevoresultado = resultado * -1;
           System.out.print("El Error relativo porcentual es :"+ nuevoresultado+ "%");
           
       }
       
    }
    
}
