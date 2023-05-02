package cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class ListaClientes {
    ArrayList<Cliente> clienteArrayList = new java.util.ArrayList<>();
    public void AgregarCliente(Scanner scanner){
        clienteArrayList.add(ingresarCliente(scanner));
    }
    private Cliente ingresarCliente(Scanner scanner){
        String nombre, apellidos, direccion, telefono,correo;
        System.out.println("- INGRESA LOS DATOS DEL CLIENTE -");
        System.out.println("Ingresa nombre");
        nombre = scanner.nextLine();
        System.out.println("Ingresa apellidos");
        apellidos = scanner.nextLine();
        System.out.println("Ingresa direccion");
        direccion = scanner.nextLine();
        System.out.println("Ingresa telefono");
        telefono = scanner.nextLine();
        System.out.println("ingresa correo");
        correo = scanner.nextLine();
        return new Cliente(nombre,apellidos,direccion,telefono,correo);
    }
    public void mostrarClientes(){
        System.out.println("- CLIENTES REGISTRADOS -\n");
        for (Cliente cliente : clienteArrayList) {
            System.out.println(cliente);
            System.out.println("\n-----------------------------------------------------------------------");
        }
    }
    public Cliente buscarCliente(Scanner scanner){
        System.out.println("ingresa el nombre del cliente");
        String nombre = scanner.nextLine();
        System.out.println("ingresa apellido del cliente");
        String apellido = scanner.nextLine();
        for (Cliente cliente : clienteArrayList) {
            if (cliente.getNombre().equals(nombre) && cliente.getApellidos().equals(apellido)) {
                System.out.println("- Cliente encontrado -");
                return cliente;
            }
        }
        System.out.print("Cliente no encontrado: ");
        return null;
    }
}
