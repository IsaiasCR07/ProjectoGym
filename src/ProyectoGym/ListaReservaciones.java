package ProyectoGym;

/**
 *
 * @author pchacon
 */
public class ListaReservaciones {

    private NodoLDE inicio;
    private NodoLDE fin;
    private int tamaño;

    public ListaReservaciones() {
        this.inicio = null;
        this.fin = null;
        this.tamaño = 0;
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

    public static boolean validarFecha(String fecha) {
        String[] partes = fecha.split("/");
        int año = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int dia = Integer.parseInt(partes[2]);

        if (año != 2024 || mes != 8) {
            return false;
        }

        int diaActual = getDiaActual();
        int limite = diaActual + 7;

        if (dia < diaActual || dia > limite) {
            return false;
        }

        return true;
    }

    public static boolean validarHora(String hora) {
        String[] partes = hora.split(" ");
        String horaNumerica = partes[0];
        String ampm = partes[1];

        if (!(ampm.equalsIgnoreCase("am") || ampm.equalsIgnoreCase("pm"))) {
            return false;
        }

        String[] horaMinuto = horaNumerica.split(":");
        int horaInt = Integer.parseInt(horaMinuto[0]);
        int minutoInt = Integer.parseInt(horaMinuto[1]);

        if (ampm.equalsIgnoreCase("am")) {
            if (horaInt < 5 || horaInt > 11) {
                return false;
            }
        } else {
            if (horaInt < 12 || horaInt > 9) {
                return false;
            }
        }

        if (minutoInt < 0 || minutoInt > 59) {
            return false;
        }

        return true;
    }

    private static int getDiaActual() {
        // Implementar lógica para obtener el día actual
        // Por ejemplo, utilizando la clase Date
        return 1; // Devuelve el día actual
    }
}
