-- create database hibernate;

use hibernate;

create table clientes (
	id INT(5) UNIQUE AUTO_INCREMENT,
	DNI VARCHAR(9) PRIMARY KEY,
	nombre VARCHAR(255),
	telefono VARCHAR(255),
	direccion VARCHAR(255)
);

insert into clientes values (1, '70000000J', 'DaniBot', '500000000', 'Calle');
