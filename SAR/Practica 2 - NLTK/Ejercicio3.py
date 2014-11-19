# coding=utf-8
from nltk.corpus import PlaintextCorpusReader
from nltk.probability import *

print '1. Carregar el fitxer "quijote.txt" en una única cadena unicode'
f = open( 'quijote.txt' )
text = f.read( )

print '2. Mostrar tots els simbols del document ordenats'
lst = list( text.replace( '\n', '' ) )
lst = sorted( set( lst ) )
print '\t', ' '.join( lst )

print '3. Elimina els simbols següents: "!\'{},-.:;?]«»¿"'
simbols = list( '!\'{},-.:;?]«»¿' )
for i in simbols:
    text = text.replace( i, '' )

print '4. Mostrar tots els simbols del document ordenats'
lst = list( text.replace( '\n', '' ) )
lst = sorted( set( lst ) )
print '\t', ' '.join( lst )

print '5. Obtenir el nombre de paraules i el nombre de paraules distintes. Mostra les 10 primeres i les 10 ultimes en ordre alfabètic'
file = open( 'quijote2.txt', 'w+' )
file.write( text )
file.close( )

corpus_root = 'C:\\Users\\nrikee\\PycharmProjects\\NLTK'
corpus = PlaintextCorpusReader( corpus_root, 'quijote2.txt' )
freqs = FreqDist( corpus.words( ) )
words_sorted = sorted ( freqs.keys( ) )
print '\t', len( corpus.words( ) ), len( freqs.keys( ) )
print '\t', ' '.join( words_sorted[:10] )
print '\t', ' '.join( list(reversed( words_sorted ))[:10] )

