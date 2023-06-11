package calculos;

import adeudos.AdeudoComida;
import adeudos.AdeudoRenta;
import cliente.Cliente;

import java.util.ArrayList;

public class Calcular {
    public void adeudos(Cliente cliente){
        if(cliente==null){
            System.out.println("nada ingresado");
            return;
        }
        ArrayList<AdeudoComida> adeudoComida = cliente.getAdeudoComida();
        ArrayList<AdeudoRenta> adeudoRenta = cliente.getAdeudoRenta();
        double deudaComida=0,aux;
        double deudarenta=0;
        if(adeudoComida.size()>0 && adeudoComida.get(0)!=null){
            for (int i = 0; i < adeudoComida.size(); i++) {
                if(Integer.parseInt(adeudoComida.get(i).getDescripcion())>15){
                    aux= (10 *  Double.parseDouble(adeudoComida.get(i).getMontoAdeudo()))/100;
                }else aux = Double.parseDouble(adeudoComida.get(i).getMontoAdeudo());
                deudaComida += aux;
            }
            System.out.println("total a pagar de adeudos de comidas:" + deudaComida);
        }else System.out.println("No existen adeudos de comida");
        if(adeudoRenta.size()>0 && adeudoRenta.get(0)!=null){
            if(adeudoRenta.size()==1){
                aux=Double.parseDouble(adeudoRenta.get(0).getMontoAdeudo());
                if(Integer.parseInt( adeudoRenta.get(0).getDescripcion())<15){
                    deudarenta=aux + 5*aux/100;
                }else {
                    deudarenta=aux + 10*aux/100;
                }
            }else{
                System.out.println("asasasa");
                aux=0;
                for (int i = 0; i < adeudoRenta.size(); i++) {
                    aux+= Double.parseDouble(adeudoRenta.get(i).getMontoAdeudo());
                }
                if (adeudoRenta.size()==3){
                    deudarenta = aux + 20*aux/100;
                } else if (adeudoRenta.size()>3) {
                    deudarenta = aux + 40*aux/100;
                }if(adeudoRenta.size()==2){
                    System.out.println("2 adeudos, no especificados en el problema");
                }
            }
            System.out.println("total a pagar de adeudos de rentas:" + deudarenta);
        }else System.out.println("No existen adeudos de rentas");
    }
}
