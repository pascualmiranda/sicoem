CREATE TABLE sicoem.cliente (
  id SERIAL  NOT NULL ,
  fecha TIMESTAMP   NOT NULL ,
  foto VARCHAR(150)    ,
  observaciones TEXT    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
  persona_id INTEGER   NOT NULL ,
  municipio_id INTEGER   NOT NULL ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(persona_id)
    REFERENCES sicoem.persona(id),
  FOREIGN KEY(municipio_id)
    REFERENCES sicoem.municipio(id));
