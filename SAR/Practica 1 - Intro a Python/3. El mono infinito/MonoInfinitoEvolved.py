# coding=utf-8
import cPickle as pickle
import random
import sys


def load_object ( file_name ):
    with open ( file_name, 'rb' ) as fh:
        obj = pickle.load ( fh )
    return obj

# Carreguem el diccionari
if len ( sys.argv ) == 2:
    nomFitxer = sys.argv [ 2 ]
else:
    nomFitxer = raw_input ( 'Introdueix el nom del fitxer on està el diccionari: ' )

obj = load_object ( nomFitxer )
if type ( obj ) == dict:
    diccionari = obj
else:
    print "No s'ha trobat diccionari. Fi del programa."
    exit ( 0 )

# Generem una frase
MAXIM_NUMERO_PARAULES = 10

paraula_inicial = random.choice ( diccionari [ '$' ] [ 1 ] ) [ 1 ]

anterior = paraula_inicial
sys.stdout.write ( anterior )
for i in xrange ( 1, MAXIM_NUMERO_PARAULES ):
    sys.stdout.write ( ' ' )
    llista = diccionari [ anterior ] [ 1 ]
    anterior = random.choice ( llista ) [ 1 ]

    if anterior == '$':
        break;
    else:
        sys.stdout.write ( anterior )
print '.'
