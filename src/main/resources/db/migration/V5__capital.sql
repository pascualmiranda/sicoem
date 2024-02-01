CREATE TABLE sicoem.capital (
  id SERIAL  NOT NULL ,
  interes numeric(5,2)   NOT NULL ,
  desde numeric(10,2)   NOT NULL ,
  hasta numeric(10,2)  NOT NULL ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));