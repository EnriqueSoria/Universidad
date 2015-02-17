# Sistemas expertos en JESS

## Primera parte: Animales
Este ejemplo es el mismo que se ha visto en clase de teoría para adivinar de qué animal se trata (pingüino, gaviota, tigre o guepardo). Para  ello  se  tendrán  que  implementar  las  siguientes  reglas  que  permitirán, preguntando  cierta  información al usuario, averiguar si se está pensando en uno de los 4 animales dados: 
 
 * R1: si Animal:Cubre=pelo entonces Animal:Tipo=mamifero. 
 * R2: si Animal:Cubre=plumas y Animal:Reproduce=Oviparo entonces Animal:Tipo=ave. 
 * R3: si Animal:Tipo=mamifero y Animal:Come=carne y Animal:Garras=si entonces Animal:Alimenta=carnivoro. 
 * R4: si Animal:Alimenta=carnivoro y Animal:Color=pardo y Animal:Piel=manchas entonces Animal:Nombre=guepardo. 
 * R5: si Animal:Alimenta=carnivoro y Animal:Color=pardo y Animal:Rayas=negras entonces Animal:Nombre=tigre. 
 * R6: si Animal:Tipo=ave y Animal:Vuela=mal y Animal:Nada=bien Entonces Animal:Nombre=pinguino. 
 * R7: si Animal:Tipo=ave y Animal:Vuela=muy_bien entonces Animal:Nombre=gaviota. 
 * R8: si Animal:Da_leche=si entonces Animal:Tipo=mamifero. 
 * R9: si  Animal:Pico=si y Animal:Reproduce=Oviparo entonces Animal:Tipo=ave. 
 
## Segunda parte: Problemas PC
Dada la siguiente información (que puede ampliarse), diagnosticar el problema en el uso de PCs: 
  
 * Si programa falla Entonces programa erróneo 
 * Si resultados erróneos  Entonces error en el código 
 * Si año de compra >= 2005  Entonces PC nuevo 
 * Si año de compra < 2005  Entonces PC viejo 
 * Si programa lento y PC nuevo  Entonces memoria insuficiente 
 * Si programa lento y PC viejo  Entonces PC obsoleto 
 * Si PC obsoleto  Entonces CONSEJO renovar PC 
 * Si memoria insuficiente  Entonces memoria saturada 
 * Si programa erroneo  Entonces conflictos 
 * Si conflictos o memoria saturada  Entonces windows sobrecargado 
 * Si error en el código  Entonces corregir fuentes 
 * Si windows sobrecargado  Entonces CONSEJO  reiniciar PC 
 * Si corregir fuentes  Entonces CONSEJO Apagar PC 
 
