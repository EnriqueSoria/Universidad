# coding=utf-8
from nltk.corpus import brown
from nltk.probability import *

paraules = [ 'what', 'when', 'where', 'who', 'why' ]

solucio = [ ]
for p in paraules:
    solucio.append( p )
    lst = [ ]
    for cat in brown.categories( ):
        freq = FreqDist( brown.words( categories=cat ) )
        lst.append( cat )
        lst.append( freq[ p ] )
    solucio.append( lst )

print solucio