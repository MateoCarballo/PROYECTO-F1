DROP DATABASE IF EXISTS temporadaF12024;
CREATE DATABASE temporadaF12024;
-- Sin esta instruccion no me dejaba hacer los insert 'SET FOREIGN_KEY_CHECKS=0;'
SET FOREIGN_KEY_CHECKS=0;
USE temporadaF12024;
# 	En todas las tablas se puede añadir mas información pero por ahora solo tengo lo más importante.
CREATE TABLE Pilotos(
	IdPiloto			INT,
    Nombre				VARCHAR(50),
    Apellido			VARCHAR(50),
	Equipo				INT,
    NumeroMonoplaza		INT UNIQUE -- Numero que usan en el coche
);
/*DEBERIA HACER ESTO?

CREATE TABLE PilotosEquipos(
	IdPiloto	INT,
    IdEquipo	INT,
    PRIMARY KEY (IdPiloto,IdEquipo),
);

No entiendo bien la ventaja de usar una forma u otra
*/
CREATE TABLE Equipos(
	IdEquipo			INT,
    Nombre				VARCHAR(100),
    Piloto1				INT,
    Piloto2				INT,
    PilotoReserva		INT,
    INDEX (IdEquipo)
);

CREATE TABLE Circuitos(
	IdCircuito			INT PRIMARY KEY,
    Nombre				VARCHAR(50),
    Longitud			FLOAT, -- Kilometros
    Ubicacion			VARCHAR(50)
);
## hAY CIRCUITOS QUE TIENEN DOS CARRERAS POR ESO NECESITO ESTA TABLA, APARTE POSIBLEMENTE CAMBIE IdCarrera por otro nombre para poder tener tambien las QUALIS aquí
CREATE TABLE Carrera(
	IdCarrera			INT,
    Circuito			INT,
    FechaCelebración	DATE
);

CREATE TABLE PosicionesCarrera(
	Carrera				INT,
    Piloto				INT,
    Equipo				INT,
    Posicion			INT,
    Puntos				INT
);

CREATE TABLE Usuarios(
	IdUsuario			INT,
	Nombre				VARCHAR(50),
    Clave				VARCHAR(50),
    Alias				VARCHAR(15),
    Sala				INT,
    PRIMARY KEY (IdUsuario)
);

CREATE TABLE Salas(
	IdSala				INT PRIMARY KEY,
    Nombre				VARCHAR(50)
    );

CREATE TABLE UsuarioSala(
	IdUsuario			INT,
    IdSala				INT,
    Puntuacion			INT,
    PRIMARY KEY (IdUsuario,IdSala),
    FOREIGN KEY (IdUsuario) REFERENCES Usuarios(IdUsuario),
    FOREIGN KEY (IdSala) REFERENCES Salas(IdSala)
);

ALTER TABLE Pilotos
ADD CONSTRAINT pk_Pilotos
PRIMARY KEY (IdPiloto),
ADD CONSTRAINT fk_EquipoEquipos
FOREIGN KEY (Equipo) REFERENCES Equipos(IdEquipo);

ALTER TABLE Equipos
ADD CONSTRAINT pk_Equipos
PRIMARY KEY (IdEquipo),
ADD CONSTRAINT fk_Piloto1_Pilotos
FOREIGN KEY (Piloto1) 		REFERENCES Pilotos(IdPiloto),
ADD CONSTRAINT fk_Piloto2_Pilotos
FOREIGN KEY (Piloto2) 		REFERENCES Pilotos(IdPiloto),
ADD CONSTRAINT fk_Piloto3_Pilotos
FOREIGN KEY (PilotoReserva) REFERENCES Pilotos(IdPiloto);

ALTER TABLE Carrera
ADD CONSTRAINT pk_Carrera
PRIMARY KEY (IdCarrera),
ADD CONSTRAINT fk_CircuitoIdCircuito
FOREIGN KEY (Circuito) REFERENCES Circuitos(IdCircuito);

ALTER TABLE PosicionesCarrera
ADD CONSTRAINT pk_Compuesta_CarreraPilotoEquipo 
PRIMARY KEY (Carrera,Piloto, Equipo),
ADD CONSTRAINT fk_Piloto_IdPiloto
FOREIGN KEY (Piloto) 		REFERENCES Pilotos(IdPiloto),	
ADD CONSTRAINT fk_Equipo_IdEquipo
FOREIGN KEY (Equipo) 		REFERENCES Equipos(IdEquipo),
ADD CONSTRAINT fk_Carrera_IdCarrera
FOREIGN KEY (Carrera) 		REFERENCES Carrera(IdCarrera);


INSERT INTO Equipos (IdEquipo,Nombre,Piloto1,Piloto2,PilotoReserva) VALUES 
(1,'Red Bull Racing Honda',1,2,101),
(2,'Mercedes-AMG Petronas Formula One Team',3,4,102),
(3,'Ferrari',5,6,103),
(4,'McLaren F1 Team',7,8,104),
(5,'Aston Martin Aramco',9,10,105),
(6,'Alpine BWT F1 Team',11,12,106),
(7,'Williams Racing F1',13,14,107),
(8,'Alpha Tauri Honda',15,16,108),
(9,'Kick Sauber',17,18,109),
(10,'Haas F1 Team',19,20,110);


