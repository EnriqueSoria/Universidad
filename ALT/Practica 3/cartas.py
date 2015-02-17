# -*- coding: utf-8 -*- 

class Baralla():
    '''
    Resol un problema típic de cartes.
    
    Donat un numero, per exemple, el 4 s'han de col·locar cartes de forma que
    hi haga per a cada parell de cartes del mateix numero, estiguen separades 
    per eixe mateix número de cartes:
    
    n = 4
    4 1 3 1 2 4 3 2
    '''

    def __init__(self, n, verbose=True, totes=False):
        # Inicialitzem cartes i solució
        self.n = n
        self.cartes = [0] * (n+1)
        self.solucio = [None] * (2 * n)
        self.verbose = verbose
        self.totes = totes
        self.resultats = []
        
        # Solucionem
        self.soluciona()

        
    def soluciona(self):
        ''' Si s'han utilitzat totes les cartes i la solució es vàlida, acabem.'''
        if self.esTerminal():
                self.resultats.append(self.solucio[:])
                ''' Si ja hem trobat una solució, acabem'''
                return -1

        else:
            # Primera iteració: agafem la carta més alta
            #  N = Carta elegida
            N = max( [i for i in xrange(1, self.n+1) if not self.cartes[i]] )
            if self.verbose: print 'Agafem la carta', N, 'en el nivell', sum(self.cartes)+1
            
            # Comprovem *cada* sol·lució
            posibilitats = range( len(self.solucio) - (N+1) )
            for i in posibilitats:
                'not used' #N = max( [ii for ii in xrange(1, self.n+1) if not self.cartes[ii] ] )
                if self.verbose: print 'Agafem la carta', N, 'en el nivell', sum(self.cartes)+1
                
                # Marquem la carta, comprobant si es factible
                #  si les dos posicions estàn buides, les plenem
                if not self.solucio[i] and not self.solucio[i+N+1]:
                    # Marquem la carta com agafada
                    self.cartes[N] = 1
                
                    # Posem les cartes al lloc
                    self.solucio[i] = N
                    self.solucio[i + N + 1] = N
                    
                    # Cridem a solve
                    if self.verbose: print '\t Cartes: ', self.cartes
                    ''' Si ja hem trobat una solució, acabem'''
                    if self.soluciona() == -1: return -1 
                    
                    # Desmarquem.
                    self.cartes[N] = 0
                    self.solucio[i] = None
                    self.solucio[i + N + 1] = None
                        

    def esTerminal(self):
        return sum(self.cartes) == self.n


if __name__ == '__main__':

    # Argparse
    import sys
    args = sys.argv[1:]

    if len(args)==1:
        print 'El paràmetre es', args[0]
        n = int(args[0])
        solucions = Baralla(n, verbose=False, totes=False)
        print solucions.resultats if solucions.resultats else 'No hi ha solució'
    
