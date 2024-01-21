CREATE TABLE sicoem.municipio (
  id SERIAL  NOT NULL ,
  codigo VARCHAR(6) UNIQUE  NOT NULL ,
  nombre VARCHAR(150)   NOT NULL ,
  codigodepto VARCHAR(2)      ,
PRIMARY KEY(id));