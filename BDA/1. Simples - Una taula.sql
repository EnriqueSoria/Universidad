============================
#	CICLISMO	   #
============================

==> CONSULTAS SIMPLES 1 TABLA

1->	
select *
from maillot

2->
Select dorsal, nombre
From ciclista
Where edad<=25

3->
select nompuerto, altura 
from puerto
where categoria='E'

4->
SELECT NETAPA
FROM ETAPA
WHERE SALIDA=LLEGADA;

5->
SELECT COUNT(*)
FROM CICLISTA;

6->
SELECT COUNT(*)
FROM CICLISTA
WHERE EDAD>25;

7->
SELECT AVG(EDAD)
FROM CICLISTA;

8->
SELECT MIN(ALTURA), MAX(ALTURA)
FROM PUERTO

9->
SELECT MIN(ALTURA), MAX(ALTURA)
FROM PUERTO


============================
#	BIBLIOTECA	   #
============================

==> CONSULTAS SIMPLES 1 TABLA

1->
SELECT NOMBRE
FROM AUTOR
WHERE NACIONALIDAD='Argentina'

2->
SELECT TITULO
FROM OBRA
WHERE TITULO like '%mundo%'

3->
select ID_LIB, NUM_OBRAS
from libro
where "AÑO"<1990 and NUM_OBRAS>1;

4->
select count("AÑO")
from libro
where "AÑO" is not NULL;

5->
select count(*)
from LIBRO
where NUM_OBRAS>1;

6->
select ID_LIB
from libro
where "AÑO" = 1997 and TITULO is null;

7->
select TITULO
from LIBRO
where titulo is not null
order by TITULO desc;

8->
select sum(NUM_OBRAS)
from libro
where "AÑO" between 1990 and 1999;

============================
#	  MUSICA	   #
============================

==> CONSULTAS SIMPLES 1 TABLA

1->
select count(*)
from disco;

2->
select NOMBRE
from grupo
where PAIS <> 'España'

3->
select titulo
from cancion
where DURACION>5;

4->
select distinct(funcion)
from pertenece;

5->
select nombre, num
from club
order by num;

6->
select nombre, SEDE
from club
where num>500;
