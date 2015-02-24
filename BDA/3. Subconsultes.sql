16. Obtingueu el valor de l’atribut netapa i la ciutat d’eixida d’aquelles etapes que no tinguen ports
de muntanya.

select et.netapa, et.salida
from etapa et
where netapa not in (select pu.netapa
					  from puerto pu, etapa et2
					  where pu.netapa=et2.netapa)
		
					  
17. Obtingueu l’edat mitjana dels ciclistes que han guanyat alguna etapa.
select avg(edad)
from ciclista ci
where ci.dorsal in (select et.dorsal
					from etapa et
					where ci.dorsal=et.dorsal)
		
					
18. Seleccioneu el nom dels ports amb una altura superior a l’altura mitjana de tots els ports.
select pu.nompuerto
from puerto pu
where pu.altura > (select avg(pu2.altura)
					from puerto pu2)


19. Obtingueu el nom de la ciutat d’eixida i d’arribada de les etapes on estiguen els ports amb major
pendent.
select et.salida, et.llegada
from etapa et, puerto pu2
where et.netapa=pu2.netapa and pu2.pendiente = (select max(pu.pendiente)
												from puerto pu, etapa et2
												where pu.netapa=et2.netapa)
		
												
20. Obtingueu el dorsal i el nom dels ciclistes que han guanyat els ports de major altura.
select ci.dorsal, ci.nombre
from ciclista ci, puerto pi
where ci.netapa = pi.netapa and pi.altura = (select max(p2.altura)
											  from puerto p2)
											  

21. Obtingueu el nom del ciclista més jove.
select ci.nombre
from ciclista ci
where ci.edad = (select min(c2.edad) from ciclista c2)


22. Obtingueu el nom del ciclista més jove que ha guanyat almenys una etapa.
select ci.nombre, ci.edad
from ciclista ci
where ci.edad in (select min(c2.edad)
              from ciclista c2, etapa e2
              where c2.dorsal=e2.dorsal) and ci.dorsal in (select dorsal from etapa);


23. Obtingueu el nom dels ciclistes que han guanyat més d’un port.
select ci.nombre
from ciclista ci
where ci.dorsal in 
	(select cic.dorsal 
	 from ciclista cic, puerto p1, puerto p2
	 where  cic.dorsal = p1.dorsal and 
	 		cic.dorsal = p2.dorsal and 
	 		p1.nompuerto <> p2.nompuerto)



