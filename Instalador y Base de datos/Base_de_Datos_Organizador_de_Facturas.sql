#Creacion de la base de datos para la ORGANIZADOR DE FACTURAS
create database Organizador_Facturas;
use Organizador_Facturas;

#CREAMOS LAS TABLAS DE LA BASE DE DATOS-------------------

-- Tabla Proveedor
Create table Proveedor (
	RUC_Proveedor Varchar(13) NOT NULL,
	Nombre_Proveedor Text NOT NULL,
	Direccion Text NOT NULL,
	Telefono varchar(10) ,
 Primary Key (RUC_Proveedor)) ENGINE = MyISAM;
-- Tabla Comprador
Create table Comprador (
	RUCoCI_Comprador Varchar(13) NOT NULL,
	Nombre_Comprador Text NOT NULL,
    Contraseña Text NOT NULL,
    Cod_Pregunta int NOT NULL,
    Respuesta Text NOT NULL,
 Primary Key (RUCoCI_Comprador)) ENGINE = MyISAM;
  -- Tabla Preguntas
Create table Preguntas(
	Cod_Pregunta int NOT NULL AUTO_INCREMENT,
	Pregunta text NOT NULL,
 Primary Key (Cod_Pregunta)) ENGINE = MyISAM;
 -- Tabla Tipo_Gasto
Create table Tipo_Gasto(
	Cod_Tipo_Gasto int NOT NULL AUTO_INCREMENT,
	Nombre_Tipo_Gasto text NOT NULL,
 Primary Key (Cod_Tipo_Gasto)) ENGINE = MyISAM;

-- Tabla Factura
Create table Factura (
	Cod_Factura Varchar(17) NOT NULL,
	Fecha_Factura date NOT NULL,
    Valor_Sin_IVA double NOT NULL,
    IVA float NOT NULL,
    Valor_Con_IVA double NOT NULL,
    RUC_Proveedor Varchar(13) NOT NULL,
    RUCoCI_Comprador Varchar(13) NOT NULL,
 Primary Key (Cod_Factura,RUC_Proveedor)) ENGINE = MyISAM;
 
 -- Tabla Detalle_Factura--
Create table Detalle_Factura (
	Cod_Factura Varchar(17) NOT NULL,
    RUC_Proveedor Varchar(13) NOT NULL,
    Cod_Tipo_Gasto int NOT NULL,
    Valor_Sin_IVA double NOT NULL,
    IVA float NOT NULL,
    Valor_Con_IVA double NOT NULL,
 Primary Key (Cod_Tipo_Gasto,Cod_Factura,RUC_Proveedor)) ENGINE = MyISAM;
 
 -- Tabla limite_gasto
 Create table limite_gasto (
	Año Varchar(4) NOT NULL,
    Valor_Vivienda double NOT NULL,
    Valor_Educacion double NOT NULL,
    Valor_Salud double NOT NULL,
    Valor_Vestido double NOT NULL,
    Valor_Alimentacion double NOT NULL,
    Valor_Negocio double NOT NULL,
    Valor_Otro double NOT NULL,
    Valor_Total_Año double NOT NULL,
 Primary Key (Año)) ENGINE = MyISAM;
 
 -- /////////////////////////////////////////////////////// --
 -- Dependencia Foreign Key
  Alter table Comprador add Foreign Key (Cod_Pregunta) 
 references Preguntas (Cod_Pregunta) on delete  restrict on update restrict;
 Alter table Factura add Foreign Key (RUC_Proveedor) 
 references Proveedor (RUC_Proveedor) on delete  restrict on update restrict;
 Alter table Factura add Foreign Key (RUCoCI_Comprador) 
 references Comprador (RUCoCI_Comprador) on delete  restrict on update restrict;
 Alter table Detalle_Factura add Foreign Key (Cod_Tipo_Gasto) 
 references Tipo_Gasto (Cod_Tipo_Gasto) on delete  restrict on update restrict;
  Alter table Detalle_Factura add Foreign Key (Cod_Factura,RUC_Proveedor) 
 references Factura (Cod_Factura,RUC_Proveedor) on delete  restrict on update restrict;
 
 -- ---------------------- INGRESAR  DATOS
 insert into Comprador values('1723012553','Administrador','12345','1','3');
 
 insert into limite_gasto values('2010',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
 insert into limite_gasto values('2011',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
 insert into limite_gasto values('2012',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
 insert into limite_gasto values('2013',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
 insert into limite_gasto values('2014',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
 insert into limite_gasto values('2015',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
 insert into limite_gasto values('2016',0.0,0.0,0.0,0.0,0.0,0.0,0.0,0.0);
 
 insert into Preguntas(Pregunta) values('Numero de Hijos');
 insert into Preguntas(Pregunta) values('Numero de hermanos(as)');
 insert into Preguntas(Pregunta) values('Primer nombre de la Madre');
 insert into Preguntas(Pregunta) values('Primer nombre del Padre');
 insert into Preguntas(Pregunta) values('Nombre de su mascota');
 insert into Preguntas(Pregunta) values('Nombre de su artista favorito');
 insert into Preguntas(Pregunta) values('Nombre de su plato favorito');
 insert into Preguntas(Pregunta) values('Nombre de su color favorito');
 
 insert into Tipo_Gasto(Nombre_Tipo_Gasto) values ('Vivienda');
 insert into Tipo_Gasto(Nombre_Tipo_Gasto) values ('Educación');
 insert into Tipo_Gasto(Nombre_Tipo_Gasto) values ('Salud');
 insert into Tipo_Gasto(Nombre_Tipo_Gasto) values ('Vestido');
 insert into Tipo_Gasto(Nombre_Tipo_Gasto) values ('Alimentación');
 insert into Tipo_Gasto(Nombre_Tipo_Gasto) values ('Negocio');
 insert into Tipo_Gasto(Nombre_Tipo_Gasto) values ('Otro');
 
 
 select  *from proveedor;
 select *from comprador;
 select *from factura;
 select *From detalle_factura;
 select *from tipo_gasto;
 select *from preguntas;
 select *from limite_gasto;
 
 
 select SUM(Detalle_Factura.Valor_Con_IVA) from Detalle_Factura, Factura 
 where Cod_Tipo_Gasto='1' and Detalle_Factura.Cod_Factura=Factura.Cod_Factura 
 and Detalle_Factura.RUC_Proveedor=Factura.RUC_Proveedor 
 and Factura.Fecha_Factura  BETWEEN '2017-01-01'  AND '2017-12-31' ;