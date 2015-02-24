
/***** TAULA CICLISTES ******/
/***** CICLISME: DIVERSES TAULES*****/

select p.nompuerto, p.categoria
from puerto p, ciclista ci
where c.dorsal = p.dosrsal AND ci.nomeq= 'Banesto'

/***********/

select p.nompuerto, p.netapa, e.km
from puerto p, etapa e
where p.netapa = e.netapa

/***********/

select distinct e.nomeq, e.director
from equipo e, ciclista ci
where e.nomeq = ci.nomeq AND ci.edad > 33

/***********/

select distinct ci.nombre, ma.color
from ciclista ci, llevar ll, maillot ma
where ma.codigo = ll.codigo AND ci.dorsal = ll.dorsal

/***********/

select ci.nombre, et.netapa
from ciclista ci, etapa et, llevar ll
where ci.dorsal = et.dorsal AND ci.dorsal = ll.dorsal AND et.netapa = ll.netapa AND ma.color = 'Amarillo'

/***********/

select distinct e1.netapa
from etapa e1, etapa e2
where e1.netapa <> e2.netapa AND e1.netapa = e2.netapa - 1 AND e2.SALIDA <> e1.LLEGADA


