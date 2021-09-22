cd..
cd..
cd xampp\mysql\bin
mysql -h localhost -u root -p


create database agencias;
use agencias;

create table empresas 
( 	empId int,
	empNombre varchar (20),
	empDireccion varchar (20),
	empTelefono varchar (15),
	
	primary key (empId)
	
);

desc empresas;

create table sucursales
(	
	sucId int,
	sucTelefono varchar (20),
	sucDireccion varchar (20),
	empId int,
	
	primary key (sucId),
	constraint foreign Key  fk1 (empId) references empresas(empId) 
);


create table turista
(
	turId int,
	turApellidos varchar (20),
	turDireccion varchar (20),
	turTelefono varchar (20),
	
	primary key (turId)
);

create table vuelo
(
	vueId int,
	vueSillasPrimeraClase varchar (20),
	vueFecha DateTime,
	vueDestino varchar (20),
	vueSillasClaseTurista varchar (20),
	
	primary key (vueId)
);

create table hoteles
(
	hotId int,
	hotDireccion varchar (20),
	hotNombre varchar (20),
	hotTelefono varchar (20),
	hotCiudad varchar (20),
	hotHabitacion varchar (20),
	
	primary key (hotId)
);

create table turistaEmpresas
(
	
	turId int,
	empId int,
	primary key (turId,empId),
	constraint foreign Key  fk2 (turId) references turista(turId)ON UPDATE CASCADE,
	constraint foreign Key  fk3 (empId) references empresas(empId)ON UPDATE CASCADE
);

create table turistaVuelo
(
	turId int,
	vueId int,
	fechaIngreso date,
	fechaSalida date,
	acomodacion varchar (20),
	primary key (turId,vueId),
	constraint foreign Key  fk4 (turId) references turista(turId)ON UPDATE CASCADE,
	constraint foreign Key  fk5 (vueId) references vuelo(vueId)ON UPDATE CASCADE
);

create table turistaHoteles
(
	turId int,
	hotId int,
	claseViaje varchar (20),
	constraint foreign Key  fk6 (turId) references turista(turId)ON UPDATE CASCADE,
	constraint foreign Key  fk7 (hotId) references hoteles(hotId)ON UPDATE CASCADE
);

show tables;

insert into empresas
	(empId,empNombre,empDireccion,empTelefono)
	values (10,'Movistar','Cra 23','1354687');
insert into empresas
	(empId,empNombre,empDireccion,empTelefono)
	values (11,'Claro','Cra 24','1454687');
insert into empresas
	(empId,empNombre,empDireccion,empTelefono)
	values (12,'vodafone','Cra 32','14454687');
insert into empresas
	(empId,empNombre,empDireccion,empTelefono)
	values (13,'une','Cra 25','14546987');
insert into empresas
	(empId,empNombre,empDireccion,empTelefono)
	values (14,'oranje','Cra 36','14574687');
	
	
insert into sucursales
	(sucId,sucTelefono,sucDireccion,empId)
	values (1,'14574687','Cra 23',10);
insert into sucursales
	(sucId,sucTelefono,sucDireccion,empId)
	values (2,'14574687','Cra 23',11);
insert into sucursales
	(sucId,sucTelefono,sucDireccion,empId)
	values (3,'14574687','Cra 23',12);
insert into sucursales
	(sucId,sucTelefono,sucDireccion,empId)
	values (4,'14574687','Cra 23',13);
insert into sucursales
	(sucId,sucTelefono,sucDireccion,empId)
	values (5,'14574687','Cra 23',14);
	
	
insert into turista
	(turId,turApellidos,turDireccion,turTelefono)
	values (20,'Grizales','Cra 23','14546987');
insert into turista
	(turId,turApellidos,turDireccion,turTelefono)
	values (30,'Grizales','Cra 23','14546987');
insert into turista
	(turId,turApellidos,turDireccion,turTelefono)
	values (40,'Grizales','Cra 23','14546987');
insert into turista
	(turId,turApellidos,turDireccion,turTelefono)
	values (50,'Grizales','Cra 23','14546987');
insert into turista
	(turId,turApellidos,turDireccion,turTelefono)
	values (60,'Grizales','Cra 23','14546987');
	
	
insert into vuelo
	(vueId,vueSillasPrimeraClase,vueDateTime,vueDestino,vueSillasClaseTurista)
	values(31,'ninguna','n','AlgunLugar','AlgunOtroLugar');
insert into vuelo
	(vueId,vueSillasPrimeraClase,vueDateTime,vueDestino,vueSillasClaseTurista)
	values(32,'ninguna','n','AlgunLugar','AlgunOtroLugar');
