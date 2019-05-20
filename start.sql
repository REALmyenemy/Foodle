create database if not exists foodle;
use foodle;
drop table if exists respuestas;
drop table if exists preguntas;
drop table if exists examenes;
drop table if exists materias;
drop table if exists alumnos;
drop table if exists profesores;
drop table if exists usuarios;

/* Si no se asigna el usuario, el profesor/alumno está registrado, pero no activo. Se usan los datos de "usuario" para todo tipo de login*/
create table usuarios
(
	id varchar(15) primary key,
	password varchar(90) not null,
	nombre varchar(40),
	descripcion varchar(120),
	last_seen datetime	
);

create table profesores
(
	id integer primary key auto_increment,
	usuario varchar(15),	
	constraint fk_pro_usu foreign key (usuario) references usuarios (id) on delete cascade
);

create table alumnos
(
	id integer primary key auto_increment,
	usuario varchar(15),
	edad integer,
	curso varchar(6),
	constraint fk_alu_usu foreign key (usuario) references usuarios (id) on delete cascade
);

create table materias
(
	id varchar(8) primary key,
	nombre varchar(30) not null,
	creador integer not null,
	constraint foreign key fk_mat_prof (creador) references profesores (id) on delete cascade
);
create table examenes
(
	id integer auto_increment primary key,
	materia varchar(8) not null references materias (id) on delete cascade
);


create table preguntas
(
	id integer primary key,
	examen integer references examenes (id),
	pregunta varchar(120),
	dirImagen varchar(120),
	totalRespuestas integer
);

create table respuestas
(
	id integer,
	pregunta integer references preguntas (id),
	texto varchar(120),
	valorSelect float,
	valornoSelect float
)

/* Comprobaciones, agregaciones adicionales, como crear profesor agrega usuario, despues profesor, hashear la contraseña, etcétera... lástima que vaya tan mal en mysql */
/*

delimiter ;

create or replace trigger num_respuestas
after insert or update 
on respuestas
declare
	cursor preg is select id from preguntas,
	cont integer;
begin
	for pregunta in preg loop
		cont:=0;
		select count(*) from respuestas r where r.pregunta=pregunta.id;
		update preguntas set totalRespuestas=cont;
	end loop;
end;



*/
insert into usuarios values('profe1','profe1','Profesor 1','',now());
insert into usuarios values('profe2','profe2','Profesor 2','',now());
insert into usuarios values('profe3','profe3','Profesor 3','',now());
insert into usuarios values('profe4','profe4','Profesor 4','',now());
insert into usuarios values('profe5','profe5','Profesor 5','',now());
insert into usuarios values('alum1','alum1','Alumno 1','',now());
insert into usuarios values('alum2','alum2','Alumno 2','',now());
insert into usuarios values('alum3','alum3','Alumno 3','',now());
insert into usuarios values('alum4','alum4','Alumno 4','',now());
insert into usuarios values('alum5','alum5','Alumno 5','',now());
insert into usuarios values('alum6','alum6','Alumno 6','',now());
insert into profesores values(0,'profe1');
insert into profesores values(0,'profe2');
insert into profesores values(0,'profe3');
insert into profesores values(0,'profe4');
insert into profesores values(0,'profe5');
insert into alumnos values(0,'alum1',10,'3EPO');
insert into alumnos values(0,'alum2',20,'2Bach');
insert into alumnos values(0,'alum3',30,'1SMR');
insert into alumnos values(0,'alum4',40,'2DAW');
insert into alumnos values(0,'alum5',50,'1SMP');
insert into alumnos values(0,'alum6',60,'2JyF');
