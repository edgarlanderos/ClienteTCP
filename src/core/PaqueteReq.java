package core;

import java.io.Serializable;

public class PaqueteReq implements Serializable {
    private String comando;
    private String elemento;

    public String getComando() {
        return comando;
    }

    public void setComando(String comando) {
        this.comando = comando;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }
}
