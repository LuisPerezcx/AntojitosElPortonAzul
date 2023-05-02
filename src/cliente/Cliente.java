package cliente;

import adeudos.AdeudoComida;
import adeudos.AdeudoRenta;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    final Scanner scanner = new Scanner(System.in);
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String correo;
    ArrayList<AdeudoRenta> adeudoRenta = new java.util.ArrayList<>();
    ArrayList<AdeudoComida> adeudoComida = new java.util.ArrayList<>();
    private static int cont=1;
    public Cliente (){

    }
    public Cliente(String nombre, String apellidos, String direccion, String telefono, String correo) {
        this.idCliente = cont;
        cont++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.adeudoRenta.add(ingresarAdeudoRenta());
        this.adeudoComida.add(ingresarAdeudoComida());
    }
    @Override
    public String toString(){
        return "id cliente: " + idCliente + " nombre: " + nombre + " apellidos: " + apellidos + " direccion: "
                + direccion +" telefono: " + telefono + " correo: " + correo + "\n- ADEUDO RENTA -\n" + adeudoRenta
                + "\n- ADEUDO COMIDA -\n" + adeudoComida;
    }
    public AdeudoRenta ingresarAdeudoRenta(){
        double adeudo;
        String fecha;
        int dias,id;
        System.out.println("- INGRESAR ADEUDO RENTA -");
        System.out.println("Ingresa monto del Adeudo");
        adeudo = scanner.nextDouble();
        scanner.nextLine();
        if (adeudo == 0){
            return null;
        }else{
            System.out.println("Ingresa fecha del adeudo(dd-mm-yyyy): ");
            fecha = scanner.nextLine();
            System.out.println("ingresa los dias sin pagar: ");
            dias = scanner.nextInt();
            scanner.nextLine();
            if(adeudoRenta.size() == 0 || adeudoRenta.get(0)==null){
                id = 0;
            }else{
                System.out.println(adeudoRenta.size());
                id = adeudoRenta.get(adeudoRenta.size()-1).getIdAdeudo();
            }
            return new AdeudoRenta(id+1,adeudo,fecha,false,dias);
        }
    }
    public AdeudoComida ingresarAdeudoComida(){
        double adeudo;
        String fecha;
        int dias,id;
        System.out.println("- INGRESAR ADEUDO COMIDA -");
        System.out.println("Ingresa monto del Adeudo");
        adeudo = scanner.nextDouble();
        scanner.nextLine();
        if (adeudo == 0){
            return null;
        }else{
            System.out.println("Ingresa fecha del adeudo(dd-mm-yyyy): ");
            fecha = scanner.nextLine();
            System.out.println("ingresa los dias sin pagar: ");
            dias = scanner.nextInt();
            scanner.nextLine();
            if(adeudoComida.size()==0 | adeudoRenta.get(0)==null){
                id = 0;
            }else{
                id = adeudoComida.get(adeudoComida.size()-1).getIdAdeudo();
            }
            return new AdeudoComida(id+1,adeudo,fecha,false,dias);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public ArrayList<AdeudoRenta> getAdeudoRenta() {
        return adeudoRenta;
    }

    public ArrayList<AdeudoComida> getAdeudoComida() {
        return adeudoComida;
    }
}
