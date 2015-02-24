### PROGRAMA BASE PRACTICAS DE ENTRADA/SALIDA MIPS R2000

#-------------------------------------------------#
#
#  PRÁCTICA 15: SINCRONIZACIÓN POR PRUEBA DE ESTADO
# 
#-------------------------------------------------#

# EJERCICIO 4:  Completar las funciones:
#    char getchar() - obtiene el carácter del teclado
#    void putchar(char c) - imprime un carácter por la consola

# Segmento de datos

	.data		
#-------------------------------------------------#

# Segmento de código ("text")
	.text
    	.globl __start	



__start:			
	la $s0, 0xffff0000
	la $s1, 0xffff0008
	li $a0, 'P'		# 
	jal putchar		# putchar('P')
	li $a0, '1'		# 
	jal putchar		# putchar('1')
	li $a0, '5'		# 
	jal putchar		# putchar('5')
	li $a0, 13		# carácter de retorno ('\n')
	jal putchar		# putchar('\n')
	
bucle:
	jal getchar		# $v0 = getchar()
	move $a0, $v0		#
	li $t0, 0x1b      	# detecto ESC (0x1b = 27)
	beq $a0, $t0, fin
	jal putchar		# putchar($a0)
	b bucle
fin:	
	li $v0, 10
	syscall			# exit

getchar:			# $v0 = getchar()
	# Espera bit R == 1
	lw $t1,0($s0)
	andi $t1,$t1,1
	beqz $t1,getchar
	
	lbu $t2,4($s0)	
	move $v0,$t2
	jr $ra

putchar:			# putchar($a0)
	lw $t2,0($s1)
	andi $t2,$t2,1
	beqz $t2,putchar
	sb $a0,4($s1)	
	jr $ra