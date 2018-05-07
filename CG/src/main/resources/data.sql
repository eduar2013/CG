--categorias
INSERT INTO categories(id,name) values (1,'casa');
INSERT INTO categories(id,name) values (2,'auto');
INSERT INTO categories(id,name) values (3,'creditos');
INSERT INTO categories(id,name) values (4,'recreacion');
INSERT INTO categories(id,name) values (5,'educacion');




--subcategorias
INSERT INTO subcategorias(id,name,default_price,category_id) values (1,'mercado',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (2,'credito',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (3,'tigo',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (4,'une',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (5,'ahorro',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (6,'servicios epm',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (7,'cine',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (8,'gasolina',0,1);
INSERT INTO subcategorias(id,name,default_price,category_id) values (9,'seguro',0,1);

--productos
INSERT INTO productos(id,name) values (1,'arroz');
INSERT INTO productos(id,name) values (2,'maiz');
INSERT INTO productos(id,name) values (3,'banano');
INSERT INTO productos(id,name) values (4,'ancas');
INSERT INTO productos(id,name) values (5,'mazamorra');
INSERT INTO productos(id,name) values (6,'miel');
INSERT INTO productos(id,name) values (7,'areapas');

--egresos

INSERT INTO egresos(id,subcategoria_id,fecha_egreso,cantidad,valor) values(1,1,to_date('19/04/2018','dd/mm/yyyy'),1,5000);


