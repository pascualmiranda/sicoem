CREATE TABLE sicoem.movimiento (
  id SERIAL   NOT NULL ,
  fecha TIMESTAMP  DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  cantidad numeric(10,2)  DEFAULT 0 NOT NULL ,
  referencia VARCHAR(150)    ,
  concepto VARCHAR(100)    ,
  descripcion VARCHAR(250)    ,
  tipo VARCHAR(50)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
  tipomov_id INTEGER   NOT NULL ,
  empeno_id INTEGER    ,
  --usuario_id INTEGER   NOT NULL ,
PRIMARY KEY(id),
  FOREIGN KEY(tipomov_id)
    REFERENCES sicoem.tipomovimiento(id),
  FOREIGN KEY(empeno_id)
    REFERENCES sicoem.empeno(id));
  --FOREIGN KEY(usuario_id)
      --REFERENCES sicoem.usuario(id));