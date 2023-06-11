package adeudos;

import Interfaz.Adeudo;

public class AdeudoComida implements Adeudo {
    private int idAdeudo;
    private String concepto;
    private String montoAdeudo;
    private String fechaAdeudo;
    private boolean pagado;
    private static String tipoAdeudo = "comida";
    private String descripcion;
    private static int cont = 1;


    public AdeudoComida(String concepto, String montoAdeudo, String fechaAdeudo, boolean pagado, String descripcion) {
        this.idAdeudo = cont;
        cont++;
        this.concepto = concepto;
        this.montoAdeudo = montoAdeudo;
        this.fechaAdeudo = fechaAdeudo;
        this.pagado = pagado;
        this.descripcion = descripcion;
    }
    @Override
    public String toString(){
        return "id Adeudo Comida: " + idAdeudo + " Monto adeudo: " + montoAdeudo + " Fecha Adeudo: " + fechaAdeudo
                + " Pagado: " + pagado + " Dias sin pagar: " + descripcion;

    }
    // Implementación de métodos de la interfaz Adeudo
    public int getIdAdeudo() {
        return idAdeudo;
    }
    public String getMontoAdeudo() {
        return montoAdeudo;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public  String getTipoAdeudo() {
        return tipoAdeudo;
    }
}