INSERT INTO Pilotos (IdPiloto, Nombre, Apellido, Equipo, NumeroMonoplaza) VALUES
(1, 'Max', 'Verstappen', 1, 1),-- Red Bull Racing
(2, 'Sergio', 'Pérez', 1, 11),  
(101, 'Piloto', 'Reserva', 1, 101),	
(3, 'Lewis', 'Hamilton', 2, 44),-- Mercedes
(4, 'George', 'Russell', 2, 63),
(102, 'Piloto', 'Reserva', 1, 102),	  
(5, 'Charles', 'Leclerc', 3, 16),-- Ferrari
(6, 'Carlos', 'Sainz', 3, 55),
(103, 'Piloto', 'Reserva', 1, 103),	  		
(7, 'Lando', 'Norris', 4, 4),-- McLaren
(8, 'Oscar', 'Piastri', 4, 81),
(104, 'Piloto', 'Reserva', 1, 104),	  	
(9, 'Fernando', 'Alonso', 5, 14),-- Aston Martin
(10, 'Lance', 'Stroll', 5, 18),
(105, 'Piloto', 'Reserva', 1, 105),	  	
(11, 'Pierre', 'Gasly', 6, 10),-- AplineBWT
(12, 'Esteban', 'Ocon', 6, 31),  
(106, 'Piloto', 'Reserva', 1, 106),		
(13, 'Daniel', 'Ricciardo', 7, 3),-- AlphaTauri
(14, 'Yuki', 'Tsunoda', 7, 22),
(107, 'Piloto', 'Reserva', 1, 107),	  		
(15, 'Valtteri', 'Bottas', 8, 77),-- Alfa Romeo Racing
(16, 'Zhou', 'Guanyu', 8, 24),
(108, 'Piloto', 'Reserva', 1, 108),	  			
(17, 'Alex', 'Albon', 9,23),-- Williams
(18, 'Logan', 'Sargeant', 9,2), 
(109, 'Piloto', 'Reserva', 1, 109),	 	
(19, 'Kevinn', 'Magnussem', 10,20 ),-- Haas
(20, 'Nico', 'Hulkenberg', 10, 21),
(110, 'Piloto', 'Reserva', 1, 110);	 

INSERT INTO Circuitos (IdCircuito,Nombre,Longitud,Ubicacion) VALUES
(1,'Barhain International Circuit',5.412,'Bahréin'),
(2,'Yeddah Corniche Circuit',6.175,'Arabia Saudí'),
(3,'Melbourne Grand Prix Circuit', 5.303,'Australia'),
(4,'Suzuka International Racing Course',5.807,'Japón'),
(5,'Circuito de Shanghai',5.451,'China'),
(6,'Circuito urbano de Miami',5.410,'Estados Unidos'),
(7,'Autodromo Enzo e Dino Ferrari',5.410,'Italia'),
(8,'Circuito de Mónaco',3.340,'Mónaco'),
(9,'Circuito Gilles Villeneuve',4.361,'Canadá'),
(10,'Circuit de Barcelona-Catalunya',4.655,'España'),
(11,'Red Bull Ring',4.326,'Austria'),
(12,'Circuito de Silverstone',5.891,'Gran Bretaña'),
(13,'Circuito de Hungaroring',4.381,'Hungría'),
(14,'Circuito de Spa-Francorchamps',7.004,'Bélgica'),
(15,'Circuito de Zandvoort',4.259,'Países Bajos'),
(16,'Circuito de Monza',5.793,'Italia'),
(17,'Bakú City Circuit',6.003,'Azerbaiyán'),
(18,'Circuito de Marina Bay',5.073,'Singapur'),
(19,'Circuito de las Américas(COTA)',5.513,'Estados Unidos'),
(20,'Autódromo Hermanos Rodríguez',4.421,'México'),
(21,'José Carlos Pace (Interlagos)',4.309,'Brasil'),
(22,'Circuito de Las Vegas',6.201,'Estados Unidos'),
(23,'Circuito de Losail',5.380,'Qatar'),
(24,'Circuito de Yas Marina',5.554,'Emiratos Arabes Unidos');

INSERT INTO PosicionesCarrera (Carrera, Piloto, Equipo, Posicion, Puntos) VALUES
-- Ejemplo de INSERT para la carrera 1
# Carrera|Piloto|Equipo|Posicion|Puntos
(1		, 1		, 1		, 1		, 25),  
(1		, 2		, 1		, 2		, 18),  
(1		, 3		, 2		, 3		, 15),  
(1		, 4		, 2		, 4		, 12),
(1		, 5		, 3		, 5		, 10),  
(1		, 6		, 3		, 6		, 8),  
(1		, 7		, 4		, 7		, 6),  
(1		, 8		, 4		, 8		, 4),
(1		, 9		, 5		, 9		, 2),  
(1		, 10	, 5		, 10	, 1);

INSERT INTO Carrera (IdCarrera, Circuito, FechaCelebración) VALUES
(1, 1, NULL),
(2, 2, NULL),
(3, 3, NULL),
(4, 4, NULL),
(5, 5, NULL),
(6, 6, NULL),
(7, 7, NULL),
(8, 8, NULL),
(9, 9, NULL),
(10, 10, NULL),
(11, 11, NULL),
(12, 12, NULL),
(13, 13, NULL),
(14, 14, NULL),
(15, 15, NULL),
(16, 16, NULL),
(17, 17, NULL),
(18, 18, NULL),
(19, 19, NULL),
(20, 20, NULL),
(21, 21, NULL),
(22, 22, NULL),
(23, 23, NULL),
(24, 24, NULL);
