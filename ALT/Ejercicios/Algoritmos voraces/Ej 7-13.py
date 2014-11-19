# -*- coding: utf-8 -*-

from fractionalknapsack import generateKnapsack, fractional_knapsack, show_fractional_knapsack

def not_so_fractional_knapsack(w, v, W):
	'''
	Mochila con fraccionamiento voraz. Ahora no podemos fraccionarlo
	'''
	x = [0] * len(w)
	v = sorted([(v[i]/float(w[i]), i) for i in xrange(len(w))],	reverse=True)
	
	for (ratio, i) in v:
		x[i] = 1 if W/float(w[i]) >= 1 else 0
		W -= x[i]
	return x
	
def main():
	'''
	¿Funciona correctamente el algoritmo si no podemos fraccionar los objetos, es decir, si sólo podemos incluir o no incluir completamente cada objeto?

	RESPUESTA:
			No, salen resultados erróneos.
	'''
	N,W,v,w = generateKnapsack(5,10,10,50)
	print 'Número de elements', N
	print 'Peso total', W
	
	
	print 'Versión normal:'
	x = fractional_knapsack(w, v, W)
	show_fractional_knapsack(x, v, w)
	
	print ''
	print ''
	
	print 'Versión sin fraccionamiento:'
	x = not_so_fractional_knapsack(w, v, W)
	show_fractional_knapsack(x, v, w)
	
	
	
if __name__=='__main__':
	main()
