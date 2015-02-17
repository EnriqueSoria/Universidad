debug = 1
if debug: 
    B = Boda(3,5)
    print '=[ Poblacion inicial ]='
    print B.poblacion
    
    print '=[ Fitness ]='
    print [B.fitness(nw) for nw in B.poblacion]
    
    print '=[ Seleccion ]='
    from random import shuffle
    solutions = sorted( B.poblacion, key=lambda(x): B.fitness(x) )
    selected = solutions[::2]
    print selected
    
    print '=[ Cruce ]='
    new_solutions = [B.combine(f,m) for f, m in zip(selected,reversed(selected))]
    for f, m, r in zip(selected,reversed(selected),new_solutions):
        print 'Padres', f, m
        print 'Hijo', r
    
    print '=[ Reemplazo ]='
    print new_solutions
    
else:         
    print 'Calculando...'
    B = Boda(3, 5)
    c = B.poblacion

    print 'Max ini: ', B.best
    B.iterate(1)
    print B.best, '/', B.K*2
