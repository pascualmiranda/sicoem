CREATE TABLE sicoem.interes (
  id SERIAL  NOT NULL ,
  interes numeric(5,2)   NOT NULL ,
  diadesde INTEGER   NOT NULL ,
  diahasta INTEGER   NOT NULL   ,
  capital_id INTEGER   NOT NULL ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(capital_id)
    REFERENCES sicoem.capital(id));