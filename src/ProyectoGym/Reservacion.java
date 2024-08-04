package ProyectoGym;

/**
 *
 * @author pchacon
 */
public class Reservacion {
    private String nombre;
    private String fechaReservacion;
    private String horaReservacion;

    public Reservacion(String nombre, String fechaReservacion, String horaReservacion) {
        this.nombre = nombre;
        this.fechaReservacion = fechaReservacion;
        this.horaReservacion = horaReservacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(String fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getHoraReservacion() {
        return horaReservacion;
    }

    public void setHoraReservacion(String horaReservacion) {
        this.horaReservacion = horaReservacion;
    }
    
    
    
    

 
    
 
}
