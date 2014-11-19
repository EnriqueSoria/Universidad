# coding=utf-8
import sys
import re
import cPickle as pickle

# Comproba si s'han passat arguments
#   Ús: python CreadorIndices.py <nomFitxer1> <nomFitxer2>
if len ( sys.argv ) == 3:
    nomFitxerEntrada = sys.argv [ 2 ]
    nomFitxerEixida = sys.argv [ 3 ]
else:
    nomFitxerEntrada = raw_input ( 'Introdueix el nom del fitxer a analitzar: ' )
    nomFitxerEixida = raw_input ( "Introdueix el nom del fitxer d'eixida: " )

# Obrim el fitxer i el llegim
f = open ( nomFitxerEntrada )
text = f.read ( )

# Tokenitzem
def tokenize ( string ):
    string = string.lower ( )
    string = string.replace ( '\n', ' $ $ ' )  # Canviem els canvis de línea per $
    string = re.sub ( '[^\w !$]', ' ', string )  # Eliminem signes de puntuació i els canviem per espais
    string = string.replace ( '  ', ' ' )      # Eliminem doble espaiament
    return string.split ( )


paraules = tokenize ( text )

# Creem el diccionari i l'omplim
diccionari = dict ( )

for n in xrange ( 0, len ( paraules ) - 1 ):
    p = paraules [ n ]
    q = paraules [ n + 1 ]

    # Contem les ocurrències
    if diccionari.has_key ( paraules [ n ] ):
        diccionari [ p ] [ 0 ] += 1
    else:
        diccionari [ p ] = [ 1, [ ] ]

    # Afegim la paraula següent
    lst = diccionari [ p ] [ 1 ]
    if len ( lst ) == 0 and not ( q == '$' and p == q ):
        lst.append ( ( 1, q ) )
    else:
        apareix = False
        for tupla in lst:
            if q in tupla and not ( q == '$' and p == q ):
                aux = ( tupla [ 0 ] + 1, tupla [ 1 ] )
                index = lst.index ( tupla )
                lst [ index ] = aux
                apareix = True
                break
        if not apareix and not ( q == '$' and p == q ):
            lst.append ( ( 1, q ) )
    diccionari [ p ] [ 1 ] = sorted ( lst )

# Guardem al fitxer
def save_object ( object, file_name ):
    with open ( file_name, 'wb' ) as fh:
        pickle.dump ( object, fh, pickle.HIGHEST_PROTOCOL )


save_object ( diccionari, nomFitxerEixida )