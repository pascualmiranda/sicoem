CREATE TABLE sicoem.empeno (
  id SERIAL  NOT NULL ,
  monto numeric(10,2)   NOT NULL ,
  fecha TIMESTAMP  DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  observacion TEXT    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL ,
  fecha_plazo DATE   NOT NULL ,
  fecha_cierre TIMESTAMP      ,
  capital_id INTEGER   NOT NULL ,
  cliente_id INTEGER   NOT NULL ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(cliente_id)
    REFERENCES sicoem.cliente(id),
  FOREIGN KEY(capital_id)
    REFERENCES sicoem.capital(id));
