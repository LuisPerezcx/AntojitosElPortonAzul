package Interfaz;

import cliente.Cliente;

import java.util.Date;

public interface Adeudo {
    public int getIdAdeudo();
    public void setIdAdeudo(int idAdeudo);
    public double getMontoAdeudo();
    public void setMontoAdeudo(double montoAdeudo);
    public String getFechaAdeudo();
    public void setFechaAdeudo(String fechaAdeudo);
    public boolean pagado();
    public void setPagado(boolean pagado);
    public String getTipoAdeudo();
    public int getDiasSinPagar();
    public void setDiasSinPagar(int diasSinPagar);
}
