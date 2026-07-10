

|Legajo|ASCII total|h(k)|¿Colisión?|Intentos (i²)|Posición final|
|-|-|-|-|-|-|
|AB12|230|9|NO|0|9|
|ZX90|283|11|NO|0|11|
|LQ33|259|3|NO|0|3|
|MN45|260|5|NO|0|5|
|AB21|230|9|SI|1|10|
|CD12|234|13|NO|0|13|
|PQ78|272|0|NO|0|0|
|AB30|230|9|SI|2^2 = 4|13|
|EF56|246|8|NO|0|8|
|GH34|246|8|SI|1|9|







¿Dónde hubo más colisiones?

En el índice 9, porque AB12, AB21 y AB30 tienen los mismos caracteres, solo que reordenados. Como la función hash suma los valores ASCII sin importar el orden, los tres dan 230 y caen siempre en el mismo índice base.



¿Qué tan eficiente fue la exploración cuadrática?

Muy eficiente, ninguna colisión necesitó más de 2 intentos.



¿Qué pasaría si el tamaño no fuera primo?

La exploración cuadrática dejaría de recorrer todas las posiciones, dejando celdas libres que nunca se visitan. Si todas las posiciones accesibles están ocupadas, el algoritmo diria tabla llena aunque haya lugares disponibles.

