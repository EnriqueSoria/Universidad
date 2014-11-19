# coding=utf-8
from nltk.corpus import PlaintextCorpusReader
from nltk.probability import *
from nltk.corpus import cess_esp


print '1. Accedir al corpus en castellà cess_esp'
corpus = cess_esp
print '\t... fet.'

print '2. Mostrar el nombre de paraules que conté aquest corpus'
nombreParaules = len( corpus.words( ) )
print '\t', nombreParaules

print '3. Mostrar el nombre de frases que conté'
nombreFrases = len( corpus.sents( ) )
print '\t', nombreFrases

print '4. Obtenir les freqüències d\'aparicions dels items que componen el primer fitxer del corpus anterior'
fitxer = corpus.words( corpus.fileids( )[ 0 ] )
freqs = FreqDist( fitxer )
print '\t', freqs.items( )[ :20 ]

print '5. Obtenir el vocabulari del primer fitxer del corpus'
vocabulari = freqs.keys( )
print '\t', vocabulari

print '6. Obtindre de forma ordenada les parales del vocabulari de longitud major que 7 i que apareixen més de dos voltes al corpus'
ex_6 = [ o for o in freqs.keys( ) if (len( o ) > 7 and freqs[ o ] > 2) ]
print '\t', sorted( ex_6 )

print '7. Obtenir la freqüència d\'aparició de les paraules en el primer fitxer del corpus. Obtindre la freqüència de la paraula \'a\''
ex_7 = freqs.values( )
ex_72 = freqs[ 'a' ]
print '\t', ex_7, '\n\tFreq. aparició \'a\':', ex_72

print '8. Obtenir el nombre de paraules que solament apareixen una volta al primer fitxer del corpus'
ex_8 = len( [ 1 for p in freqs.keys( ) if freqs[ p ] == 1 ] )
print '\t', ex_8

print '9. Obtenir la paraula més freqüent del primer fitxer del corpus'
ex_9 = freqs.max( )
print '\t', ex_9

print '10. Carrega els fitxers "spam.txt", "quijote.txt" i "tirantloblanc.txt" com un corpus propi'
corpus_root = 'C:\\Users\\nrikee\\PycharmProjects\\NLTK'

corpus_spam = PlaintextCorpusReader ( corpus_root, 'spam.txt' )
freqs_spam = FreqDist ( corpus_spam.words() )

corpus_quijote = PlaintextCorpusReader ( corpus_root, 'quijote.txt' )
freqs_quijote = FreqDist ( corpus_quijote.words() )

corpus_tirant = PlaintextCorpusReader ( corpus_root, 'tirantloblanc.txt' )
freqs_tirant = FreqDist ( corpus_tirant.words() )
print '\t', '...fet.'

print '11. Calcula el nombre de paraules, el nombre de paraules distintes i el nombre de frases'
print '\t', 'spam.txt', len( corpus_spam.words() ), len ( freqs_spam.keys() ), len ( corpus_spam.sents() )
print '\t', 'quijote.txt', len( corpus_quijote.words() ), len ( freqs_quijote.keys() ), len ( corpus_quijote.sents() )
print '\t', 'tirantloblanc.txt', len( corpus_tirant.words() ), len ( freqs_tirant.keys() ), len ( corpus_tirant.sents() )
