# coding=utf-8
import re
import sys

if len( sys.argv ) >= 2:
    nomFitxer = sys.argv[2]
else:
    fileName = raw_input( 'Which file do you want to analize? ' )

f = open( nomFitxer )

# @type f file
text = f.read( )

#---- Number of words ----#
paraules = text.split()
nombreParaules = len( paraules )
print 'Nombre de paraules: ' + str( nombreParaules )

#---- Number of lines----#
linies = text.splitlines( )
nombreLinies = len( linies )
print 'Nombre de linies: ' + str( nombreLinies )

#---- Vocabulary ----#
vocabulari = set( paraules )
print '\nHi han ' + str( len( vocabulari ) ) + ' paraules diferents'

d = dict()
for p in paraules:
    if d.has_key( p ):
        d[p] += 1
    else:
        d[p] = 1

print u'Paraules i freqüència: '
for k,v in sorted (d.items()):
    print '{:<15}{:>5}'.format( k, v )

print u'\n\nAra ordenat per freqüència: '
for k,v in sorted ( [(v,k) for k,v in d.items()], reverse=True ):
    print '{:<5}{:<15}'.format( k,v )

#---- Lletres ----#
lletres = []
for ch in text:
    lletres.append(ch)

charD = dict()
for c in lletres:
    if charD.has_key( c ):
        charD[c] += 1
    else:
        charD[c] = 1

print '\nLletres i freqüència: '
for k,v in sorted (charD.items()):
    print k, v

print '\n\nAra ordenat per freqüència: '
for k,v in sorted ( [(v,k) for k,v in charD.items()], reverse=True ):
    print k,v