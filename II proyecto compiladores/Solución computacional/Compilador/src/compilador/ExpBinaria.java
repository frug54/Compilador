/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

/**
 *
 * @author hugo
 */
public class ExpBinaria {
    String expIzq;
    String expDer;
    String operador;

    public ExpBinaria(String expIzq, String expDer, String operador) {
        this.expIzq = expIzq;
        this.expDer = expDer;
        this.operador = operador;
    }
    
    public String getExpIzq() {
        return expIzq;
    }

    public void setExpIzq(String expIzq) {
        this.expIzq = expIzq;
    }

    public String getExpDer() {
        return expDer;
    }

    public void setExpDer(String expDer) {
        this.expDer = expDer;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
    
    
}
