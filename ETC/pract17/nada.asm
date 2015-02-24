### ESTRUCTURA DE COMPUTADORES (ETSINF)
### abril de 2013
###
### PRÁCTICA 17: INTERRUPCIONES
###
### nada.asm (material de partida para la práctica)

###################################################################
##                  DATOS DEL PROGRAMA USUARIO                   ##
###################################################################
	.data		
var2:	.word 0x77777777

###################################################################
##                  CÓDIGO DEL PROGRAMA USUARIO                  ##
###################################################################
	.text

main:	jr $ra	# Sólo una instrucción

	.end