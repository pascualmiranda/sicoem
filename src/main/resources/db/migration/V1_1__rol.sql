CREATE TABLE sicoem.rol (
  id SERIAL  NOT NULL ,
  codigo VARCHAR(10) UNIQUE  NOT NULL ,
  descripcion VARCHAR(150)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));