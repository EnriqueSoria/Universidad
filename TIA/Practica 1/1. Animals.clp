(do-backward-chaining pardo)
(do-backward-chaining carnivoro)
(do-backward-chaining mamifero)
(do-backward-chaining ave)
(do-backward-chaining manchas)
(do-backward-chaining rayas)
(do-backward-chaining nada)
(do-backward-chaining vuela)
(do-backward-chaining come)
(do-backward-chaining garras)
(do-backward-chaining cubre)
(do-backward-chaining da)
(do-backward-chaining plumas)
(do-backward-chaining pico)
(do-backward-chaining oviparo)
(do-backward-chaining tipo)
(do-backward-chaining alimentacion)

(defrule mamifero
(cubre pelo) ;observable
=> (assert (tipo mamifero)))

(defrule ave
(cubre plumas) ;observable
(oviparo si)
=> (assert (tipo ave)))

(defrule carnivoro
(tipo mamifero) ;observable
(come carne)
(garras si)
=> (assert (alimentacion carnivoro)))

(defrule guepardo
(alimentacion carnivoro) ;observable
(pardo si)
(manchas si)   
=> (assert (animal guepardo)))

(defrule tigre
(alimentacion carnivoro) ;observable
(pardo si)
(rayas si)   
=> (assert (animal tigre)))

(defrule pinguino
(tipo ave) ;observable
(nada bien)
(vuela mal)   
=> (assert (animal pinguino)))

(defrule gaviota
(tipo ave) ;observable
(vuela muybien)   
=> (assert (animal pinguino)))

(defrule mamiferov
(da leche) ;observable   
=> (assert (tipo mamifero)))

(defrule avev
(pico si) ;observable  
(oviparo si) 
=> (assert (tipo ave)))

(defrule pregCubre
(need-cubre ?)
=> (printout t “Que cubre al animal?: “)
(assert (cubre (read))))

(defrule pregOviparo
    (need-oviparo ?)
=> (printout t “es oviparo?: “)
(assert (oviparo (read))))

(defrule pregCome
(need-come ?)
=> (printout t “Que come al animal?: “)
(assert (come (read))))

(defrule pregGarras
(need-garras ?)
=> (printout t “Tiene garras?: “)
(assert (garras (read))))

(defrule pregPardo
(need-pardo ?)
=> (printout t “Es pardo?: “)
(assert (pardo (read))))

(defrule pregManchas
(need-manchas ?)
=> (printout t “Es manchado?: “)
(assert (manchas (read))))

(defrule pregAlim
(need-alimentacion ?)
=> (printout t “Es carnivoro u otro tipo de alimentacion? “)
(assert (alimentacion (read))))

(defrule pregRayas
(need-rayas ?)
=> (printout t “Es rayado?: “)
(assert (rayas (read))))

(defrule pregVuela
(need-vuela ?)
=> (printout t “Como vuela? muybien o mal: “)
(assert (vuela (read))))

(defrule pregNada
(need-nada ?)
=> (printout t “Como nada? bien o mal: “)
(assert (nada (read))))

(defrule pregDa
(need-da ?)
=> (printout t “Que da? : “)
(assert (da (read))))

(defrule pregPico
(need-pico ?)
=> (printout t “tiene pico?: “)
(assert (pico (read))))

(defrule fin
(declare (salience 1000))
(animal ?i)

=>  (printout t “el animal es: “ ?i)
    (halt))

(reset)

(run)
