INSERT INTO sicoem.rol(codigo, descripcion)
VALUES ('admin','Administrador del sistema')
     ,('super','Supervisor de la sucursal')
     ,('caja','Cajero de sucursal');

INSERT INTO sicoem.persona(ci, nombre, primerapellido, genero)
VALUES ('admin','Administrador', 'Administrador','M');

INSERT INTO sicoem.usuario(login, clave, persona_id, rol_id)
VALUES ('admin', '$2y$10$8kpHYCLsN0J4DkY0h1wzLufaNvOHQMIn9CPUMFh7qHGrsgUIsKIAy', 1, 1);
