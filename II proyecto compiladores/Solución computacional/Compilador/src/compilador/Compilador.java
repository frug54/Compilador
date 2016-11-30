/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.File;

/**
 *
 * @author annia
 */
public class Compilador {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String path="/home/annia/NetBeansProjects/Compilador/src/compilador/scanner.jflex";
        String param[]=new String[5];
        generarLexer(path);
        
        param[0]="-destdir";
        param[1]="/home/annia/NetBeansProjects/Compilador/src/compilador";
        param[2]="-parser";
        param[3]="parser";
        param[4]="/home/annia/NetBeansProjects/Compilador/src/compilador/parser.cup";
        Sintactico(param);
        
    }
    
    public static void generarLexer(String path){
        File file= new File(path);
        jflex.Main.generate(file);
    }
    
    static void Sintactico(String[] param){
        try{
            java_cup.Main.main(param);
        }catch(Exception e){
            System.out.println(e.toString());
        }
    }
    
}
