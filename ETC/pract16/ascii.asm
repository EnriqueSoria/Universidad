.data		
T1:	.asciiz "Esperando...\n"
T2:	.asciiz "\nFin\n"
T3: .space 4
#------- Segmento de código ---------#
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
	lbu $t2,4($t0)	
	sb $zero,0($t0)
	move $a0,$t2
	beq $t2,0x1B,final
	li $v0, 1
	syscall
	li $a0, 32
	li $v0, 11
	syscall
	bne $t2,0x1B, espera
	
	
	
	
	# Escribe en consola mensaje T2
	# Escribe en consola mensaje T2
	final:li $v0, 4
	la $a0, T2
	syscall

	# exit
	li $v0, 10
	syscall			

	.end