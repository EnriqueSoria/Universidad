### PROGRAMA BASE PRACTICAS DE ENTRADA/SALIDA MIPS R2000

#-------------------------------------------------#
#
#  PR�CTICA 15: SINCRONIZACI�N POR PRUEBA DE ESTADO
# 
#-------------------------------------------------#

# EJERCICIO 1:  A�ade la instrucci�n que lee el registro de datos
#               del teclado en el lugar indicado:


#------- Segmento de datos ---------#
	.data		
T1:	.asciiz "Esperando...\n"
T2:	.asciiz "\nFin\n"
T3: .space 4
#------- Segmento de c�digo ---------#
	.text
    	.globl __start	

__start:
	# Escribe en consola mensaje T1
	li $v0, 4
	la $a0, T1
	syscall	
	
	# Carga dir base teclado
	la $t0, 0xffff0000

espera: # Espera bit R == 1
	lw $t1,0($t0)
	andi $t1,$t1,1
	beqz $t1,espera

### A COMPLETAR: lee el registro de datos del teclado
####	
	lb $t2,4($t0)	
	sb $zero,0($t0)
	

	# Escribe en consola mensaje T2
	li $v0, 4
	la $a0, T2
	syscall

	# exit
	li $v0, 10
	syscall			

	.end