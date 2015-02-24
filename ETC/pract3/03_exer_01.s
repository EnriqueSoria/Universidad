          .globl __start
          .text 0x00400000
__start:  li $a0, 'A'
          jal Input
          move $s0, $v0

          li $a0, 'B'
          jal Input
		  move $s1, $v0
		  
		  li $a0, 'C'
          jal Input
		  move $s2, $v0
		  
		  li $a0, 'D'
          jal Input
          
          move $a0, $s0
          move $a1, $s1
		  move $a2, $s2
          move $a3, $v0
          jal max4

          move $a1, $v0
          li $a0, 'R'
          jal Prompt
          
          li $v0,10
          syscall
          
max2:     slt $t0, $a0, $a1
          bnez $t0, max_a1
          move $v0, $a0
          jr $ra
max_a1:   move $v0, $a1
          jr $ra

max3:     addiu $sp, $sp, -4
          sw $ra, 0($sp)
          jal max2
          move $a0, $v0
          move $a1, $a2
          jal max2
          lw $ra, 0($sp)
          addiu $sp, $sp, 4
          jr $ra
		  
max4:     addiu $sp, $sp, -4
          sw $ra, 0($sp)
          jal max3
          move $a0, $v0
          move $a1, $a3
          jal max2
          lw $ra, 0($sp)
          addiu $sp, $sp, 4
          jr $ra

          
Input:    li $v0, 11	    # Índex de print_char
          syscall			# Imprimeix $a0
          li $v0, 11	    # Índex de print_char
          li $a0, '='		# Caràcter ‘=’ en $a0
          syscall			# Imprimeix ‘=’
          li $v0, 5         # Índex de read_int
          syscall           # Llegeix un enter
          jr $ra            # Retorn de la funció Input
          
Prompt:   li $v0, 11	    # Índex de print_char
          syscall			# Imprimeix $a0
          li $v0, 11	    # Índex de print_char
          li $a0, '='		# Caràcter ‘=’ en $a0
          syscall			# Imprimeix ‘=’
          li $v0, 1			# Índex de print_int
          move $a0, $a1		# Mou $a1 a $a0
          syscall			# Imprimeix $a1
          li $v0, 11		# Índex print_char
          li $a0, 10		# Caràcter ASCII ‘\n’ en $a0
          syscall			# Imprimeix ‘\n’
          jr $ra			# Retorn de la funció Prompt