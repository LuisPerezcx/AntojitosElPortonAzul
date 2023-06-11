package cliente;

import adeudos.Adeudos;
import adeudos.AdeudoComida;
import adeudos.AdeudoRenta;
import validaciones.Validar;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    final Scanner scanner = new Scanner(System.in);
    private int idCliente;
    private String nombre;
    private String apellidos;
    private String apellidos2;
    private String direccion;
    private String telefono;
    private String correo;
    ArrayList<AdeudoRenta> adeudoRenta = new java.util.ArrayList<>();
    ArrayList<AdeudoComida> adeudoComida = new java.util.ArrayList<>();
    private Adeudos adeudos;
    Validar validar = new Validar();
    private static int cont=1;
    public Cliente (){

    }
    public Cliente(String nombre, String apellidos,String apellidos2, String direccion, String telefono, String correo) {
        this.idCliente = cont;
        cont++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.apellidos2 = apellidos2;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
    }
    public void ingresarAdeudos(){
        this.adeudoRenta.add(ingresarAdeudoRenta());
        this.adeudoComida.add(ingresarAdeudoComida());
    }
    @Override
    public String toString(){
        return "id cliente: " + idCliente + " nombre: " + nombre + " apellidos: " + apellidos +" " + apellidos2 + " Direccion:[ "
                + direccion +"] telefono: " + telefono + " correo: " + correo + "\n- ADEUDO RENTA -\n" + adeudoRenta
                + "\n- ADEUDO COMIDA -\n" + adeudoComida;
    }
    public AdeudoRenta ingresarAdeudoRenta(){
        double adeudo;
        String fecha;
        int dias,id;
        System.out.println("- INGRESAR ADEUDO RENTA -");
        System.out.println("Ingresa monto del Adeudo");
        adeudo = validar.validarDouble(scanner);
        if (adeudo == 0){
            return null;
        }else{
            System.out.println("Ingresa fecha del adeudo(dd-mm-yyyy): ");
            fecha = validar.validarFecha(scanner);
            System.out.println("ingresa los dias sin pagar: ");
            dias = validar.validarnum(scanner);
            if(adeudoRenta.size() == 0 || adeudoRenta.get(0)==null){
                id = 0;
            }else{
                System.out.println(adeudoRenta.size());
                id = adeudoRenta.get(adeudoRenta.size()-1).getIdAdeudo();
            }
            return new AdeudoRenta("","",fecha,false,"");
        }
    }
    public AdeudoComida ingresarAdeudoComida(){
        double adeudo;
        String fecha;
        int dias,id;
        System.out.println("- INGRESAR ADEUDO COMIDA -");
        System.out.println("Ingresa monto del Adeudo");
        adeudo = validar.validarDouble(scanner);
        scanner.nextLine();
        if (adeudo == 0){
            return null;
        }else{
            System.out.println("Ingresa fecha del adeudo(dd-mm-yyyy): ");
            fecha = validar.validarFecha(scanner);
            System.out.println("ingresa los dias sin pagar: ");
            dias = validar.validarnum(scanner);
            if(adeudoComida.size()==0 | adeudoRenta.get(0)==null){
                id = 0;
            }else{
                id = adeudoComida.get(adeudoComida.size()-1).getIdAdeudo();
            }
            return new AdeudoComida("","adeudo",fecha,false,"dias");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }


    public String getApellidos2() {
        return apellidos2;
    }

    public ArrayList<AdeudoRenta> getAdeudoRenta() {
        return adeudoRenta;
    }

    public ArrayList<AdeudoComida> getAdeudoComida() {
        return adeudoComida;
    }

    public Adeudos getAdeudo() {
        return adeudos;
    }

    public void setAdeudos(Adeudos adeudos) {
        this.adeudos = adeudos;
    }
}
