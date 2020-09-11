
package domino;



public class Mesa {
    private Monton monton;
    private EstructuraEnlazada<Ficha> estructura;
    private  int numFichas;
    
    
    public Mesa(){
        monton = new Monton();
        estructura = new EstructuraEnlazada();
        numFichas = 0;
    }
    
    public int getNumFichas(){
        return numFichas;
    }
    

    public int getNumVeces(int numero){
        DobleNodo <Ficha> aux = estructura.getPrimerNodo();
        int toret = 0;
        for (int i = 0; i < numFichas; i++) {
            if(aux.getSiguiente().getElemento().getDerecha()== numero){
                toret++;
            }
            else{
                if(aux.getSiguiente().getElemento().getIzquierda()==numero){
                    toret++;
                }
            }
        }
        return toret;
    }
    
    public int getPrincipio(){
        return estructura.getPrimero().getIzquierda();
    }
   
    public int getFinal(){
        return estructura.getUltimo().getDerecha();
    }
    
    public Monton getMonton(){
        return monton;
    }
    
  
    public void insertarPrimero(Ficha ficha){
        estructura.insertarPrimero(ficha);
        numFichas++;
    }
    
    
    public void insertarficha(Ficha ficha){
        char lado;
        do{
            System.out.print("Introduce el lado por el cual quieres poner la ficha (D->Derecha  I->Izquierda): ");
            lado = Metodos.leerString().toUpperCase().charAt(0);
        }while(lado != 'D'&& lado != 'I');
        
        if(lado == 'D'){
            if(ficha.getDerecha()!= estructura.getUltimo().getDerecha() && ficha.getIzquierda()!= estructura.getUltimo().getDerecha() ){
                System.err.println("La ficha no se puede insertar en este lado.");

            }else{  
                if(estructura.getUltimo().getDerecha()==ficha.getDerecha()){
                    ficha = cambiarFicha(ficha);
                }
                estructura.insertarDerecha(ficha);
                numFichas++;
            }
        }
        if(lado=='I'){
            if(ficha.getDerecha()!= estructura.getPrimero().getIzquierda() && ficha.getIzquierda()!= estructura.getPrimero().getIzquierda()){
                System.err.println("La ficha no se puede insertar en este lado.");

            }else{
                if(estructura.getPrimero().getIzquierda()==ficha.getIzquierda()){
                    ficha = cambiarFicha(ficha);
                }
            estructura.insertarIzquierda(ficha);
            numFichas++;
            }
        }    
    }
    
    public Ficha cambiarFicha(Ficha ficha){
        Ficha aux = new Ficha(ficha.getDerecha(), ficha.getIzquierda());
        return aux;
    }
    
    @Override
    
    public String toString(){
        StringBuilder toret = new StringBuilder();
        DobleNodo actual = new DobleNodo(estructura.getPrimero(),null,estructura.getPrimerNodo().getSiguiente());
        
        toret.append("Fichas de la mesa: \n");
        
        for (int i = 0; i < numFichas; i++) {
            toret.append("  ___ ___  ");
        }
        toret.append("\n");
        for (int i = 0; i < numFichas; i++) {
            
            toret.append(actual.getElemento().toString());
            if(actual.getSiguiente()!=null){
            actual = actual.getSiguiente();
            }
        }
             
        
        toret.append("\n");
        for (int i = 0; i < numFichas; i++) {
          toret.append("  ¯¯¯ ¯¯¯  ");  
            
        }
        return toret.toString();
            
        }
        
    }
    

