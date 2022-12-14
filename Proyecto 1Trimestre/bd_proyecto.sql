use bd_proyecto;


create table clientes(
	id int primary key auto_increment,
    nombre varchar(100) unique not null, 
	apellido1 varchar(100) not null, 
	apellido2 varchar(100) not null, 
    edad int 

    
);



create table pedidos(
	id int primary key auto_increment,
	nombre varchar(100) unique  not null, 
    precio int not null,
    cliente_id int not null,
    
    CONSTRAINT fk_pedidos_clientes 
		FOREIGN KEY (cliente_id)
		REFERENCES clientes(id)
        
);
  SELECT MIN(precio) AS PrecioMinimo  from pedidos;
  SELECT MIN(precio) FROM pedidos;
ALTER TABLE pedidos AUTO_INCREMENT=0;

select * from clientes;
select * from pedidos;


delete from pedidos;
drop table clientes, pedidos;
UPDATE clientes SET id = id - 1;
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE clientes AUTO_INCREMENT=0;
SET SQL_SAFE_UPDATES = 0;
ALTER TABLE clientes AUTO_INCREMENT=0;

