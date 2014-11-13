def show_fractional_knapsackInf(x, v, w):
	'''
	Imprime el valor de la mochila.
	'''

	print 'Valor total: %s.' % sum(x[i]*v[i] for i in xrange(len(x))),
	print 'Carga total: %s.' % sum(x[i]*w[i] for i in xrange(len(x)))
	print 'Detalle de la carga: %s.' % ', '.join('%.1f%% del producto %d' % (100*x[i], i) for i in xrange(len(x)) if x[i] > 0) 


def fractional_knapsackInf(w, v, W):
	'''
	Algoritmo mochila fraccionamiento con infinitos objetos de cada clase.

	w: Vector de pesos
	v: Vector de precios
	W: Peso máximo de la mochila.
	
	return: El valor total (precio) obtenido.
	'''
	x = [0] * len(w)
	v = sorted([(v[i]/float(w[i]), i) for i in xrange(len(w))], reverse=True)

	#solo se miraria el primer elemento, que es el mas caro, 
	# y cogeriamos de ese hasta llenar la mochila
	while (W>0) :
		x[i] = min(1,W/float(w[i]))
		W -= x[i] * w[i]
		return x


def read_data(txt_file):
	'''
	Lee los datos del fichero.
	'''
	kgTog = 1000.0
	dolaresToEuros = 0.74
	librasToEuros = 1.19
	
	# Read text
	f = open(txt_file, 'r')
	lines = f.readlines()

	# Rest
	w = []
	v = []
	for l in lines[1:-1]:
		l = l.lower().split(' ')[-6:]
		peso, precio = float(l[1]), float(l[4])
		peso = peso * kgTog if 'kg' in l else peso
		if not 'euros' in l:
			precio = precio * dolaresToEuros if 'dolares' in l else precio * librasToEuros

		w.append(peso)
		v.append(precio)

	# Last line
	W = [f for f in lines[0] if f.isdigit()][0]

	return w, v, int(W)	


'''
TESTING
'''
w, v, W = read_data(raw_input('Introduce el nombre del fichero: '))
q = fractional_knapsackInf(w, v, W)
show_fractional_knapsackInf(q, v, w)


