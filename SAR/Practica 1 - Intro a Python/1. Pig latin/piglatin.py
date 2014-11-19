# Functions
def pigIt( original ):
    frst = original [0].lower()
    if frst in vocals:
        return original + 'yay'
    else:
        return pigConsonant ( original[0], original [1:] ) + 'ay'
    
def pigConsonant ( ini, original ):
     frst = original [0]
     if frst in vocals:
        return original + ini
     else:
        return pigConsonant ( ini + original[0], original [1:] )

# Main code
vocals = [ 'a', 'e', 'i', 'o', 'u', 'y' ]
original = raw_input ( 'Say something:\n' )
while len ( original ) != 0:
    tokens = original.split ( ' ' )
    translated = ''
    for i in xrange( len ( tokens ) ):
        translated += ( pigIt ( tokens [i] ) ) + ' '
    print translated
    original = raw_input ( 'Say something:\n' )
