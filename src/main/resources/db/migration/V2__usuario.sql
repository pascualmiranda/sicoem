CREATE TABLE sicoem.usuario (
  id SERIAL  NOT NULL ,
  login VARCHAR(50)   NOT NULL ,
  clave VARCHAR(150)   NOT NULL ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
  persona_id INTEGER   NOT NULL ,
  rol_id INTEGER   NOT NULL ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(persona_id)
    REFERENCES sicoem.persona(id),
  FOREIGN KEY(rol_id)
    REFERENCES sicoem.rol(id));
