                ##########################################################
                # Segmento de datos
                ##########################################################

                .data 0x10000000
reloj:          .word 0                # HH:MM:SS (3 bytes de menor peso)

cad_asteriscos: .asciiz "\n  **************************************"
cad_horas:      .asciiz "\n   Horas: "
cad_minutos:    .asciiz " Minutos: "
cad_segundos:   .asciiz " Segundos: "
cad_reloj_en_s: .asciiz "\n   Reloj en segundos: "

                ##########################################################
                # Segmento de código
                ##########################################################

                .globl __start
                .text 0x00400000

__start:        la $a0, reloj
				li $a1, 0x82
				li $a2, 0x83
				li $a3, 0x84
				jal inicialitza_rellotge_alt
				
				# Imprimir
				la $a0, reloj
                jal imprime_reloj
				
				# Canviar segons per 12
				la $a0, reloj
                li $a1,0x0000000c
				jal subrutina
				
				# Imprimir
				la $a0, reloj
                jal imprime_reloj
				
				# Rellotge en segons
				la $a0, reloj
				li $a1, 0x0012202D
				jal inicialitza_rellotge
				la $a0, reloj
				jal torna_rellotge_en_s
				move $a0, $v0
				jal imprimeix_s
				
				# Inicialitzar rellotge en segons
				la $a0, reloj
				li $a1, 66765
				jal inicialitza_rellotge_en_s
				la $a0, reloj
				jal imprime_reloj
				
				
				
				
salir:          
				li $v0, 10              # Código de exit (10)
                syscall                 # Última instrucción ejecutada
                .end


                ########################################################## 
                # Subrutina que imprime el valor del reloj
                # Entrada: $a0 con la dirección de la variable reloj
                ########################################################## 

imprime_reloj:  move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                la $a0, cad_horas       # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 2($t0)         # Lee el campo HH
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_minutos     # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 1($t0)         # Lee el campo MM
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_segundos    # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                lbu $a0, 0($t0)         # Lee el campo SS
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra

                ########################################################## 
                # Subrutina que imprime los segundos calculados
                # Entrada: $a0 con los segundos a imprimir
                ########################################################## 

imprimeix_s:      move $t0, $a0
                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall


                la $a0, cad_reloj_en_s  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall

                move $a0, $t0           # Valor entero a imprimir
                li $v0, 1               # Código de print_int
                syscall

                la $a0, cad_asteriscos  # Dirección de la cadena
                li $v0, 4               # Código de print_string
                syscall
                jr $ra
                
                ########################################################## 
				# Torna l'hora en segons
				# "return HH*3600+MM*60+SS"
				########################################################## 
torna_rellotge_en_s:
				lb $t0,2($a0)	#HH
				lb $t1,1($a0)	#MM
				lb $v0,0($a0)	#SS
				
				li $t2,3600		# $t0 = $t0*3600
				mult $t0,$t2	#
				mflo $t0		#
				li $t2,60		# $t1 = $t1*60
				mult $t1,$t2	#
				mflo $t1		#
				
				addu $t0,$t0,$t1	# $v0 += $t0 + $t1
				addu $v0,$v0,$t0	#
				jr $ra
				
				########################################################## 
				# Inicialitza el rellotge a partir d'un hora donada
				# en segons.
				##########################################################
				
				##########################################################
				# Empilar $ra
				# 	addiu $sp, $sp, -4
				# 	sw $ra, 0($sp)
				# Desempilar $ra
				# 	lw $ra, 0($sp)
				# 	addiu $sp, $sp, 4
				###########################################################
				
inicialitza_rellotge_en_s:
				li $t0, 60
				div $a0,$t0
				mflo $t1	# Minuts
				mfhi $a0	# SS
				div $t1,$t0
				mflo $a2	# HH
				mfhi $a1	# MM
				
				addiu $sp, $sp, -4	# Empilar $ra
				sw $ra, 0($sp)		#
				
				la $a0, reloj
				jal inicialitza_rellotge_alt
				
				lw $ra, 0($sp)		# Desempilar $ra
				addiu $sp, $sp, 4	#
				
				jr $ra
				
				
				
				########################################################## 
				# 
				########################################################## 
subrutina: 		lw $t0, 0($a0)
				li $t1, 0x00FFFF00	# Máscara de bits
				and $t0, $t0, $t1	#
				or $t1, $t0, $a1
				sw $t1, 0($a0)
				jr $ra
				
				
				########################################################## 
				# setHores(byte x)
				########################################################## 
inicialitza_rellotge_hh:
				sb $a1,2($a0)
				jr $ra
				
				########################################################## 
				# setMinuts(byte x)
				########################################################## 
inicialitza_rellotge_mm:
				sb $a1,1($a0)
				jr $ra

				########################################################## 
				# setSegons(byte x)
				########################################################## 
inicialitza_rellotge_ss:
				sb $a1,0($a0)
				jr $ra	

				########################################################## 
				# Inicialitza el rellotge pasant HH, MM, SS
				########################################################## 
inicialitza_rellotge_alt:
				sll $a1,$a1,16
				sll $a2,$a2,8
				or $t0,$a0,$a1
				or $t0,$t0,$a2
				or $t0,$t0,$a3
				li $t1,0x1F3F3F
				and $t0,$t0,$t1
				sw $t0,0($a0)
				jr $ra
				
				########################################################## 
				# Inicialitza el rellotge des d'una paraula de 32 bits.
				########################################################## 
inicialitza_rellotge:
				sw $a1,0($a0)
				jr $ra
				
				
				########################################################## 
                # Subrutina que incrementa el reloj en una hora
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: 23:MM:SS -> 00:MM:SS
                ########################################################## 
				
pasa_hora:      lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
H24:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_hora:  jr $ra