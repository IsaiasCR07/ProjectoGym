package ProyectoGym;

import javax.swing.JOptionPane;

public class UsuarioPila {

    private NodoLS cima;

    public UsuarioPila() {
        this.cima = null;
    }

    public boolean vacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    public void RegistroClientes() {
        Usuario u = new Usuario();
        u.setNombre(JOptionPane.showInputDialog("Ingrese su nombre: "));
        u.setApellido(JOptionPane.showInputDialog("Ingrese sus apellidos: "));
        u.setEdad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:  ")));
        u.setEstatura(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su estatura (cm) : ")));
        u.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Ingrese su peso actual (kg): ")));
        u.setLogin(JOptionPane.showInputDialog("Registre su numero de cedula (solamente numeros, sin espacios) :"));
        u.setContrasena(JOptionPane.showInputDialog("Registre su contrasena: "));

        NodoLS nuevo = new NodoLS();
        nuevo.setDato(u);
        if (vacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    public void mostrar() {
        //mostrar clientes, lo mostrara como una pila
        if (!vacia()) {
            String s = "";
            NodoLS aux = cima;
            while (aux != null) {
                s += aux.getDato().getLogin() + "\n"
                        + "Nombre:" + aux.getDato().getNombre() + "\n"
                        + "Apellidos:" + aux.getDato().getApellido() + "\n"
                        + "Estado Membresia:" + aux.getDato().getEstadoMembresia() + "\n"
                        + "Edad:" + aux.getDato().getEdad() + "\n"
                        + "Peso:" + aux.getDato().getPeso() + "\n";
                aux = aux.getSiguiente();
            }
            JOptionPane.showMessageDialog(null, "Lista de clientes : \n " + s,
                    " ", JOptionPane.PLAIN_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes registrados",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Usuario buscarCliente(String login) {
        NodoLS actual = cima;
        
        while (actual != null) {
            if (actual.getDato().getLogin().equals(login)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null; 
    }
}

