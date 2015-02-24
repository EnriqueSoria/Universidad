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
				
				la $a0, reloj
                jal imprime_reloj
				
				
				
				la $a0, reloj
                li $a1,0x0000000c
				jal subrutina
				
				
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

imprime_s:      move $t0, $a0
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
                # Subrutina que incrementa el reloj en una hora
                # Entrada: $a0 con la dirección del reloj
                # Salida: reloj incrementado en memoria
                # Nota: 23:MM:SS -> 00:MM:SS
                ########################################################## 
                
torna_rellotge_en_s:
				lb $t0,2($a0)	#HH
				lb $t1,1($a0)	#MM
				lb $t2,0($a0)	#SS
				
subrutina: 		lw $t0, 0($a0)
				li $t1, 0x00FFFF00
				and $t0, $t0, $t1
				or $t1, $t0, $a1
				sw $t1, 0($a0)
				jr $ra
				
				
				
inicialitza_rellotge_hh:
				sb $a1,2($a0)
				jr $ra
				
inicialitza_rellotge_mm:
				sb $a1,1($a0)
				jr $ra

inicialitza_rellotge_ss:
				sb $a1,0($a0)
				jr $ra	

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
				

				
inicialitza_rellotge:
				sw $a1,0($a0)
				jr $ra
				
				
				
pasa_hora:      lbu $t0, 2($a0)         # $t0 = HH
                addiu $t0, $t0, 1       # $t0 = HH++
                li $t1, 24
                beq $t0, $t1, H24       # Si HH==24 se pone HH a cero
                sb $t0, 2($a0)          # Escribe HH++
                j fin_pasa_hora
H24:            sb $zero, 2($a0)        # Escribe HH a 0
fin_pasa_hora:  jr $ra