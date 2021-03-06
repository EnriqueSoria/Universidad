# -*- coding: utf-8 -*-

import random

def generateKnapsack(Nmin,Nmax,Wmin,Wmax):
	'''
		N: Número de elementos
		w: Vector de pesos
		v: Vector de precios
		W: Peso máximo de la mochila.

		return: Una mochila aleatoria
	'''
	N = random.randrange(Nmin,Nmax)
	W = random.randrange(Wmin,Wmax)
	v = [ random.randrange(1, 10000) for i in range(N) ]
	w = [ random.randrange(1, W) for i in range(N) ]
	
	return N,W,v,w


def fractional_knapsack(w, v, W):
	'''
	Algoritmo de la mochila voraz, con fraccionamiento.

	w: Vector de pesos
	v: Vector de precios
	W: Peso máximo de la mochila.

	return: Una lista con el número de elementos de cada tipo.
	'''
	# Inicializa a ceros el vector 0.
	x = [0] * len(w)
	
	# Sacamos el precio unitario.
	v = sorted([(v[i]/float(w[i]), i) for i in xrange(len(w))], reverse=True)

	for (ratio, i) in v:
		# Cogemos todo lo que podamos de este producto
		x[i] = min(1, W/float(w[i]))
		
		# Restamos al tamaño total, lo que hemos ocupado.
		W -= x[i] * w[i]
	return x
	
	
def greedy_knapsack(w, v, W):
	'''
	Algoritmo de la mochila voraz, sin fraccionamiento.
	
	w: Vector de pesos
	v: Vector de precios
	W: Peso máximo de la mochila.
	
	return: El valor total (precio) obtenido.
	'''
	# Inicializamos todo a ceros.
	x = [0] * len(w)
	
	# Ordenamos los productos por precio.
	v = sorted([(v[i]/float(w[i]), i) for i in xrange(len(w))],reverse=True)
	
	# Mientras quepa, ponemos en la mochila.
	for precio, i in v:
		# Si cabe, lo añadimos.
		if W >= w[i]:
			x[i] = 1
			W -= w[i]
	return sum([ x[i]*precio*w[i] for precio, i in v ])
	

def iterative_knapsack_profit(w, v, W):
	'''
	Algoritmo de la mochila dinámico, sin fraccionamiento.
	
	return: El valor óptimo (máximo) de la mochila.
	'''
	V = {}
	for c in xrange(W+1):
		V[0,c] = 0
	for i in xrange(1, len(v)+1):
		V[i,0] = 0
		for c in xrange(1, min(W+1,w[i-1])):
			V[i,c] = V[i-1,c]
		for c in xrange(w[i-1], W+1):
			V[i,c] = max(V[i-1,c], V[i-1,c-w[i-1]] + v[i-1])
	
	return V[len(v), W]


'''
*************************************************
*                   TESTING                     *
*************************************************
'''
def mostrar_soluciones(soluciones):
	'''
	Muestra las soluciones.
	'''
	histograma = 101*[0]
	acumulado = 101*[0]
	total = float(len(soluciones))

	for (exacta,aprox) in soluciones:
		ratio = int(100*aprox/float(exacta))
		histograma[ratio] += 1
	print histograma
	acumulado[100] = histograma[100]
	for i in xrange(99,-1,-1):
		acumulado[i] = histograma[i]+acumulado[i+1]
	i = 0
	while i<100 and acumulado[i+1]==100:
		i+=1
	while i<100:
		print "El %7.2f%% de las soluciones voraces estan a o por encima del %3d%% respecto a la optima" % (100*acumulado[i]/total,i)
		i+=1
		print "El %7.2f%% de las soluciones voraces coinciden con la optima." % (100*acumulado[100]/total)


def test():
	'''
	Genera 10 mochilas y las pone a prueba.
	'''
	print '''Generando soluciones...'''
	soluciones = []
	for i in xrange(10):
		N,W,v,w = generateKnapsack(50,100,1000,5000)
		soloptima = iterative_knapsack_profit(w,v,W)
		solaprox = greedy_knapsack(w,v,W)
		soluciones.append((soloptima,solaprox))
	mostrar_soluciones(soluciones)
	
test()
