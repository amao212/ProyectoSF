.database
.table


CREATE TABLE CLIENTE
(
	Id_Cliente					INTEGER 		PRIMARY KEY AUTOINCREMENT,
	Nombre_Cliente				VARCHAR(30)		NOT NULL,
	Apellido_Cliente			VARCHAR(30)		NOT NULL,
	Cedula_Cliente				VARCHAR(50)		NOT NULL,
	Direccion_Cliente			VARCHAR(50)			NULL,
	Correo_Cliente				VARCHAR(30)		NOT NULL,
	Estado_Cliente				VARCHAR(20)		NOT NULL,
	FechaIngreso_Cliente		DATETIME		NOT NULL,
	FechaMod_Cliente			DATETIME		NOT NULL
);

CREATE TABLE PRODUCTO_CATALOGO
(
	Id_ProductoCatalogo				INTEGER			PRIMARY KEY AUTOINCREMENT,
	Nombre_ProductoCatalogo			varchar(30)		NOT NULL,
	Costo_ProductoCatalogo			MONEY			NOT NULL,
	Estado_ProductoCatalogo			varchar(10)		NOT NULL,
	FechaIngre_ProductoCatalogo		DATETIME		NOT NULL
);

CREATE TABLE ROL
(	
	Id_Rol					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Id_RolPadre				VARCHAR(30)	NOT NULL,
	Nombre_Rol				VARCHAR(30)	NOT NULL,
	Estado_Rol				VARCHAR(10)	NOT NULL,
	FechaIngreso_Rol		DATETIME	NOT NULL,
	FechaModificacion_Rol	DATETIME	NOT NULL,
	FOREIGN KEY (Id_RolPadre)  REFERENCES ROL(Id_Rol)
);

CREATE TABLE USUARIO
(
	Id_Usuario					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Id_Rol						VARCHAR(30)	NOT NULL,
	Id_Empleado					VARCHAR(30)	NOT NULL,
	Estado_Usuario				VARCHAR(10)	NOT NULL,
	FechaIngreso_Usuario		DATETIME	NOT NULL,
	FechaModificacion_Usuario	DATETIME	NOT NULL
);

CREATE TABLE EMPLEADO
(
	Id_Empleado					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Id_Rol						VARCHAR(30)	NOT NULL,
	Nombre_Empleado				VARCHAR(30)	NOT NULL,
	Apellido_Empleado			VARCHAR(30)	NOT NULL,
	Cedula_Empleado				VARCHAR(20)	NOT NULL,
	Estado_Empleado				VARCHAR(10)	NOT NULL,
	FechaIngreso_Empleado		DATETIME	NOT NULL,
	FechaModificacion_Empleado	DATETIME	NOT NULL,
	FOREIGN KEY (Id_Rol)  REFERENCES ROL(Id_Rol)
);

CREATE TABLE CREDENCIAL
(
	Id_Credencial					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Usuario_Credencial				VARCHAR(30)	NOT NULL UNIQUE,
	Password_Credencial				VARCHAR(30)	NOT NULL,
	Estado_Credencial				VARCHAR(10)	NOT NULL,
	FechaIngreso_Credencial			DATETIME	NOT NULL,
	FechaModificacion_Credencial	DATETIME	NOT NULL
);

CREATE TABLE REGISTRO_INGRESO
(
	Id_Registro				INTEGER		PRIMARY KEY AUTOINCREMENT,
	Id_Credenciales			VARCHAR(30)	NOT NULL,
	FechaIngreso_Registro	DATETIME	NOT NULL,
	Estado_Registro			VARCHAR(10)	NOT NULL,
	FOREIGN KEY (Id_Credenciales)  REFERENCES CREDENCIAL(Id_Credencial)
);

CREATE TABLE INVENTARIO
(
	Id_Inventario					INTEGER		PRIMARY KEY AUTOINCREMENT,
	Id_ProductoCatalogo				VARCHAR(30)	NOT NULL,
	Cantidad_Inventario				INTEGER		NOT NULL,
	Estado_Inventario				VARCHAR(10)	NOT NULL,
	FechaIngreso_Inventario			DATETIME	NOT NULL,
	FechaModificacion_Inventario	DATETIME	NOT NULL,
	FOREIGN KEY (Id_ProductoCatalogo)  REFERENCES PRODUCTO_CATALOGO(Id_ProductoCatalogo)
);

CREATE TABLE PRODUCTOS_CATALOGO
(
	Id_ProducCatalo			  INTEGER		PRIMARY KEY AUTOINCREMENT,
	Nombre_ProducCatalo		  VARCHAR(30)	NOT NULL,
	Costo_ProducCatalo		  MONEY 		NOT NULL,
	Estado_ProducCatalo		  VARCHAR(10)	NOT NULL,
	FechaIngreso_ProducCatalo DATETIME		NOT NULL
);

CREATE TABLE DETALLE_FACTURA
(
	Id_DetalleFactura			INTEGER		PRIMARY KEY AUTOINCREMENT,
	Id_ProductoCatalogo			VARCHAR(30)	NOT NULL,
	Cantidad_Factura			INTEGER		NOT NULL,
	Estado_Factura				VARCHAR(10)	NOT NULL,
	FechaIngreso_Factura		DATETIME	NOT NULL,
	FechaModificacion_Factura	DATETIME	NOT NULL,
	FOREIGN KEY (Id_ProductoCatalogo)  REFERENCES PRODUCTO_CATALOGO(Id_ProductoCatalogo)
);

CREATE TABLE FACTURA
(
	Id_Factura			INTEGER		PRIMARY KEY AUTOINCREMENT,
	Id_DetalleFactura	VARCHAR(30)	NOT NULL,
	Id_Empleado			VARCHAR(30)	NOT NULL,
	Id_Cliente			VARCHAR(30)	NOT NULL,
	Id_FormaPago		VARCHAR(30)	NOT NULL,
	Total_Factura		MONEY		NOT NULL,
	FOREIGN KEY (Id_DetalleFactura)  REFERENCES DETALLE_FACTURA(Id_DetalleFactura),
	FOREIGN KEY (Id_Empleado)  REFERENCES EMPLEADO(Id_Empleado),
	FOREIGN KEY (Id_Cliente)  REFERENCES CLIENTE(Id_Cliente),
	FOREIGN KEY (Id_FormaPago)  REFERENCES FORMA_DE_PAGO(Id_FormaPago)
);

CREATE TABLE FORMA_DE_PAGO
(
	Id_FormaPago	INTEGER			PRIMARY KEY AUTOINCREMENT,
	Nombre			VARCHAR(30)		NOT NULL,
	Estado			VARCHAR(10)		NOT NULL
);
