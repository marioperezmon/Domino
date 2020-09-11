
package domino;

import java.util.Random;



public class Monton {
    public  Ficha[] arrayFichas;
    private final static int MAXFICHAS = 28;
    private int numFichas;
    
   
    public Monton (){
        arrayFichas = new Ficha[MAXFICHAS];
        numFichas = MAXFICHAS;
        
        
        int i = 0;
        int x = 0;
        
        for (int k = 0; k < 7; k++) {
            for (int j = k; j < 7; j++) {
                arrayFichas[i] = new Ficha(j, k);
                i++;
            }
        }
        
        }

    public int getNumFichas() {
        return numFichas;
    }
    
    
    public Ficha cogerFicha(){
        Ficha toret;
        int i;
        Random aleatorio = new Random(System.currentTimeMillis());
        i = aleatorio.nextInt(numFichas);
        toret = arrayFichas[i];
        arrayFichas[i] = arrayFichas[numFichas-1];
        numFichas--;
        return toret;
        }
    }
    
    
    
    
    
    
    
    
    
            

