EURO = [0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50, 100, 200, 500]

def adaptToCents(v, Q, func):
	'''Implementa un programa que devuelva el desglose
	   optimo para el sistema monetario europeo al completo,
	   esto es, considerando tambien las monedas fraccionarias
	   de 0.50, 0.20, 0.10,0.05, 0.02 y 0.01 euros).
		
	   Adapta el algoritmo para que trabaje con valores no enteros.
	   
	   FUNCIONAMIENTO:
	   		adaptToCents( v, Q, greedy_change )
	'''
	
	# Al tratarse de centésimas partes, bastaría con multiplicarlo todo por 100
	v = [c*100 for c in v]
	Q = Q*100
	
	# Y una vez calculado, dividir todo entre 100
	return [c/100 for c in func(v, Q)]


    
