package adeudos;

public class Adeudos {
    private String tipo;
    private String concepto;
    private String montoAdeudo;
    private String fechaAdeudo;
    private String descripcion;
    private boolean pagado;

    public Adeudos(){

    }
    public Adeudos(String tipo, String concepto, String montoAdeudo, String fechaAdeudo, String descripcion, boolean pagado) {
        this.tipo = tipo;
        this.concepto = concepto;
        this.montoAdeudo = montoAdeudo;
        this.fechaAdeudo = fechaAdeudo;
        this.descripcion = descripcion;
        this.pagado = pagado;
    }

    public String getTipo() {
        return tipo;
    }

    public String getConcepto() {
        return concepto;
    }

    public String getMontoAdeudo() {
        return montoAdeudo;
    }

    public String getFechaAdeudo() {
        return fechaAdeudo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
