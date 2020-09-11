
package domino;


public class Jugador {
    
    private final String nombre;
    private Ficha[] arrayFichas;
    private int numFichas;
    private boolean serMano;
    private static final int MAXFICHAS = 21;
    
    
    public Jugador(String nombre){
       this.nombre = nombre;
       
       arrayFichas = new Ficha[MAXFICHAS];
       numFichas = 0;
       serMano = false;
       }

    public String getNombre() {
        return nombre;
    }

    public int getNumFichas() {
        return numFichas;
    }

    public boolean getSerMano() {
        return serMano;
    }
    
    
    public int getPuntos(){
        int puntos = 0;
        for (int j = 0; j < getNumFichas(); j++) {
                puntos = puntos + elegirFicha(j-1).getDerecha();
                puntos = puntos + elegirFicha(j-1).getIzquierda();
            }
        return puntos;
    }
    
    public void setSerMano(boolean mano){
        serMano = mano;
    }
    
    public Ficha elegirFicha(int pos){
        Ficha toret;

        toret = arrayFichas[pos-1];
        
        return toret;
        
    }
    
    public void quitarFicha(Ficha ficha){
        boolean salir =false;
        int i=0;
        while(!salir){
            if(ficha == arrayFichas[i]){
                arrayFichas[i] = arrayFichas[numFichas-1];
                numFichas--;
                salir = true;
            }else{
                i++;
                if(i==numFichas){
                    salir = true;
                }
            }
        }
        
    }

    public void cogerFichaMonton(Ficha a){
        arrayFichas[numFichas]=a;
        numFichas++;
    }

    
    @Override
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        toret.append("Fichas de ").append(getNombre()).append(": \n");
        
        for (int i = 0; i < numFichas; i++) {
       toret.append("  ___ ___  ");
        }
        toret.append("\n");
        for (int i = 0; i < numFichas; i++) {
          toret.append(arrayFichas[i].toString());
        }
        toret.append("\n");
        for (int i = 0; i < numFichas; i++) {
          toret.append("  ¯¯¯ ¯¯¯  ");  
            }
        toret.append("\n");
        for (int i = 0; i < numFichas; i++) {
            toret.append("    (").append(i+1).append(")    ");
        }
        return toret.toString();
    }
    
}
