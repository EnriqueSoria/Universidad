# -*- coding: utf-8 -*-
from greedychange import greedy_change
	
def main():
	'''
	Demostrando si con monedas de valores 30, 24, 12, 6, 3, 1 se consigue la 
	solución óptima
	'''
	MONEDAS = [30, 24, 12, 6, 3, 1]
	# Soluciones buenas calculadas a mano (46..48)
	soluciones_buenas = [ (1, 0, 1, 0, 1, 1), (1, 0, 1, 0, 1, 2), (0, 2, 0, 0, 0, 0) ]
	# Soluciones generadas por el algoritmo  (46..48)
	soluciones_greedy = [ greedy_change(MONEDAS, x) for x in xrange(46, 49) ]

	# Buscamos si se halla algún error
	pares = zip(soluciones_buenas, soluciones_greedy)
	for x, y in pares:
		if sum(x) != sum(y):
			print 'La solución esperada para %d es %s, y se ha devuelto %s' % (pares.index((x, y))+46, x, y)
			value = False
			break
	else:
		value = True
		
	# Decimos si es correcto o no
	print '\n\t El sistema es {0}'.format( 'correcto' if value else 'incorrecto' )

if __name__ == '__main__':
	main()
