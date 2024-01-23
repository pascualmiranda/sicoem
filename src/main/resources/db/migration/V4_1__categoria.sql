CREATE TABLE sicoem.categoria (
  id SERIAL  NOT NULL ,
  nombre VARCHAR(150) NOT NULL ,
  descripcion VARCHAR(250)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));