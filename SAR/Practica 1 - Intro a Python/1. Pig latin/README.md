# Práctica 1.1: Pig latin
## Descripción
El pig latin es un juego con el idioma inglés. 

Buenos días en pig latin se dice `oodgay orningmay`. El pig latin lo usan los niños para divertirse o para conversar secretamente sobre adultos u otros niños. Recíprocamente, los adultos a veces lo usan para hablar de temas sensibles que quieren que los niños no entiendan.
Los turistas anglohablantes a veces usan el pig latin para disimular sus
conversaciones cuando viajan por países donde el inglés es el segundo idioma.

## Reglas simplificadas de conversión de inglés a Pig Latin
 * La traducción se hace palabra a palabra.
 * Si una palabra no comienza con una letra se deja igual.
 * Para las palabras que comienzan con consonantes, se mueven todas las consonantes antes de la primera vocal al final y se agrega la sílaba "ay".
 * Para palabras que comienzan con vocal (incluyendo la y), simplemente se agrega "yay" al final de la palabra.

## Ejemplos
 * mess → essmay
 * father → atherfay
 * Rwanda → Andarway
 * choir → oirchay
 * ant → antyay

## Se pide:
Escribe un programa en python que pida frases en inglés por teclado y las traduzca a Pig Latin.
Se debe tener en cuenta:
 * La traducción de la frase se hace palabra a palabra.
 * Se deben respetar todos los signos de puntuación.
 * Se deben respetar las mayúsculas (si una palabra empieza con mayúscula su traducción también debe empezar con mayúscula).
 * El programa se ejecutará hasta que se introduzca una cadena vacía. 