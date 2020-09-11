
package domino;
import java.util.Scanner;


public class Metodos {
    
    public static String leerString(){
        Scanner entrada = new Scanner(System.in);
        String toret;
        
        toret = entrada.nextLine();
        return toret;
    }
   
    public static int leerNum(){
        Scanner entrada = new Scanner(System.in);
        int toret;
        do{
            try{
                toret = Integer.parseInt(entrada.nextLine());
            }catch(NumberFormatException exc){
                System.err.print("Error al introducir un número... Introdúcelo otra vez: ");
                toret = -1;
            }
        }while(toret == -1);
        return toret;
    }
}
