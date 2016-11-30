/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java_cup.runtime.Symbol;

/**
 *
 * @author annia
 */
public class Generador {
    
    ArrayList<Objeto> tabla_Simbolo;
    
    
    public static void main(String[] args) throws IOException{
        try {
            FileReader entrada=new FileReader("/home/annia/NetBeansProjects/Compilador/src/compilador/texto.txt");
            Yylex lexer = new Yylex(entrada);
            Generador gen = new Generador();
            parser p= new parser(lexer);
            p.parse();
         //   p.imprimirtokens();
           
            
            int opcion = gen.pedirdatos();
            if (opcion == 1){
                boolean verificar = gen.crearcodigoasm(lexer);
                if (verificar){
                 p.ejecutar(); /*Guarda codigo ensamblasor*/
                }
                else { 
                    System.out.println("No se puede generar codigo ensamblador. "
                            + "Su porgrama debe contar con las siguientes instrucciones: mientras - si - para");
                    
                }
            } 
            
            if (opcion == 2){
               gen.Lista_token(lexer);
            }

            if (opcion == 3 ){
//                gen.tabla_simbolo(p);
               // gen.imprimirtabla(p);
                 p.imprimirtabla();
            }
            } catch (Exception e) {
            System.out.print(e + "Error");
        }
    }
    
    public void Lista_token(Yylex lexico){
        for(int ind= 0; ind< lexico.lexico.size(); ind ++){
            System.out.println("Token: " + lexico.lexico.get(ind));
        }
    }    
        
    public int pedirdatos(){
        int entrada;
        Scanner opcion = new Scanner(System.in);
        System.out.println("Escoger opcion");
        System.out.println("Opcion 1: Crear archivo .asm");
        System.out.println("Opcion 2: Lista de tokens");
        System.out.println("Opcion 3: Tabla de simbolos");
        entrada = opcion.nextInt();   
    return entrada;
}   
    
    
   public boolean crearcodigoasm(Yylex tokens){
       for(int ind=0; ind<tokens.lexico.size();ind ++){
           if((tokens.lexico.get(ind).equals("mientras")) || (tokens.lexico.get(ind).equals("si")) 
                   || (tokens.lexico.get(ind).equals("para")) ){
               return true;
           }   
       } 
    return false;
} 
   
 /* 
   public void tabla_simbolo(parser p){
       tabla_Simbolo = new ArrayList<>();
        Objeto obj;
        
     for(int ind=0; ind < p.listaObj.size(); ind ++){
         Objeto temp = p.listaObj.get(ind);
        // p.listaObj.remove(ind);
         System.out.println("Soy temp 1: " + temp.getNombre());
         int valor=Integer.parseInt(p.listaObj.get(ind).getValor());  
         for(int j=0; j < p.listaObj.size(); j ++){
             Objeto temp2 = p.listaObj.get(j);
             System.out.println("Soy temp 2: " + temp2.getNombre());
             if (temp.getNombre().equalsIgnoreCase(temp2.getNombre())){
                 System.out.println("Nombre Variable: " + temp.getNombre());
                // p.listaObj.remove(j);
               
                 System.out.println("----------------------------");

             }   
         }
         
    }
     
     
     
} 
*/
   
public void imprimirtabla(parser p){
     for(int ind=0; ind < p.listaObj.size(); ind ++){
        Objeto temp = p.listaObj.get(ind);
        System.out.println("Nombre Variable: " + temp.getNombre());
        System.out.println("Valor de la variable: " + temp.getValor());
        System.out.println("tipo de la variable: " + temp.getTipo());
        System.out.println();
    }
}
   
   
   }



           
    



