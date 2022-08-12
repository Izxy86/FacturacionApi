CREATE TABLE EMPRESA (id bigint NOT NULL auto_increment, nombre varchar(150), rubro varchar(150), PRIMARY KEY (id));

insert into EMPRESA(nombre,rubro) values ('ReDragon','Insumos informáticos');

CREATE TABLE CLIENTE (id bigint NOT NULL auto_increment, nombre varchar(150) not null, apellido varchar (150) not null,
                        dni varchar(150) not null, direccion varchar(150) not null, email varchar(150) not null, primary key (id));


insert into CLIENTE (nombre, apellido, dni, direccion, email) values

('Andres','Zamorano','30.654.798','Calle falsa 123','aZamorano@gmail.com'),
('Alejandra', 'López', '33.019.497','Calllao 820','aleLopez@hotmail.com'),
('Maximiliano', ' Garoglio', '32.467.123','CuchaCucha 324', 'MaxiG@gmail.com'),
('Andrea', 'Aphalo','33.198.467','Cangallo 90','andyA@gmail.com'),
('Luna', 'Chen','93.467.888','China 15','lunaChen@hotmail.com');


CREATE TABLE PRODUCTOS (id bigint not null auto_increment, nombre varchar(150) not null, descripcion varchar(150) not null,
                        precio int not null, Cantidad_en_Stock int not null, primary key (id));


insert into PRODUCTOS (nombre,descripcion,precio,Cantidad_en_Stock) values

('SHRAPNEL K589','teclado RGB mecánico low profile de pura cepa, con una altura total de sólo 12 mm. Su cara superior es de aluminio cepillado',8399,50),
('DARKNETS GS570','barra de sonido Redragon:Darknet GS570. Su elegante estructura compacta y súper transportable con retroiluminación LED RGB',6521,25),
('DEVASTATOR GC550','Como todos los gabinetes Redragon,el Devastator está diseñado cuidadosamentepara permitir un manejo de cables prolijo',14949,10),
('EFFECT X CPU COOLER CCW3000','Refrigeración líquida de alto rendimiento',32999,15),
('CENTROPHORUS RGB M601RGB','El Centrophorus RGB es uno de los ratones de mejor rendimiento, con la mejor relaciónprecio-calidad',2699,50),
('HITMAN GW800','webcam diseñada específicamente para el streaming',8950,20),
('RGPS DE 600W',' fuente de alimentación con una alta eficiencia energética',10999,25),
('RUBY 144/165 HZ','Monitor gamer con alta tasa de refresco', 78000,5),
('K551RGB-BA', 'Combo teclado mecanico y mouse retroiluminado RGB', 25000,15),
('CAPRICORNUS C502','Silla gamer ergonomica con apoyabrazos y soporte máximo de 150Kg',56359,5);