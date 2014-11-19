# coding=utf-8
import re
import sys

stop_words = 'a about above across actually after again against ago all almost along already also although always among ' \
             'an and another any anyone around as at b back bad because before behind best better between big biggest ' \
             'both but by c cent complete d day down during e each early eight enough entire ep etc even ever every ' \
             'everything f face fact far fell few finally first five for found four from g good got h he held her here ' \
             'him himself his hour hours how however i idea if in including instead into it its itself j k l lack last ' \
             'later least led less little long longer lot m man many matter may me men miles million moment month months' \
             ' more morning most much my n near nearly necessary never night no nor not note nothing now o of off often ' \
             'on once one only or other others our out outside over own p page part past per perhaps place point proved ' \
             'q qm question r really recent recently reported round s same sec second section sense seven she short ' \
             'should showed since single six small so some soon still such t ten text than that the their them themselves' \
             ' then there these they thing things third this those though thought thousands three through thus time tiny' \
             ' to today together too took toward two u under until up upon us v very w warning way we week weeks well' \
             ' went were what when where whether which while who whom whose why will with without word words would x y' \
             ' year years yet you your z'.split ( )

# File selection
if len ( sys.argv ) >= 2:
    nomFitxer = sys.argv [ 2 ]
else:
    nomFitxer = raw_input( 'Which file do you want to analize? ' )

f = open ( nomFitxer )
text = f.read ( )

print 'Leyendo el fichero...'

# Eliminar signes de puntuació i passant-ho a minúscules
text.lower ( )                         # Text a minúscules
text = re.sub ( '[^\w ]', ' ', text )  # Eliminem signes de puntuació i els canviem per espais
text = text.replace ( '  ', ' ' )      # Eliminem doble espaiament
paraules = text.split ( )

# Eliminar stop-words
def removeAll ( list, value ):
    while value in list:
        list.remove ( value )


for paraula in paraules:
    removeAll ( paraules, paraula )

#---- Análisis per parelles de paraules ----#
d = dict ( )
for i in xrange ( 1, len ( paraules ) ):
    key = paraules [ i - 1 ] + ' ' + paraules [ i ]
    if d.has_key ( key ):
        d [ key ] += 1
    else:
        d [ key ] = 1

    if i + 1 < len ( paraules ):
        key = paraules [ i ] + ' ' + paraules [ i + 1 ]
        if d.has_key ( key ):
            d [ key ] += 1
        else:
            d [ key ] = 1

print u'Paraules i freqüència: '
for k, v in sorted ( d.items ( ) ):
    print '{:<25}{:>15}'.format ( k, v )

print u'\n\nAra ordenat per freqüència: '
for k, v in sorted ( [ (v, k) for k, v in d.items ( ) ], reverse=True ):
    print '{:<5}{:<15}'.format ( k, v )

#---- Análisis per parelles de lletres ----#
d = dict ( )
for i in xrange ( 1, len ( text ) ):
    key = text [ i - 1 ] + '' + text [ i ]
    if d.has_key ( key ):
        d [ key ] += 1
    else:
        d [ key ] = 1

    if i + 1 < len ( text ):
        key = text [ i ] + '' + text [ i + 1 ]
        if d.has_key ( key ):
            d [ key ] += 1
        else:
            d [ key ] = 1

print u'Lletres i freqüència: '
for k, v in sorted ( d.items ( ) ):
    print '{:<25}{:>15}'.format ( k, v )

print u'\n\nAra ordenat per freqüència: '
for k, v in sorted ( [ (v, k) for k, v in d.items ( ) ], reverse=True ):
    print '{:<5}{:<15}'.format ( k, v )