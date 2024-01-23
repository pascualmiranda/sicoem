CREATE TABLE sicoem.medida (
  id SERIAL  NOT NULL ,
  codigo VARCHAR(5) UNIQUE NOT NULL ,
  nombre VARCHAR(150) ,
PRIMARY KEY(id));