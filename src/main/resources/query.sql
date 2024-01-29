--DDL base de datos "Sistema de control de empeños", autor: Pascual Miranda Nnogales-------
CREATE SCHEMA IF NOT EXISTS sicoem;

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

CREATE TABLE sicoem.rol (
  id SERIAL  NOT NULL ,
  codigo VARCHAR(10) UNIQUE  NOT NULL ,
  descripcion VARCHAR(150)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));

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

CREATE TABLE sicoem.municipio (
  id SERIAL  NOT NULL ,
  codigo VARCHAR(6) UNIQUE  NOT NULL ,
  nombre VARCHAR(150)   NOT NULL ,
  codigodepto VARCHAR(2)      ,
PRIMARY KEY(id));

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

CREATE TABLE sicoem.historial (
  id SERIAL  NOT NULL ,
  nombre VARCHAR(150) NOT NULL ,
  descripcion TEXT    ,
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
  cliente_id INTEGER   NOT NULL ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(cliente_id)
    REFERENCES sicoem.cliente(id));

CREATE TABLE sicoem.medida (
  id SERIAL  NOT NULL ,
  codigo VARCHAR(5) UNIQUE NOT NULL ,
  nombre VARCHAR(150) ,
PRIMARY KEY(id));

CREATE TABLE sicoem.categoria (
  id SERIAL  NOT NULL ,
  nombre VARCHAR(150)   NOT NULL ,
  descripcion VARCHAR(250)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));

CREATE TABLE sicoem.garantia (
  id SERIAL  NOT NULL ,
  medida_id INTEGER   NOT NULL ,
  categoria_id INTEGER   NOT NULL ,
  cliente_id INTEGER   NOT NULL ,
  nombre VARCHAR(150)   NOT NULL ,
  descripcion VARCHAR(250)    ,
  fecha TIMESTAMP  DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL ,
  cantidad numeric(10,2)  DEFAULT 1 NOT NULL ,
  valor numeric(10,2)   NOT NULL ,
  condicion VARCHAR(50)   NOT NULL   ,
PRIMARY KEY(id)      ,
  FOREIGN KEY(cliente_id)
    REFERENCES sicoem.cliente(id),
  FOREIGN KEY(categoria_id)
    REFERENCES sicoem.categoria(id),
  FOREIGN KEY(medida_id)
    REFERENCES sicoem.medida(id));



CREATE TABLE sicoem.tipomovimiento (
  id SERIAL  NOT NULL ,
  nombres VARCHAR(50)   NOT NULL ,
  descripcion VARCHAR(250)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));


CREATE TABLE sicoem.capital (
  id SERIAL  NOT NULL ,
  interes numeric(5,2)   NOT NULL ,
  desde numeric(10,2)   NOT NULL ,
  hasta numeric(10,2)  NOT NULL ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id));

CREATE TABLE sicoem.interes (
  id SERIAL  NOT NULL ,
  capital_id INTEGER   NOT NULL ,
  interes numeric(5,2)   NOT NULL ,
  diadesde INTEGER   NOT NULL ,
  diahasta INTEGER   NOT NULL   ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(capital_id)
    REFERENCES sicoem.capital(id));


CREATE TABLE sicoem.bitacora (
  id SERIAL  NOT NULL ,
  usuario_id INTEGER   NOT NULL ,
  fecha TIMESTAMP  DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  operacion VARCHAR(50)   NOT NULL ,
  tabla VARCHAR(50)    ,
  registro_id INTEGER    ,
  referencia VARCHAR(150)    ,
  descripcion VARCHAR(250)      ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(usuario_id)
    REFERENCES sicoem.usuario(id));


CREATE TABLE sicoem.arqueo (
  id SERIAL  NOT NULL ,
  usuario_id INTEGER   NOT NULL ,
  fecha TIMESTAMP   NOT NULL ,
  saldo numeric(10,2)  DEFAULT 0 NOT NULL ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id)  ,
  FOREIGN KEY(usuario_id)
    REFERENCES sicoem.usuario(id));

CREATE TABLE sicoem.empeno (
  id SERIAL  NOT NULL ,
  capital_id INTEGER   NOT NULL ,
  cliente_id INTEGER   NOT NULL ,
  monto numeric(10,2)   NOT NULL ,
  fecha TIMESTAMP   NOT NULL ,
  observacion TEXT    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL ,
  fecha_plazo DATE   NOT NULL ,
  fecha_cierre TIMESTAMP      ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(cliente_id)
    REFERENCES sicoem.cliente(id),
  FOREIGN KEY(capital_id)
    REFERENCES sicoem.capital(id));


CREATE TABLE sicoem.movimiento (
  id SERIAL   NOT NULL ,
  empeno_id INTEGER    ,
  tiposmov_id INTEGER   NOT NULL ,
  fecha TIMESTAMP  DEFAULT CURRENT_TIMESTAMP NOT NULL ,
  cantidad numeric(10,2)  DEFAULT 0 NOT NULL ,
  referencia VARCHAR(150)    ,
  concepto VARCHAR(100)    ,
  descripcion VARCHAR(250)    ,
  tipo VARCHAR(50)    ,
  estado BOOLEAN  DEFAULT TRUE NOT NULL   ,
PRIMARY KEY(id)    ,
  FOREIGN KEY(tiposmov_id)
    REFERENCES sicoem.tipomovimiento(id),
  FOREIGN KEY(empeno_id)
    REFERENCES sicoem.empeno(id));
