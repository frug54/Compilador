MOV  AX,b 
MOV  BX,0 
CMP AX, BX 
JG MAYOR: 
:Codigo Else:
JMP DESPUES 
MAYOR: 
:Codigo del si: 
DESPUES :
:Codigo de Salida:
MOV  AX,a 
MOV  BX,b 
CMP AX, BX 
JG DESPUES
CUMPLE: 
Codigo del Mientras
CMP AX, BX 
JG CUMPLE
DESPUES :
Codigo de Salida
MOV  AX,a 
MOV  BX,1 
CMP AX, BX 
JG DESPUES
CUMPLE: 
Codigo del Mientras
CMP AX, BX 
JG CUMPLE
DESPUES :
Codigo de Salida
MOV  AX,a 
MOV  BX,20 
CMP AX, BX 
JL DESPUES
CUMPLE: 
INC AX  
Codigo del Para
CMP AX, BX 
JL CUMPLE
DESPUES :
Codigo de Salida
/////////////////////////
MOV  AX,b 
MOV  BX,0 
CMP AX, BX 
JG MAYOR: 
:Codigo Else:
JMP DESPUES 
MAYOR: 
:Codigo del si: 
DESPUES :
:Codigo de Salida:
