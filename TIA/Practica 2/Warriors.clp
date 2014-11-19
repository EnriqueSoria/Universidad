;TEMPLATES SALUD Y ESTRATEGIA
(deftemplate saludp
	0 100
	(
		(cercana-muerte (0 1) (50 0))
		(buena (20 0) (50 1) (80 0))
		(excelente (50 0) (100 1))
	)
)
(deftemplate salude
	0 100
	(
		(cercana-muerte (0 1) (50 0))
		(buena (20 0) (50 1) (80 0))
		(excelente (50 0) (100 1))
))
(deftemplate estrategia
	0 5
	((salir-corriendo (0 1) (1 1) (2 0))
	(ataque-defensivo (1 0) (2 1) (3 1) (4 0))
	(fuera-combate (3 0) (4 1) (5 1))
	)
)



;REGLAS-ESTRATEGIA A SEGUIR
;Estrategia a seguir: salir corriendo
 (defrule salir-corriendo
	(saludp cercana-muerte)
	(salude buena)
    =>
    (assert (estrategia salir-corriendo))
    (printout t "La estrategia a seguir sera salir corriendo." crlf)
)
(defrule salir-corriendo2
	(saludp cercana-muerte)
	(salude excelente)
    =>
    (assert (estrategia salir-corriendo))
    (printout t "La estrategia a seguir sera salir corriendo." crlf)
)
(defrule fuera-combate1
	(saludp buena)
	(salude cercana-muerte)
    =>
    (assert (estrategia fuera-combate))
    (printout t "La estrategia a seguir sera dejar al enemigo fuera de combate." crlf)
)
(defrule fuera-combate2
	(saludp excelente)
	(salude cercana-muerte)
    =>
    (assert (estrategia fuera-combate))
    (printout t "La estrategia a seguir sera dejar al enemigo fuera de combate." crlf)
)
(defrule fuera-combate3
	(saludp excelente)
	(salude buena)
    =>
    (assert (estrategia fuera-combate))
    (printout t "La estrategia a seguir sera dejar al enemigo fuera de combate." crlf)
)

;EN CUALQUIER OTRO CASO->ATAQUE DEFENSIVO
;Estrategia a seguir: ataque defensivo
(defrule ataque-defensivo1
	(saludp cercana-muerte)
	(salude cercana-muerte)
    =>
    (assert (estrategia ataque-defensivo))
)
;Estrategia a seguir: ataque defensivo
(defrule ataque-defensivo2
	(saludp buena)
(salude buena)
    =>
    (assert (estrategia ataque-defensivo))
    (printout t "La estrategia a seguir sera hacer un ataque defensivo." crlf )
)
;Estrategia a seguir: ataque defensivo
(defrule ataque-defensivo3
	(saludp buena)
	(salude excelente)
    =>
    (assert (estrategia ataque-defensivo))
    (printout t "La estrategia a seguir sera hacer un ataque defensivo." crlf)
)
;Estrategia a seguir: ataque defensivo
(defrule ataque-defensivo4
	(saludp excelente)
	(salude excelente)
    =>
    (assert (estrategia ataque-defensivo))
    (printout t "La estrategia a seguir sera hacer un ataque defensivo." crlf)
)

(defrule final
	?f <- (estrategia ?e)
	=>
	(bind ?estr (maximum-defuzzify ?e))
	(printout t "La fuerza en el siguiente asalto " ?estr crlf )
	(halt)
)

;; FUZZIFY
(deffunction fuzzify (?fztemplate ?value ?delta)
	(bind ?low (get-u-from ?fztemplate))
	(bind ?hi  (get-u-to   ?fztemplate))
      	(if (<= ?value ?low)
	        then
		(assert-string
            	(format nil "(%s (%g 1.0) (%g 0.0))" ?fztemplate ?low ?delta))
        else
          (if (>= ?value ?hi)
          then
              (assert-string
                 (format nil "(%s (%g 0.0) (%g 1.0))"
                             ?fztemplate (- ?hi ?delta) ?hi))
            else
              (assert-string
                 (format nil "(%s (%g 0.0) (%g 1.0) (%g 0.0))"
                             ?fztemplate (max ?low (- ?value ?delta))
                             ?value (min ?hi (+ ?value ?delta)) ))
          )
      )
)


(deffunction inicio()
	(set-salience-evaluation when-activated)
	(reset)
	(printout t "Cual es tu salud, jugador principal? [0,100]: " )
	(bind ?p (read))
	(printout t "Cual es tu salud, jugador enemigo? [0,100]: " )
	(bind ?e (read))

	(fuzzify saludp ?p 0.1)
	(fuzzify salude ?e 0.1)
	(run)
)
