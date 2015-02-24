          .globl __start
          .text 0x00400000
__start:  
	# Demanem M
		  li $v0,11			# Printchar(x)
		  li $a0,'P'		# x = 'P'
		  syscall
		  li $a0,'='		# x = '='
		  syscall
		  li $v0,5			# Posa l'index per a la crida al sistema
          syscall			# Demana un int al sistema (M)
		  move $a3,$v0		# El valor arreplegat es volca en $a3
		  
	# Demanem Q  
		  li $v0,11			# Printchar(x)
		  li $a0,'Q'		# x = 'Q'
		  syscall
		  li $a0,'='		# x = '='
		  syscall
          li $v0,5			# Posa l'index per a la crida al sistema
          syscall			# Demana un int al sistema (Q)
		  
          move $a1,$v0		# El valor Q es volca en $a1
		  move $a0,$a3		# El valor P es volca en $a0
		  
          jal Mult			# Salt incondicional a la direcció Mult (subrutina de multiplicació)
		  
	# Crida al sistema final
		  move $a3,$v0
		  li $v0,11			# Printchar(x)
		  li $a0,'R'		# x = 'R'
		  syscall
		  li $a0,'='		# x = '='
		  syscall
          move $a0,$a3		# El resultat P el mou a $a0
          li $v0,1			# Posa l'index pera a la crida al sistema (imprimeix)
          syscall			# Fa la crida
          li $v0,10			# Posa l'index per a la crida al sistema (acaba programa)
          syscall			# Fa la crida, acaba el programa
		  
				# Subrutina de multiplicació
Mult:     li $v0, 0					# Buida el registre per a la crida del sistema, per a anar fent la multiplicació
          beqz $a1, MultRet			# Condicional, si $a1 == 0, anar a la direcció MultRet
MultFor:  add $v0, $v0, $a0			# Suma el valor M al que hi ha en el valor de retorn de la funció
          addi $a1, $a1, -1			# Resta 1 unitat al valor Q, que serveix com a contador del bucle
          bne $a1, $zero, MultFor	# Condicional, mentre Q != 0, fa un salt a la direcció MultFor
MultRet:  jr $ra					# Fa un salt a la direcció guardada en $ra (crida al sistema final)
