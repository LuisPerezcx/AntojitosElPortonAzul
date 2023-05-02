package MenuMain;

import adeudos.IngresarAdeudo;
import calculos.Calcular;
import cliente.ListaClientes;

import java.util.Scanner;

public class MenuMain {
    ListaClientes listaClientes = new ListaClientes();
    Calcular calcular = new Calcular();
    IngresarAdeudo ingresarAdeudo = new IngresarAdeudo();
    public void menu(Scanner scanner){
        int opc = 0;
        while (opc != 7) {
            showOptions();
            opc = scanner.nextInt();
            scanner.nextLine();
            switch (opc){
                case 1 -> listaClientes.AgregarCliente(scanner);
                case 2 -> listaClientes.mostrarClientes();
                case 3 -> System.out.println(listaClientes.buscarCliente(scanner));
                case 4 -> calcular.adeudos(listaClientes.buscarCliente(scanner));
                case 5 -> ingresarAdeudo.adeudoRenta(listaClientes.buscarCliente(scanner));
                case 6 -> ingresarAdeudo.adeudoComida(listaClientes.buscarCliente(scanner));
                case 7 -> System.out.println("salir");
                default -> System.out.println("Opcion invalida");
            }
        }
    }
    private static void showOptions(){
        System.out.println("""
                +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\s
                Escriba la operación de consulta a realizar:\s
                1.- Registar Cliente \s
                2.- Mostrar Cliente\s
                3.- Buscar Cliente\s
                4.- Calcular Adeudos\s
                5.- Agregar Adeudo Renta\s
                6.- Agregar Adeudo Comida\s
                7.- Salir\s
                """);    }
}
