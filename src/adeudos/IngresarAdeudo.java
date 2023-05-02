package adeudos;

import cliente.Cliente;

import java.util.ArrayList;

public class IngresarAdeudo {
    public void adeudoRenta(Cliente cliente){
        Cliente aux = new Cliente();
        if(cliente==null){
            System.out.println();
        }else{
            ArrayList<AdeudoRenta> adeudoRenta = cliente.getAdeudoRenta();
            adeudoRenta.add(cliente.ingresarAdeudoRenta());
        }
    }
    public void adeudoComida(Cliente cliente){
        Cliente aux = new Cliente();
        if(cliente==null){
            System.out.println();
        }else{
            ArrayList<AdeudoComida> adeudoComidas = cliente.getAdeudoComida();
            adeudoComidas.add(cliente.ingresarAdeudoComida());
        }
    }
}
