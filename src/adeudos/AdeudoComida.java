package adeudos;

import Interfaz.Adeudo;
import cliente.Cliente;

import java.util.Date;

public class AdeudoComida implements Adeudo {
    private int idAdeudo;
    private double montoAdeudo;
    private String fechaAdeudo;
    private boolean pagado;
    private static String tipoAdeudo = "comida";
    private int diasSinPagar;


    public AdeudoComida(int idAdeudo,double montoAdeudo, String fechaAdeudo, boolean pagado, int diasSinPagar) {
        this.idAdeudo = idAdeudo;
        this.montoAdeudo = montoAdeudo;
        this.fechaAdeudo = fechaAdeudo;
        this.pagado = pagado;
        this.diasSinPagar = diasSinPagar;
    }
    @Override
    public String toString(){
        return "id Adeudo Comida: " + idAdeudo + " Monto adeudo: " + montoAdeudo + " Fecha Adeudo: " + fechaAdeudo
                + " Pagado: " + pagado + " Dias sin pagar: " + diasSinPagar;

    }
    // Implementación de métodos de la interfaz Adeudo
    public int getIdAdeudo() {
        return idAdeudo;
    }

    public void setIdAdeudo(int idAdeudo) {
        this.idAdeudo = idAdeudo;
    }

    public double getMontoAdeudo() {
        return montoAdeudo;
    }

    public void setMontoAdeudo(double montoAdeudo) {
        this.montoAdeudo = montoAdeudo;
    }

    public String getFechaAdeudo() {
        return fechaAdeudo;
    }

    public void setFechaAdeudo(String fechaAdeudo) {
        this.fechaAdeudo = fechaAdeudo;
    }

    public boolean pagado() {
        return pagado;
    }

    public void setPagado(boolean pagado) {
        this.pagado = pagado;
    }

    public String getTipoAdeudo() {
        return tipoAdeudo;
    }

    public int getDiasSinPagar() {
        return diasSinPagar;
    }

    public void setDiasSinPagar(int diasSinPagar) {
        this.diasSinPagar = diasSinPagar;
    }
}