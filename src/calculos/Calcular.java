package calculos;

import adeudos.AdeudoComida;
import adeudos.AdeudoRenta;
import cliente.Cliente;

import java.util.ArrayList;

public class Calcular {
    public void adeudos(Cliente cliente){
        ArrayList<AdeudoComida> adeudoComida = cliente.getAdeudoComida();
        ArrayList<AdeudoRenta> adeudoRenta = cliente.getAdeudoRenta();
        double deudaComida=0,aux;
        double deudarenta=0;
        if(adeudoComida.size()>0 && adeudoComida.get(0)!=null){
            for (int i = 0; i < adeudoComida.size(); i++) {
                if(adeudoComida.get(i).getDiasSinPagar()>15){
                    aux= (10 * adeudoComida.get(i).getMontoAdeudo())/100;
                }else aux = adeudoComida.get(i).getMontoAdeudo();
                deudaComida += aux;
            }
            System.out.println("total a pagar de adeudos de comidas:" + deudaComida);
        }else System.out.println("No existen adeudos de comida");
        if(adeudoRenta.size()>0 && adeudoRenta.get(0)!=null){
            if(adeudoRenta.size()==1){
                aux=adeudoRenta.get(0).getMontoAdeudo();
                if(adeudoRenta.get(0).getDiasSinPagar()<15){
                    deudarenta=aux + 5*aux/100;
                }else {
                    deudarenta=aux + 10*aux/100;
                }
            }else{
                System.out.println("asasasa");
                aux=0;
                for (int i = 0; i < adeudoRenta.size(); i++) {
                    aux+=adeudoRenta.get(i).getMontoAdeudo();
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
