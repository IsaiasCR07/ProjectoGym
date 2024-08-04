package ProyectoGym;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        
        // TODO code application logic here
        UsuarioPila m = new UsuarioPila();
        ListaReservaciones reservaciones = new ListaReservaciones();
        int opcion = 0;

        do {
            String input = JOptionPane.showInputDialog("BIENVENIDO A GYM CENTER ! \n Menú de opciones:\n"
                    + "Seleccione una opción:\n"
                    + "1. Registro de Clientes \n"
                    + "2. Reservaciones \n"
                    + "3. Buscar Cliente \n"
                    + "4. Salir \n");
            try {
                opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 1:
                        m.RegistroClientes();
                        break;
                    case 2:
                        int opcionReservacion = 0;
                        do {
                            String inputReservacion = JOptionPane.showInputDialog("Menú de Reservaciones:\n"
                                    + "Seleccione una opción:\n"
                                    + "1. Agregar Reservación \n"
                                    + "2. Modificar Reservación \n"
                                    + "3. Eliminar Reservación \n"
                                    + "4. Mostrar Reservaciones \n"
                                    + "5. Atrás \n");
                            try {
                                opcionReservacion = Integer.parseInt(inputReservacion);
                                switch (opcionReservacion) {
                                    case 1:
                                        // Llamar al método para agregar reservación
                                        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
                                        String fechaReservacion = JOptionPane.showInputDialog("Ingrese la fecha de la reservación:");
                                        String horaReservacion = JOptionPane.showInputDialog("Ingrese la hora de la reservación:");
                                        Reservacion reservacion = new Reservacion(nombre, fechaReservacion, horaReservacion);
                                        reservaciones.agregarReservacion(reservacion);
                                        break;
                                    case 2:
                                        // Llamar al método para modificar reservación
                                        String nombreModificar = JOptionPane.showInputDialog("Ingrese su nombre:");
                                        String fechaReservacionModificar = JOptionPane.showInputDialog("Ingrese la nueva fecha de la reservación:");
                                        String horaReservacionModificar = JOptionPane.showInputDialog("Ingrese la nueva hora de la reservación:");
                                        Reservacion reservacionModificar = new Reservacion(nombreModificar, fechaReservacionModificar, horaReservacionModificar);
                                        reservaciones.modificarReservacion(nombreModificar, reservacionModificar);
                                        break;
                                    case 3:
                                        // Llamar al método para eliminar reservación
                                        String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del cliente a eliminar:");
                                        reservaciones.eliminarReservacion(nombreEliminar);
                                        break;
                                    case 4:
                                        // Llamar al método para mostrar reservaciones
                                        JOptionPane.showMessageDialog(null, reservaciones.imprimirReservaciones());
                                        break;
                                    case 5:
                                        JOptionPane.showMessageDialog(null, "Regresando al menú principal");
                                        break;
                                    default:
                                        JOptionPane.showMessageDialog(null, "La opción no es válida, por favor intente de nuevo");
                                        break;
                                }
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "La opción no es válida, por favor ingrese un número mostrado en el menú");
                            }
                        } while (opcionReservacion != 5);
                        break;
                    case 3:
                        String login = JOptionPane.showInputDialog("Ingrese el número de identificación del cliente:");
                        Usuario usuario = m.buscarCliente(login);
                        if (usuario != null) {
                            JOptionPane.showMessageDialog(null, "Cliente encontrado:\n"
                                    + "Nombre: " + usuario.getNombre() + "\n"
                                    + "Apellidos: " + usuario.getApellido() + "\n"
                                    + "Edad: " + usuario.getEdad() + "\n"
                                    + "Peso: " + usuario.getPeso()+ " kg\n"
                                    + "Edad: " + usuario.getEdad() + "\n"
                                    + "Login: " + usuario.getLogin());
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
                        }
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null, "Saliendo del programa");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La opción no es válida, por favor intente de nuevo");
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "La opción no es válida, por favor ingrese un número mostrado en el menú");
            }
        } while (opcion != 4);
    }
}