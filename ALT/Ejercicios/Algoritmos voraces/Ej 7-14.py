# -*- coding: utf-8 -*-
from fractionalknapsack import generateKnapsack, show_fractional_knapsack


'''
¿Funciona correctamente el algoritmo si puedes poner tanta cantidad
como desees de cualquiera de los productos?
	
RESPUESTA:
	Sí que funciona correctamente.
'''
def inf_fractional_knapsack(w, v, W):
	''' Versión en la que podemos coger tanta cantidad como queramos de cualquier producto '''
	x = [0] * len(w)
	v = sorted([(v[i]/float(w[i]), i) for i in xrange(len(w))], reverse=True)
	for (ratio, i) in v:
		# Cogemos todo lo que podamos de este producto
		x[i] = W/float(w[i])
		W -= x[i] * w[i]
	return x

# Vamos a ver si funciona (Si que funciona correctamente)
N,W,v,w = generateKnapsack(5,10,10,50)
x = inf_fractional_knapsack(w, v, W)
print '¿Funciona correctamente?  ', W <= sum(xx*ww for xx in x for ww in w)


'''
¿Puedes diseñar una versión más eficiente?

RESPUESTA:
	Sí, tan sólo hay que llenar la mochila con el elemento cuyo valor por unidad de peso
	sea más alto.
'''
def infinite_obj_knapsack(w, v, W):
	''' 
	Versión en la que podemos coger tanta cantidad como queramos de cualquier producto.
	Ahora más eficiente.
	'''
	# Inicializamos todas las x[i]
	x = [0] * len(w)
	# Obtenemos el objeto con más valor por unidad de peso
	valor, indice = max([(v[i]/float(w[i]), i) for i in xrange(len(w))], key=lambda (x,y): x)
	# Llenamos toda la mochila con ese objeto
	x[indice] = W/float(w[indice])
	return x

print '¿Funciona correctamente?  ', inf_fractional_knapsack(w,v,W) == infinite_obj_knapsack(w, v, W)
