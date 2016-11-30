package compilador;
import java_cup.runtime.Symbol;
import java.util.ArrayList;
%%

%public
%unicode
%cup
%line
%full
%char
%column
%ignorecase

%eofval{
  return new Symbol(sym.EOF);
%eofval}


L=[a-zA-Z]
D=[0-9]
Salto = \r|\n|\r\n
Espacio     = {Salto} | [ \t\f]


%{
public ArrayList<String> lexico = new ArrayList<String>();
%}


%%

{Espacio}       { /*Ignorar*/ } 
"/*" {lexico.add(yytext()); return new Symbol(sym.INI_COMMENT, yyline + 1, yycolumn + 1, yytext());}
"*/" {lexico.add(yytext()); return new Symbol(sym.FIN_COMMENT, yyline + 1, yycolumn + 1, yytext());}
"//" {lexico.add(yytext()); return new Symbol(sym.LINE_COMMENT, yyline + 1, yycolumn + 1, yytext());}
"=" {lexico.add(yytext()); return new Symbol(sym.Asig, yyline + 1, yycolumn + 1, yytext());}
";" {lexico.add(yytext()); return new Symbol(sym.punto_coma, yyline + 1, yycolumn + 1, yytext());}
"+" {lexico.add(yytext()); return new Symbol(sym.Suma, yyline + 1, yycolumn + 1, yytext());}
"-" {lexico.add(yytext()); return new Symbol(sym.Resta, yyline + 1, yycolumn + 1, yytext());}
"*" {lexico.add(yytext()); return new Symbol(sym.Multipl, yyline + 1, yycolumn + 1, yytext());}
"!" {lexico.add(yytext()); return new Symbol(sym.ope_neg, yyline + 1, yycolumn + 1, yytext());}
"," {lexico.add(yytext()); return new Symbol(sym.coma, yyline + 1, yycolumn + 1, yytext());}
"/" {lexico.add(yytext()); return new Symbol(sym.Divide, yyline + 1, yycolumn + 1, yytext());}
"&&" {lexico.add(yytext()); return new Symbol(sym.ope_and, yyline + 1, yycolumn + 1, yytext());}
"||" {lexico.add(yytext()); return new Symbol(sym.ope_or, yyline + 1, yycolumn + 1, yytext());}
"==" {lexico.add(yytext()); return new Symbol(sym.ope_comp, yyline + 1, yycolumn + 1, yytext());}
"!=" {lexico.add(yytext()); return new Symbol(sym.ope_diferente, yyline + 1, yycolumn + 1, yytext());}
"<=" {lexico.add(yytext()); return new Symbol(sym.ope_menor_igual, yyline + 1, yycolumn + 1, yytext());}
">=" {lexico.add(yytext()); return new Symbol(sym.ope_mayor_igual, yyline + 1, yycolumn + 1, yytext());}
">" {lexico.add(yytext()); return new Symbol(sym.ope_mayor, yyline + 1, yycolumn + 1, yytext());}
"<" {lexico.add(yytext()); return new Symbol(sym.ope_menor, yyline + 1, yycolumn + 1, yytext());}
"{" {lexico.add(yytext()); return new Symbol(sym.corch_izq, yyline + 1, yycolumn + 1, yytext());}
"}" {lexico.add(yytext()); return new Symbol(sym.corch_derec, yyline + 1, yycolumn + 1, yytext());}
"(" {lexico.add(yytext()); return new Symbol(sym.parent_izq, yyline + 1, yycolumn + 1, yytext());}
")" {lexico.add(yytext()); return new Symbol(sym.parent_derec, yyline + 1, yycolumn + 1, yytext());}
[s][i] {lexico.add(yytext()); return new Symbol(sym.senten_si, yyline + 1, yycolumn + 1, yytext());}
[p][a][r][a] {lexico.add(yytext()); return new Symbol(sym.senten_para, yyline + 1, yycolumn + 1, yytext());}
[m][i][e][n][t][r][a][s] {lexico.add(yytext()); return new Symbol(sym.senten_mientras, yyline + 1, yycolumn + 1, yytext());}
[e][n][l][a][c][e] {lexico.add(yytext()); return new Symbol(sym.let, yyline + 1, yycolumn + 1, yytext());}
[f][n] {lexico.add(yytext()); return new Symbol(sym.senten_fn, yyline + 1, yycolumn + 1, yytext());}
[+-]?{D}+({D}+)?  {lexico.add(yytext()); return new Symbol(sym.Number, yyline + 1, yycolumn + 1, yytext());}
{L}( {L} | {D})* {lexico.add(yytext()); return new Symbol(sym.ID, yyline + 1, yycolumn + 1, yytext());}
. {System.out.println("Error Lexico" + "Linea" + (yyline) + "Columna" + (yycolumn) + "token" + yytext());}
