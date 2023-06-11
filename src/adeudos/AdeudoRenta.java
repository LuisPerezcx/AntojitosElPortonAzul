package adeudos;

import Interfaz.Adeudo;

public class AdeudoRenta implements Adeudo {
    private int idAdeudo;
    private String concepto;
    private String montoAdeudo;
    private String fechaAdeudo;
    private boolean pagado;
    private static String tipoAdeudo = "renta";
    private String diasSinPagar;
    private static int cont = 1;

    public AdeudoRenta(String concepto, String montoAdeudo, String fechaAdeudo, boolean pagado, String diasSinPagar) {
        this.idAdeudo = cont;
        cont++;
        this.concepto = concepto;
        this.montoAdeudo = montoAdeudo;
        this.pagado=pagado;
        this.fechaAdeudo = fechaAdeudo;
        this.diasSinPagar = diasSinPagar;
    }
    @Override
    public String toString(){
        return "id Adeudo Renta: " + idAdeudo + " Monto adeudo: " + montoAdeudo + " Fecha Adeudo: " + fechaAdeudo
                + " Pagado: " + pagado + " Dias sin pagar: " + diasSinPagar +"\n";

    }
    // Implementación de métodos de la interfaz Adeudo
    public int getIdAdeudo() {
        return idAdeudo;
    }
    public String getMontoAdeudo() {
        return montoAdeudo;
    }
    public String getDescripcion() {
        return diasSinPagar;
    }

    public String getTipoAdeudo() {
        return tipoAdeudo;
    }
}
