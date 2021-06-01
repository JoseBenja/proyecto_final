CREATE TABLE DISPOSITIVO (
    id_Disp     NUMBER GENERATED BY DEFAULT AS IDENTITY,
    tipo        VARCHAR2(20),
    email       VARCHAR2(50),
    nombre      VARCHAR2(50),
    visible_    NUMBER(1),
    estatus     NUMBER(1),
    numero_Telefono     NUMBER(16),
    disp_Asociado       VARCHAR2(50),
    PRIMARY KEY(id_Disp)
);

CREATE TABLE USUARIO (
    id_Usuario	NUMBER GENERATED BY DEFAULT AS IDENTITY,
    nombre	VARCHAR2(50),
    apellido	VARCHAR2(50),
    email	VARCHAR2(50),
    contrasenia	VARCHAR2(50),
    PRIMARY KEY(id_Usuario)
);

CREATE TABLE ADMINISTRACION (
	id_Admin 	NUMBER GENERATED BY DEFAULT AS IDENTITY,
	tipo_Disp	VARCHAR2(20),
	nombre_Disp	VARCHAR2(50),
	campo_Editar	VARCHAR2(50),
	nuevo_Valor	VARCHAR2(50),
	PRIMARY KEY(id_Admin)
);

CREATE TABLE ACCION (
	id_Accion	NUMBER GENERATED BY DEFAULT AS IDENTITY,
	tipo_Disp	VARCHAR2(20),
	nombre_Disp	VARCHAR2(50),
	tipo_Accion	VARCHAR2(50),
	destino_Disp	VARCHAR2(50),
	PRIMARY KEY(id_Accion)
);

CREATE TABLE ACCION_EXTERNA (
	id_Accion_Externa 	NUMBER GENERATED BY DEFAULT AS IDENTITY,
	tipo_Accion_Externa	VARCHAR2(50),
	numero_Telefono		NUMBER(16),
	nombre_Disp		VARCHAR2(50),
	tipo_Accion		VARCHAR2(50),
	texto_Mensaje		VARCHAR2(200),
	nombre_App		VARCHAR2(50),
	emisor_Disp		VARCHAR2(50),
	PRIMARY KEY(id_Accion_Externa)
);

CREATE TABLE NOTIFICACION (
	id_Notificacion		NUMBER GENERATED BY DEFAULT AS IDENTITY,
	tipo_Notificacion	VARCHAR2(50),
	nombre_Disp		VARCHAR2(50),
	asunto_Correo		VARCHAR2(50),
	nombre_Evento		VARCHAR2(50),
	fecha_Evento		VARCHAR2(20),
	hora_Evento		VARCHAR2(20),
	PRIMARY KEY(id_Notificacion)
);

CREATE TABLE LOG (
	id_Log		NUMBER GENERATED BY DEFAULT AS IDENTITY,
	tipo_Accion	VARCHAR2(50),
	origen_Accion	VARCHAR2(50),
	descripcion	VARCHAR2(200),
	fecha		VARCHAR2(20),
	hora		VARCHAR2(20),
	PRIMARY KEY(id_Log)
);