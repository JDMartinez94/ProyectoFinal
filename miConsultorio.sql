create database miConsultorio; 
use miConsultorio; 

create table pacientes
(
	idPaciente int not null primary key auto_increment,
    nombresPaciente varchar(50), 
    apellidosPaciente varchar(50),
    fechaNacPaciente date, 
    telPaciente varchar(16),
    emailPaciente varchar(35),
    direccionPaciente varchar(100),
    nombreemergPaciente varchar(50),
    telemergPaciente varchar(16)
);

create table empleados
(
	idEmpleado int not null primary key auto_increment,
    nombreEmpleado varchar(50),
    direccionEmpleado varchar(100),
    telEmpleado varchar(16)
);

create table usuarios
(
	idUsuario int not null primary key auto_increment,
    nombreUsuario varchar (40),
    tipoUsuario varchar (15),
    idEmpleado int,
    foreign key (idEmpleado) references empleados(idEmpleado)
);

create table citas
(
	idCita int not null primary key auto_increment,
    idPaciente int,
    fechaCita date,
    horaCita time,
    statusCita varchar(15),
    idUsuario int,
    foreign key (idPaciente) references pacientes(idPaciente),
    foreign key (idUsuario) references usuarios(idUsuario)
);

create table registro_consultas
(
	idregConsulta int not null primary key auto_increment,
    idCita int,
    diagnosticoConsulta varchar(85),
    idUsuario int, 
    foreign key (idUsuario) references usuarios(idUsuario),
    foreign key (idCita) references citas(idCita)
);

create table recetas_medicas
(
	idregReceta int not null primary key auto_increment,
    idregConsulta int, 
    nombreMedicina varchar(75),
    indicaciones varchar(120),
    foreign key (idregConsulta) references registro_consultas(idregConsulta)
);

create table incapacidades
(
	idInca int not null primary key auto_increment,
    idregConsulta int,
    finalInca date,
    foreign key (idregConsulta) references registro_consultas(idregConsulta)
);

create table referencias_medicas
(
	idReferencia int not null primary key auto_increment,
    idregConsulta int, 
    motivoRef varchar(75),
	ReferidoA varchar(85),
    foreign key (idregConsulta) references registro_consultas(idregConsulta)
);

create table ordenes_examenes
(
	idOrden int not null primary key auto_increment,
    idregConsulta int, 
    examen varchar(35),
    foreign key (idregConsulta) references registro_consultas(idregConsulta)
);

create table alergias_medicamentos
(
	idAlergia int not null primary key auto_increment, 
    idPaciente int,
    alergia_a_med varchar(50),
    foreign key (idPaciente) references pacientes(idPaciente)
);

create table enfermedades_hereditarias
(
	idEnfermedadH int not null primary key auto_increment,
    idPaciente int,
    enfermedadH varchar (50),
    foreign key (idPaciente) references pacientes(idPaciente)
);

create table operaciones
(
	idOperacion int not null primary key auto_increment,
    idPaciente int,
    operacion varchar (50),
    anioOper year,
    foreign key (idPaciente) references pacientes(idPaciente)
);

insert into pacientes values
(1, 'Pedro', 'Ramirez','1988-02-15', '(503)2222-2222', 'pedro@email.com', '123 Calle Itca, S.S., ES', 'Josue Hernandez', '(503)3333-3333'),
(2, 'Maria', 'Juarez','2003-06-02', '(503)4444-4444', 'maria@email.com', '456 Calle Itca, S.S., ES', 'Andrea Galvez', '(503)5555-5555'),
(3, 'Juan', 'Perez','1970-07-23', '(503)6666-6666', 'juan@email.com', '789 Calle Itca, S.S., ES', 'Alcidez Medina', '(503)7777-7777'),
(4, 'Beatriz', 'Pinzon','2010-01-01', '(503)8888-8888', 'beatriz@email.com', '321 Calle Itca, S.S., ES', 'Diana Castillo', '9999-9999');

insert into empleados values
(1,'Dr. Manuel Hernandez', '123 Avenida Medica, S.S., ES', '(503)1234-5678'),
(2,'Dra. Carla Selva', '456 Avenida Medica, S.S., ES', '(503)7890-3214'),
(3,'Margarita Montalvo', '789 Avenida Medica, S.S., ES', '(503)5522-6633'),
(4,'Eugenio Cangrejo', '951 Avenida Medica, S.S., ES', '(503)8855-9966'),
(5,'Morgan Freeman', '123 Main St, CA, US', '(888)999-2592');

insert into usuarios values
(1, 'mmontalvo', 'secretaria', 3),
(2, 'cselva', 'doctor', 2),
(3, 'mhernandez', 'doctor', 1),
(4, 'ecangrejo', 'secretaria', 4),
(5, 'mfreeman', 'admin', 5);

insert into citas values
(1, 1, '2020-05-15', '08:00:00', 'Cancelada', 1),
(2, 2, '2020-07-01', '10:30:00', 'Completada', 4),
(3, 3, '2020-08-22', '11:00:00', 'Completada', 1),
(4, 4, '2020-09-07', '14:00:00', 'Completada', 4),
(5, 1, '2020-10-23', '09:30:00', 'Pendiente', 1);

insert into registro_consultas values
(1,2,'Gripe',2),
(2,3,'Diabetes',3),
(3,4,'Migraña',3);

insert into recetas_medicas values
(1,1,'Ibuprofeno','1 c/8 hrs x 7 dias'),
(2,1,'Loratadina','1 c/8 hrs x 5 dias'),
(3,1,'Levofloxacin','1 c/12 hrs x 5 dias'),
(4,2,'Biguanida','1 c/12 hrs x 2 dias'),
(5,2,'Sulfonilureas','1 c/48 hrs x 2 meses'),
(6,2,'Meglitinidas','1 c/48 hrs x 2 meses'),
(7,3,'Propranolol ','1 c/8 hrs x 5 dias'),
(8,3,'Toxina botulinica','1 inyeccion');

insert into incapacidades values
(1,3,'2020-09-10');

insert into referencias_medicas values
(1,1, 'Alergias', 'Dr. Armando Lopez - Alergista'),
(2,3, 'Migrañas Frecuentes', 'Dra. Camila Mena - Neurologia');

insert into ordenes_examenes values
(1,2,'Trigliceridos y Tiroides');

insert into alergias_medicamentos values
(1,1,'Acetominofen'),
(2,2,'Ninguna'),
(3,3,'Loratadina'),
(4,4,'Penicilina'),
(5,4,'Ranitidina'),
(6,3,'Clorfeniramina');

insert into enfermedades_hereditarias values
(1,1,'Hipertension'),
(2,2,'Miopia'),
(3,3,'Diabetes');

insert into operaciones values 
(1,3,'Calculos','1990'),
(2,2,'Apendicitis','2013'),
(3,3,'Apendicitis','2005'),
(4,4,'Extraccion de molares','2018');









