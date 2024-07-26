
package ProyectoGym;


public class NodoLS {
    
    private Usuario dato;
    NodoLS siguiente;
    
    public NodoLS (){
        this.siguiente=null;
    }

    public Usuario getDato() {
        return dato;
    }

    public void setDato(Usuario dato) {
        this.dato = dato;
    }

    public NodoLS getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLS siguiente) {
        this.siguiente = siguiente;
    }
    
}
