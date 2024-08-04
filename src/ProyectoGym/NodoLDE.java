
package ProyectoGym;

/**
 *
 * @author pchacon
 */
public class NodoLDE {

    private Reservacion reservacion;
    private NodoLDE anterior;
    private NodoLDE siguiente;

    public NodoLDE(Reservacion reservacion) {
        this.reservacion = reservacion;
        this.anterior = null;
        this.siguiente = null;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public NodoLDE getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoLDE anterior) {
        this.anterior = anterior;
    }

    public NodoLDE getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLDE siguiente) {
        this.siguiente = siguiente;
    }
}