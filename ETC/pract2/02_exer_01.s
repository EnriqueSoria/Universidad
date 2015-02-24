          .globl __start
          .data 0x10000000
M:        .space 4			# Asigna espai en memòria a la variable M // int M;
Q:		  .space 4			# Asigna espai en memòria a la variable Q // int Q;
R:		  .space 4			# Asigna espai en memòria a la variable R // int R;
          
          .text 0x00400000
__start:  
	
	# Carrega M
		  li $a0,'M'		# Asigna a $a0 el caràcter 'M' // $a0 = 'M'
          la $a1, M			# Asigna a &a1 l'adreça de la variable M // $a1 = &M
          jal InputV
	# Carrega Q
		  li $a0,'Q'
		  la $a1, Q
		  jal InputV
	# MultV(&M,&Q,&R)
		  la $a0, M
		  la $a1, Q
		  la $a2, R
		  jal MultV
	#PromptV('R',R)
		  li $a0, 'R'
		  add $a1, $zero, $a2
		  jal PromptV
		  
	# Acaba el programa
          li $v0,10			# system.exit()
          syscall

		  
InputV:   li $v0, 11		# Index del print_char()
          syscall
          li $v0, 11		# Index del print_char('=')
          li $a0, '='
          syscall
          li $v0, 5			# Index de read_int()
          syscall
          sw $v0, 0($a1)	# El que hi ha en $v0 ho guarde en la direcció $a1
          jr $ra

		  
MultV:	lw $t0, 0($a0)
		lw $t1, 0($a1)
		bgez $t1, Bot		# if ( $t1>=0 ) goto Bot
		li $t4, -1
		mult $t0, $t4
		mult $t1, $t4

Bot:	li $t2, 0
		beq $t1, 0, MultB
MultA:	add $t2, $t2, $t0
		addi $t1, $t1, -1
		bne $t1, $zero, MultA
MultB:  add $a2, $zero, $t2
		jr $ra
		
		
PromptV:	li $v0, 11		# Index del print_char()
			syscall
			li $v0, 11		# Index del print_char('=')
			li $a0, '='
			syscall
			li $v0, 1	
			add $a0, $zero, $a1
			syscall
			jr $ra
		