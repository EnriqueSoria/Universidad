# Algoritmosgenéticos

##Invitados
de boda

> _En la inteligencia artificial, la programación
> genética es una metodología basada en los algoritmos evolutivos e
> inspirada en la evolución biológica para desarrollar
> automáticamente programas de computadoras que realicen una tarea
> definida por el usuario. Es una especialización de los algoritmos
> genéticos onde cada individuo es un programa de computadora. Es una
> técnica de aprendizaje automático utilizada para optimizar una
> población de programas de acuerdo a una función de ajuste o aptitud
> que evalúa la capacidad de cada programa para llevar a cabo la tarea
> en cuestión. _
> Definición de la Wikipedia

### Enunciado

> _Diseñar un algoritmo que reparta los asientos de N
> invitados de una boda según sus preferencias. Es decir, cada
> invitado dará una lista de K personas al lado de las que querría
> estar sentado y otra lista con las (N-K-1) personas que no quiere que
> se sienten a su lado. Hay que __<span style="text-decoration: none">conseguir</span>__
> que se cumpla la mayoría de las preferencias de los invitados._

### Diseño del
algoritmo

### Generación de la población aleatoria

Una población es un conjunto de soluciones válidas. Teniendo en
cuenta que una solución válida, para este problema, es una lista de
K números comprendidos entre 0 y K-1, tal que no se repita ninguno y
que, obviamente, aparezcan todos ellos; siendo K el número de
individuos.

Por tanto, para generar una solución aleatoria tan sólo tenemos
que crear una lista de esos números ordenados de forma aleatoria. 

    def solucion(K): 
	    import random 
	    a = range(K) 		# Crea una lista con los números [0..K-1]
	    random.shuffle(a) 	# Desordena la lista a
	    return a

### Evaluación de la aptitud (fitness)

Para evaluar la aptitud de una solución, optaremos por representar cada individuo con un valor:
Diremos que un individuo con id1 i está al lado de otro id2 si `|id1 - id2| = 1`
    
    def fitness(self, sol): 
        ''' Calcula el fitness de una solucion ''' 
        fit = 0 
        for idn in xrange(len(sol)): 
                fit += 1 if sol[ min( idn+1, len(sol)-1)] in self.individuos[idn][1] else 0 
                fit += 1 if sol[ max( idn-1, 0 )] in self.individuos[idn][1] else 0 
        return fit

## Selección
La selección se realiza mediante selección por torneo, es decir, se crean grupos de soluciones y se seleccionan los mejores de cada grupo, de modo que se obtiene diversidad mientras se escojan los mejores de cada sección.

    N = 5
    solutions = sorted( self.poblacion, key=lambda(x): self.fitness(x) ) 
    selected = solutions[::N]

### Cruce
El cruce se efectúa con dos padres, generando un único hijo, de
forma que toma la primera mitad del primer padre y la segunda mitad
del segundo padre. Debido a cómo está implementado este problema,
generando hijos de ese modo puede producir una solución invalida. En
ese caso, la arreglamos para que sea una válida.

    def combine(self, father, mother): 
        ''' Combina un padre y una madre para crear un hijo ''' 
        son = father[:self.K/2] + mother[self.K/2:] 
        if not self.comprobarSolucion(son): 
                repeated = set(father[:self.K/2]).intersection(mother[(self.K/2)+1:]) 
                notTaken = set(father)-set(son) 
                for r, n in zip(repeated, notTaken): 
                        son[son.index(r)] = n 
        return son

## Mutación
Cada individuo tiene una probabilidad de mutar en cada nueva
generación. En este caso se ha elegido como mutación una
permutación aleatoria de varios elementos, en concreto 3. De este
modo no se pueden producir soluciones erróneas.

    def mutate(self, sol): 
        ''' Muta una solucion, permutando varios valores ''' 
        import random 
        for i in xrange(3): 
            a = random.randrange(self.K) 
            b = random.randrange(self.K) 
            sol[a], sol[b] = sol[b], sol[a] 
        return sol

## Reemplazo
Para el reemplazo se ha elegido un reemplazo generacional, es
decir, cada individuo sólo sobrevive una única generación.

    self.soluciones = new_solutions

# Diseño de los
componentes

## **Individuo**

Un **individuo** se representa mediante una lista 'M', y por unindicador _implícito_ 'id' donde:

Por ejemplo, si tenemos una lista de
individuos _M_, y queremos ver el individuo _i_, haríamos
en Python:
    >>> print M[i] 
    [3, 5, 1]

Que significa que el individuo _id_ quiere sentarse con los individuos de _id_ 3, _id_ 5 y _id_1.

### **Población**
Una población se representa mediante una lista de K ids de los individuos, ordenados de forma que un individuo en la posición i tiene a su lado a los individuos de las posiciones i+1 e i-1. La posición que ocupan en esa lista, es su id.

### Ejemplos de individuos
Para una solución de 5 individuos, unos posibles individuos serían:
    [[2, 3], [4, 3], [0], [0, 1], [2,3,4]]
Para una población de 3 soluciones, con cada una 5 individuos:
    [[2, 4, 3, 0, 1], [4, 0, 2, 3, 1], [4, 0, 2, 3, 1]]

### Traza de un ciclo generacional

#### Poblacion inicial
>>> poblacionInicial()
[[0, 1, 4, 2, 3], [1, 3, 4, 0, 2], [3, 0, 4, 2, 1]]

#### Fitness
>>> calcularFitness()
[5, 6, 5]

#### Seleccion
>>> seleccionar()
[[0, 1, 4, 2, 3], [1, 3, 4, 0, 2]]

#### Cruce
>>> cruzar()
Padres [0, 1, 4, 2, 3] [1, 3, 4, 0, 2] 
Hijo [3, 1, 4, 0, 2] 
Padres [1, 3, 4, 0, 2] [0, 1, 4, 2, 3] 
Hijo [1, 0, 4, 2, 3]

#### Reemplazo
>>> reemplazar()
[[3, 1, 4, 0, 2], [1, 0, 4, 2, 3]]
