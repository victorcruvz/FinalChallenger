create table jugadores(

    id bigint not null auto_increment,
    nombre varchar(100) not null,
    email varchar(100) not null unique,
    fechaNacimiento varchar(20) not null,
    rango varchar(100) not null,
    fechaCreacion varchar(100) not null,
    equipo varchar(100),
    region varchar(100) not null,

    primary key(id)

);
