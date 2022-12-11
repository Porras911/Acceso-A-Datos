use bd_proyecto;
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE clientes AUTO_INCREMENT=0;
create table clientes(
	id int primary key auto_increment,
    nombre varchar(100) unique not null, 
	apellido1 varchar(100) not null, 
	apellido2 varchar(100) not null, 
    edad int 

    
);
ALTER TABLE clientes AUTO_INCREMENT=0;

create table pedidos(
	id int primary key auto_increment,
	nombre varchar(100) unique  not null, 
    precio int not null,
    cliente_id int not null,
    
    CONSTRAINT fk_pedidos_clientes 
		FOREIGN KEY (cliente_id)
		REFERENCES clientes(id)
        
);

ALTER TABLE pedidos AUTO_INCREMENT=0;

select * from clientes;
delete from  clientes;
select * from pedidos;
delete from pedidos;
drop table clientes, pedidos;

