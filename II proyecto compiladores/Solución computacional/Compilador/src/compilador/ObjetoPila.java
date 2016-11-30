/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

/**
     *
 * @author jody
 */
public class ObjetoPila {
    public String dato1;
    public String dato2;
    public String origen;
    public String tipo;
    public int valor;
    public String macro;
    public ObjetoPila(String dato1, String dato2, String tipo, int valor, String macro)
    {
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.tipo = tipo;
        this.valor = valor;
        this.macro = macro;
    }
    public ObjetoPila(){
    }
    
    public void PrintPile()
    {
        System.out.println("Dato 1: "+dato1+" Dato 2: "+dato2+" Tipo: "+tipo+ " Macro: "+macro+" Valor: "+valor);

    }
    public String GetVal()
    {
        if(tipo.equals("int"))
        {
            return valor+"";
        }
        else{
            return dato1;
        }
    }
    
}
