package ProyectoGym;

import java.util.List;

/**
 *
 * @author pchacon
 */
public class ListaReservaciones {

    private NodoLDE inicio;
    private NodoLDE fin;

    private List<Reservacion> reservaciones;

    public ListaReservaciones() {
        this.inicio = null;
        this.fin = null;
    }

    public void agregarReservacion(Reservacion reservacion) {
        NodoLDE nodo = new NodoLDE(reservacion);
        if (inicio == null) {
            inicio = nodo;
            fin = nodo;
        } else {
            fin.setSiguiente(nodo);
            nodo.setAnterior(fin);
            fin = nodo;
        }
    }

    public void eliminarReservacion(String nombre) {
        NodoLDE actual = inicio;
        while (actual != null) {
            if (actual.getReservacion().getNombre().equals(nombre)) {
                if (actual.getAnterior() != null) {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                } else {
                    inicio = actual.getSiguiente();
                }
                if (actual.getSiguiente() != null) {
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                } else {
                    fin = actual.getAnterior();
                }
                return;
            }
            actual = actual.getSiguiente();
        }
        // Si no se encuentra la reservación, puedes agregar un mensaje de error
        System.out.println("Reservación no encontrada");
    }

    public void modificarReservacion(String nombre, Reservacion nuevareservacion) {
        NodoLDE actual = inicio;
        NodoLDE actual2 = fin;
        while (actual != null && actual2 != null) {
            if (actual.getReservacion().getNombre().equals(nombre)) {
                actual.setReservacion(nuevareservacion);
                return;
            }
            if (actual2.getReservacion().getNombre().equals(nombre)) {
                actual2.setReservacion(nuevareservacion);
                return;
            }
            if (actual == actual2) {
                break;
            }
            actual = actual.getSiguiente();
            actual2 = actual2.getAnterior();
        }
        // Si no se encuentra la reservación, puedes agregar un mensaje de error
        System.out.println("Reservación no encontrada");
    }

    public String imprimirReservaciones() {
        String reservaciones = "";

        // Imprimir de inicio a fin
        reservaciones += "Imprimiendo de inicio a fin:\n";
        NodoLDE actual = inicio;
        while (actual != null) {
            reservaciones += "Nombre Cliente: " + actual.getReservacion().getNombre() + "\n";
            reservaciones += "Fecha Reservacion: " + actual.getReservacion().getFechaReservacion() + "\n";
            reservaciones += "Hora Reservacion: " + actual.getReservacion().getHoraReservacion() + "\n\n";
            actual = actual.getSiguiente();
        }

        // Imprimir de fin a inicio
        reservaciones += "Imprimiendo de fin a inicio:\n";
        actual = fin;
        while (actual != null) {
            reservaciones += "Nombre Cliente: " + actual.getReservacion().getNombre() + "\n";
            reservaciones += "Fecha Reservacion: " + actual.getReservacion().getFechaReservacion() + "\n";
            reservaciones += "Hora Reservacion: " + actual.getReservacion().getHoraReservacion() + "\n\n";
            actual = actual.getAnterior();
        }

        return reservaciones;
    }

}
