
package domino;


public class DobleNodo <E>{
   
    private E elemento;
    private DobleNodo anterior;
    private DobleNodo siguiente;
    
    public DobleNodo(E elem, DobleNodo ant, DobleNodo sig){
        elemento = elem;
        siguiente = sig;
        anterior = ant;
    }
    public E getElemento(){
        return elemento;
    }
    public DobleNodo <E> getSiguiente(){
        return siguiente;
    }
    public DobleNodo <E> getAnterior(){
        return anterior;
    }
    public void setElemento(E elem){
        elemento = elem;
    }
    public void setSiguiente(DobleNodo <E> sig){
        siguiente = sig;
    }
    public void setAnterior (DobleNodo <E> ant){
        anterior=ant;
    }
    
}

