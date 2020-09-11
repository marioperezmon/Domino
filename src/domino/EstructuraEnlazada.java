
package domino;


public class EstructuraEnlazada <E>{
    private DobleNodo<E> primero;
    private DobleNodo<E> ultimo;
    private int numElemento;
    
    public EstructuraEnlazada(){
        primero = null;
        ultimo = null;
    }
  
    
    public void insertarPrimero(E elemento){
        DobleNodo <E> nuevo = new DobleNodo(elemento, null, null);
        primero = nuevo;
        ultimo=nuevo;
    }
    
    public void insertarIzquierda(E elemento){
        DobleNodo <E> nuevo = new DobleNodo(elemento, null, primero);
        primero.setAnterior(nuevo);
        primero = nuevo;
    }
    
    public void insertarDerecha(E elemento){
        DobleNodo<E> nuevo = new DobleNodo(elemento,ultimo,null);
        ultimo.setSiguiente(nuevo);
        ultimo = nuevo;
    }
    
    public E getPrimero(){
        return primero.getElemento();
    }
    
    public E getUltimo() {
        return ultimo.getElemento();
    }
    
    public DobleNodo <E> getSiguiente(DobleNodo a){
        return a.getSiguiente();
    }
    
    public DobleNodo<E> getPrimerNodo(){
        return primero;
    }
   
}
