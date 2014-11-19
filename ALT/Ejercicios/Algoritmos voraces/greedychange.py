# -*- coding: utf-8 -*-
def show_change(x, v, Q):
	'''
	Muestra la solución de una forma legible.
	'''
	print 'Desglose de la cantidad %d con monedas de valores %s:' % (Q, v)
	print ', '.join('%d moneda%s de valor %d' % (xi, 's' if xi>1 else '', vi) \
					for (xi,vi) in zip(x,v) if xi > 0) + '.'
	q = sum(xi*vi for (xi,vi) in zip(x, v))
	print 'Se proporciona la cantidad %d con %d monedas.' % (q, sum(x))
	if q != Q: 	print 'No se proporciona la cantidad solicitada.'
	else:		print 'Desglose exacto.'

def naive_greedy_change(v, Q):
	'''
	Versión trivial y voraz.
	'''
	x = []
	for vi in v:
		x.append(Q/vi)
		Q = Q % vi
	return x


def greedy_change(v, Q):
	'''
	Ordenamos las monedas por valor decreciente y vamos seleccionando vorazmente.
	'''
	x = []
	for vi in sorted(v, reverse=True):
		x.append(Q/vi)
		Q = Q % vi
	return x
