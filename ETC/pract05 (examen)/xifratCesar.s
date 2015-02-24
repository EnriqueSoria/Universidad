.data 0x10000000
original: 	.space 80
xifrada:	.space 80

.globl __start
.text 0x00400000

__start:	li $v0,8			# readString()
			la $a0, xifrada		#
			li $a1, 79			#
			syscall				#
			
			li $v0,5			# readInt()
			syscall				#
			move $a2,$v0		#
			
			la $a0, original	# cesarnoseque(a0,a1,a2)
			la $a1, xifrada		#
			jal cesarnoseque	#
			
			li $v0,4			# printString(original)
			la $a0, original	#
			syscall				#
			
			li $v0,10			# exit()
			syscall
			
		cesarnoseque:	li $t1, 32
						li $t2, 0x0A
					buc:lbu $t0, 0($a1)
						beq $t0,$zero,fibucle
						beq $t0,$t1,guard
						beq $t0,$t2,fibucle 
						sub $t0,$t0,$a2
					guard:	sb $t0,0($a0)
							addi $a0,$a0,1
							addi $a1,$a1,1
							j buc
					fibucle:jr $ra