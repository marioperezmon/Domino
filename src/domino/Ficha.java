package domino;


public class Ficha {
    private final int izquierda;
    private final int derecha;
    
    public Ficha(int izquierda,int derecha){
        this.derecha = derecha;
        this.izquierda = izquierda;
        
    }

    public int getIzquierda() {
        return izquierda;
    }

    public int getDerecha() {
        return derecha;
    }
    
   
    public String numeros (int numero){
        switch(numero){
            case 0: return "   ";
            case 1: return " . ";
            case 2: return " : ";
            case 3: return "...";
            case 4: return ": :";
            case 5: return "::.";
            case 6: return ":::";
        }
        return null;
        
    }
    
    @Override
    
    public String toString(){
       StringBuilder toret = new StringBuilder();
       
       toret.append("-|").append(numeros(getIzquierda())).append("|").append(numeros(getDerecha())).append("|-");
       
       
       return toret.toString();
       
    }
}
