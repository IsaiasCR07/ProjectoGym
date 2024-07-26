package ProyectoGym;

import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioPila m = new UsuarioPila();
        int opcion = 0;

        do {
            String input = JOptionPane.showInputDialog("BIENVENIDO A GYM CENTER ! \n Menú de opciones:\n"
                    + "Seleccione una opción:\n"
                    + "1. Registro de Clientes \n"
                    + "2. Mostrar Clientes \n"
                    + "3. Buscar Cliente \n"
                    + "4. Salir \n");
            try {
                opcion = Integer.parseInt(input);
                switch (opcion) {
                    case 1:
                        m.RegistroClientes();
                        break;
                    case 2:
                        m.mostrar();
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
                JOptionPane.showMessageDialog(null, "La option no es válida, por favor ingrese un número mostrado en el menu");
            }
        } while (opcion != 4);
    }

}
