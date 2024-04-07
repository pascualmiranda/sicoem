CREATE TABLE sicoem.tipomovimiento (
  id SERIAL  NOT NULL ,
  nombre VARCHAR(50)   NOT NULL ,
  descripcion VARCHAR(250)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));