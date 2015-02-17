(deftemplate PC
    (slot nombre)
    (slot anyo-compra))

(deftemplate Problemas
	(slot pc)
	(slot programa)
	(multislot problemas))

;;================ TESTING ================;;
(deffacts TEST
    ;; Mountain
    (PC (nombre "Mountain") (anyo-compra 2014))
    (Problemas (pc "Mountain") (programa "Jess") (problemas prog-falla))
    
    ;; Asus
    (PC (nombre "Asus") (anyo-compra 2004))
    (Problemas (pc "Asus") (programa "Writer") (problemas res-erroneos))
    )


;;=============== REGLAS ==================;;
;; Si programa falla -> Programa erróneo 
(defrule Prog-erroneo
    ;; Se evita que entre en bucle
    (declare (no-loop TRUE))
    
    ;; Se extraen las propiedades de PC y Problemas.
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Se asegura que el Programa se ejecute en el PC adecuado
    (test (eq ?nom-PC ?nom))		
    
    ;; Se analiza la precondición dada por el experto
    (test (eq ?err prog-falla))
    =>
    ;; Se modifica el hecho según los datos proporcionados por el experto.
    ;; Concretamente, se añade un elemento a la lista de problemas.
    (modify ?q (problemas ?pre ?err ?post prog-erroneo))
    (assert ?q))

;; Si Resultados erroneos -> Error en el codigo
(defrule Error-codigo
    (declare (no-loop TRUE))
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Matching
    (test (eq ?nom-PC ?nom))		
    
    (test (eq ?err res-erroneos))	;; Resultados erroneos
    => 
    (modify ?q (problemas ?pre ?err ?post cod-erroneo))
    ;;(printout t "Resultados erroneos -> Error en el codigo" crlf)
    (assert ?q))

;; Anyo compra
(defrule PC-viejo
    (declare (no-loop TRUE))
    ?r <- (PC (nombre ?nom)(anyo-compra ?anyo))
    ?q <- (Problemas (pc ?nom-pc) (programa ?c) (problemas $?pre ?err $?post))
    
    ;; Matching
    (test (eq ?nom ?nom-pc))
    
    (test (< ?anyo 2005))
    => 
    (modify ?q (problemas ?pre ?err ?post pc-viejo))
    ;;(printout t "Año <2005 -> PC obsoleto" crlf)
    (assert ?q))

;; Anyo compra
(defrule PC-nuevo
    (declare (no-loop TRUE))
    ?r <- (PC (nombre ?nom)(anyo-compra ?anyo))
    ?q <- (Problemas (pc ?nom-pc) (programa ?c) (problemas $?pre ?err $?post))
    
    ;; Matching
    (test (eq ?nom ?nom-pc))
    
    (test (>= ?anyo 2005))
    => 
    (modify ?q (problemas ?pre ?err ?post pc-nuevo))
    ;;(printout t "Año >= 2500 -> Pc nuevo" crlf)
    (assert ?q))

;; Programa lento, pc nuevo -> Memoria Insuficiente
(defrule Mem-insuficiente
    (declare (no-loop TRUE))
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Matching
    (test (eq ?nom-PC ?nom))
    
    (test (eq ?err prog-lento))
    (test (eq ?err pc-nuevo))
    => 
    (modify ?q (problemas ?pre ?err ?post mem-insuficiente))
    ;;(printout t "Programa lento, pc nuevo -> Memoria insuficiente" crlf)
    (assert ?q))

;; Programa lento, pc viejo -> Entonces PC obsoltes
(defrule PC-obsoleto
    (declare (no-loop TRUE))
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Matching
    (test (eq ?nom-PC ?nom))
    
    (test (eq ?err lento))
    (test (eq ?err pc-viejo))
    => 
    (modify ?q (problemas ?pre ?err ?post pc-obsoleto))
    ;;(printout t "Programa lento, pc viejo -> PC Obsoleto" crlf)
    (assert ?q))

;; Si memoria insuficiente -> Memoria saturada
(defrule Mem-saturada
    (declare (no-loop TRUE))
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Matching
    (test (eq ?nom-PC ?nom))
    
    (test (eq ?err mem-insuficiente))
    =>
    (modify ?q (problemas ?pre ?err ?post mem-saturada))
    ;;(printout t "Memoria insuficiente -> Memoria saturada" crlf)
    (assert ?q))

;; Si Programa erróneo -> Conflictos
(defrule Conflictos
    (declare (no-loop TRUE))
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Matching
    (test (eq ?nom-PC ?nom))
    
    (test (eq ?err prog-erroneo))
    =>
    (modify ?q (problemas ?pre ?err ?post conflictos))
    ;;(printout t "Programa erroneo -> Conflictos" crlf)
    (assert ?q)
    )

;; Si Conflictos || Memoria saturada -> Windows sobrecargado
(defrule Windows-sobrecargado
    (declare (no-loop TRUE))
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Matching
    (test (eq ?nom-PC ?nom))
    
    (test (or (eq ?err conflictos) (eq ?err mem-saturada)) )
    =>
    (modify ?q (problemas ?pre ?err ?post windows-sobrecargado))
    ;;(printout t "Conflictos || Mem Saturada -> Win sobrecargado")
    (assert ?q))

;; Si error en el codigo -> corregir fuentes
(defrule Corregir-fuentes
    (declare (no-loop TRUE))
    ?q <- (Problemas (pc ?nom) (programa ?nom-pr) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    ;; Matching
    (test (eq ?nom-PC ?nom))
    
    (test (eq ?err cod-erroneo))
    => 
    (modify ?q (problemas ?pre ?err ?post corregir-fuentes))
    ;;(printout t "Error en el código -> Corregir fuetes" crlf)
    (assert ?q))


;;===================== Consejos =====================
(defrule Consejo-Reiniciar-PC
    (declare (no-loop TRUE) (salience 2000))
    ?q <- (Problemas (pc ?nom) (programa ?c) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    
    (test (eq ?nom ?nom-PC))
    (test (eq ?err windows-sobrecargado)) ;; Problema que dispara la regla
    =>
    (printout t ?nom ": El Windows está sobrecargado, mi CONSEJO es REINICIAR el ordenador. Y instalar un linux." crlf)
    (retract ?q)
    (retract ?r))

(defrule Consejo-Apagar-PC
    (declare (no-loop TRUE) (salience 2000))
    ?q <- (Problemas (pc ?nom) (programa ?c) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    (test (eq ?nom ?nom-PC))
    (test (eq ?err corregir-fuentes)) ;; Problema que dispara la regla
    =>
    (printout t ?nom ": Hay que corregir fuentes. APAGA el PC y no toques nada más." crlf)
    (retract ?q)
    (retract ?r))

(defrule Consejo-Renovar-PC
	(declare (no-loop TRUE) (salience 2000))
    ?q <- (Problemas (pc ?nom) (programa ?c) (problemas $?pre ?err $?post))
    ?r <- (PC (nombre ?nom-PC)(anyo-compra ?anyo))
    (test (eq ?nom ?nom-PC))
    (test (eq ?err pc-obsoleto)) ;; Problema que dispara la regla
    =>
    (printout t ?nom ": Tu ordenador está obsoleto. Consejo: RENUEVA TU PC." crlf)
    (retract ?q)
    (retract ?r))

;;================ Exec ==================;;
(reset)
(facts)
(run)
(facts)
