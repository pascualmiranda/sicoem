CREATE TABLE sicoem.historial (
  id SERIAL  NOT NULL,
  nombre VARCHAR(150) NOT NULL,
  descripcion TEXT,
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  estado BOOLEAN DEFAULT TRUE NOT NULL,
  cliente_id INTEGER NOT NULL,
PRIMARY KEY(id),
  FOREIGN KEY(cliente_id)
    REFERENCES sicoem.cliente(id));