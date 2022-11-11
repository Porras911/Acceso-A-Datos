use bd_series;

create table series(
	id int primary key auto_increment,
    titulo varchar(100)unique not null,    
    edad int ,
    plataforma varchar(40),
    
    CONSTRAINT chk_edad CHECK (edad IN(0,7,12,16,18))
    
);
create table temporadas(
	id int primary key auto_increment,
    num_temporada int not null,
    titulo varchar(100)unique not null,
    serie_id int not null,
    
    CONSTRAINT fk_temporada_series 
		FOREIGN KEY (serie_id)
		REFERENCES series(id)
        
);

select * from series;
select * from temporadas;
delete from series;
delete from temporadas;
SET SQL_SAFE_UPDATES = 0;
