CREATE TABLE sicoem.garantia (
  id SERIAL  NOT NULL,
  nombre VARCHAR(150) NOT NULL,
  descripcion VARCHAR(250),
  cantidad numeric(10,2) DEFAULT 1 NOT NULL,
  valor numeric(10,2) NOT NULL,
  condicion VARCHAR(50) NOT NULL,
  fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  estado BOOLEAN DEFAULT TRUE NOT NULL,
  medida_id INTEGER NOT NULL,
  categoria_id INTEGER NOT NULL,
  cliente_id INTEGER NOT NULL,
PRIMARY KEY(id),
    FOREIGN KEY(medida_id)
        REFERENCES sicoem.medida(id),
    FOREIGN KEY(categoria_id)
        REFERENCES sicoem.categoria(id),
    FOREIGN KEY(cliente_id)
        REFERENCES sicoem.cliente(id));