# -*- coding: utf-8 -*-
from greedychange import greedy_change
	
def main():
	'''
	Demostrando que con monedas de valores 1, 3 y 4 no siempre se consigue la 
	solución óptima
	'''

	# Soluciones buenas calculadas a mano
	soluciones_buenas = [[0, 0, 1], [0, 0, 2], [0, 1, 0], [1, 0, 0], [1, 0, 1], [0, 2, 0]]
	# Soluciones generadas por el algoritmo
	soluciones_greedy = [ greedy_change([1, 3, 4], x) for x in xrange(1, 7) ]

	# Buscamos si se halla algún error
	pares = zip(soluciones_buenas, soluciones_greedy)
	for x, y in pares:
		if sum(x) != sum(y):
			print 'La solución esperada para %d es %s, y se ha devuelto %s' % (pares.index((x, y))+1, x, y)
			value = False
			break
	else:
		value = True
		
	# Decimos si es correcto o no
	print '\n\t El sistema es {0}'.format( 'correcto' if value else 'incorrecto' )

if __name__ == '__main__':
	main()
