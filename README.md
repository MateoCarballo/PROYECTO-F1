# PROYECTO FORMULA 1 


## Idea inicial.

Mi idea con este proyecto es crear unas ligas, con entre 5 y 10 personas. 
Para esto dispondremos de una base de datos con los resultados de cada piloto y escudería(La escudería quiza la omitire porque cada usuario será su propia escudería).
Cada usuario tendrá que elegir dos pilotos, un piloto reserva(de categorias inferiores que estarán en la DB)y un jefe de equipo. 

## Sistema de puntuación de la sala (Liga).

Cada piloto obtendra una puntuacion en cada carrera, 
basandonos en parametros como los puntos obtenidos en la carrera, posicion de salida y finalizacion
adelantamientos realizados, la poscion en la tabla de vueltas rápida y otros parametros.


## Estructura del programa.

La idea es que cada tabla tenga un referente en el programa a modo de clase.
Es decir si tengo una tabla de pilotos llamada <<Pilotos>> tendré una clase <<Piloto>> en el codigo java.
Los valores que no van a actualizarse ni modificarse se cargan desde el codigo mySQL. Los circutos, Pilotos y Carreras se cargan desde mySQL y las tablas derivadas de combinaciones de estas.
Los valores de los usuarios y las salas se introduciran a traves de conexiones desde java.