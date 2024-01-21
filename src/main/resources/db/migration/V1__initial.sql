CREATE TYPE sicoem.identidad AS ENUM('M','F');
CREATE TABLE sicoem.persona (
  id SERIAL   NOT NULL ,
  ci VARCHAR(20) UNIQUE NOT NULL ,
  nombre VARCHAR(50)   NOT NULL ,
  primerapellido VARCHAR(50)   NOT NULL ,
  segundoapellido VARCHAR(50)    ,
  genero sicoem.identidad   NOT NULL ,
  direccion VARCHAR(150)    ,
  telefono VARCHAR(50)    ,
  email VARCHAR(150)      ,
  PRIMARY KEY(id),
  UNIQUE(ci)
);