insert into vuelo
	(vueId,vueSillasPrimeraClase,vueDateTime,vueDestino,vueSillasClaseTurista)
	values(33,'ninguna','n','AlgunLugar','AlgunOtroLugar');
insert into vuelo
	(vueId,vueSillasPrimeraClase,vueDateTime,vueDestino,vueSillasClaseTurista)
	values(34,'ninguna','n','AlgunLugar','AlgunOtroLugar');
insert into vuelo
	(vueId,vueSillasPrimeraClase,vueDateTime,vueDestino,vueSillasClaseTurista)
	values(35,'ninguna','n','AlgunLugar','AlgunOtroLugar');
	
	
insert into hoteles
	(hotId,hotDireccion,hotNombre,hotTelefono,hotCiudad,hotHabitacion)
	values (40,'Cra 23','cualquiera','algunaparte','algunas','bla');
insert into hoteles
	(hotId,hotDireccion,hotNombre,hotTelefono,hotCiudad,hotHabitacion)
	values (41,'Cra 23','cualquiera','algunaparte','algunas','bla');
insert into hoteles
	(hotId,hotDireccion,hotNombre,hotTelefono,hotCiudad,hotHabitacion)
	values (42,'Cra 23','cualquiera','algunaparte','algunas','bla');
insert into hoteles
	(hotId,hotDireccion,hotNombre,hotTelefono,hotCiudad,hotHabitacion)
	values (43,'Cra 23','cualquiera','algunaparte','algunas','bla');
insert into hoteles
	(hotId,hotDireccion,hotNombre,hotTelefono,hotCiudad,hotHabitacion)
	values (44,'Cra 23','cualquiera','algunaparte','algunas','bla');
	
	
	
insert into turistaEmpresas
	(turId,empId)
	values (20,10);
insert into turistaEmpresas
	(turId,empId)
	values (30,11);
insert into turistaEmpresas
	(turId,empId)
	values (40,12);
insert into turistaEmpresas
	(turId,empId)
	values (50,13);
insert into turistaEmpresas
	(turId,empId)
	values (60,14);
	
	
insert into turistaVuelo
	(turId,vueId,acomodacion)
	values (20,31,'comercial');
insert into turistaVuelo
	(turId,vueId,acomodacion)
	values (30,32,'comercial');
insert into turistaVuelo
	(turId,vueId,acomodacion)
	values (40,33,'comercial');
insert into turistaVuelo
	(turId,vueId,acomodacion)
	values (50,34,'comercial');
insert into turistaVuelo
	(turId,vueId,acomodacion)
	values (60,35,'comercial');
	
	
insert into turistaHoteles
	(turId,hotId,claseViaje)
	value (20,40,'Ejecutivo');
insert into turistaHoteles
	(turId,hotId,claseViaje)
	value (30,41,'Ejecutivo');
insert into turistaHoteles
	(turId,hotId,claseViaje)
	value (40,42,'Ejecutivo');
insert into turistaHoteles
	(turId,hotId,claseViaje)
	value (50,43,'Ejecutivo');
insert into turistaHoteles
	(turId,hotId,claseViaje)
	value (60,44,'Ejecutivo');
	
	select * from empresas;
	select * from sucursales;
	select * from turista;
	select * from vuelo;
	select * from hoteles;
	select * from turistaEmpresas;
	select * from turistaHoteles;
	select * from turistaVuelo;



SELECT turista.turapellidoss,turista.turDireccion
FROM  turista,empresas,turistaempresas
WHERE  turista.turId = turistaempresas.turId
AND
empresas.empId = turistaempresas.empId;



SELECT  turista.turapellidos, hoteles.hotNombre, turistahoteles.claseViaje
FROM turista,hoteles,turistahoteles
WHERE  turista.turId = turistahoteles.turId
AND
hoteles.hotId = turistahoteles.hotId; 




SELECT turista.turApellidos,  vuelo.vueDateTime, vuelo.vueSillasPrimeraClase, vuelo.vueDestino, vuelo.vueSillasClaseTurista, turistavuelo.fechaIngreso, turistavuelo.fechaSalida
FROM turista,vuelo, turistavuelo
WHERE  turista.turId  = turistavuelo.turId
AND
vuelo.vueId = turistavuelo.vueId;



SELECT  hotNombre, hotDireccion, hotCiudad
FROM hoteles 
WHERE  hotHabitacion  > 25;






ALTER TABLE agencias
ALTER COLUMN ageCiudad varchar (20);

