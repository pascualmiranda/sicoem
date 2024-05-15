INSERT INTO sicoem.rol(codigo, descripcion)
VALUES ('ADMIN','Administrador del sistema')
     ,('SUPER','Responsable de la sucursal')
     ,('CAJA','Cajero de sucursal');

INSERT INTO sicoem.persona(ci, nombre, primerapellido, genero)
VALUES ('admin','Administrador', 'Administrador','M');

INSERT INTO sicoem.usuario(login, clave, persona_id, rol_id)
VALUES ('admin', '$2y$10$8kpHYCLsN0J4DkY0h1wzLufaNvOHQMIn9CPUMFh7qHGrsgUIsKIAy', 1, 1);

insert into sicoem.categoria(nombre,descripcion)
values('Inmueble','Bienes inmuebles'),('Electrodoméstico','Aparatos electrodomésticos')
     ,('Joya','Objetos de joyería'),('Vehículos','Vehiculos de 4 ruedas')
     ,('Motocicletas','Motocicletas'),('Bicicletas','Bicicletas')
     ,('Otros','Otros objetos de valor');

insert into sicoem.medida (codigo,nombre) values('ud','Unidad'),('kg','Kilogramos')
                                               ,('gr','Gramos'),('qte','Quilate');

insert into sicoem.tipomovimiento (nombre) values('Préstamo'),('Capitalización'),('Amortización')
                                                ,('Pago'),('Liquidación'),('Aumento'),('Otro');

insert into sicoem.capital (interes,desde,hasta) values (5,1,50)
                                                      ,(4,51,1000),(3,1001,10000);

insert into sicoem.interes (interes,diadesde,diahasta,capital_id) values
                                                                      (1, 0, 3, 1),
                                                                      (1.5, 4, 6, 1),
                                                                      (2, 7, 9, 1),
                                                                      (2.25, 10, 12, 1),
                                                                      (2.5, 13, 15, 1),
                                                                      (3, 16, 18, 1),
                                                                      (3.5, 19, 21, 1),
                                                                      (4, 22, 24, 1),
                                                                      (4.5, 25, 27, 1),
                                                                      (5, 28, 30, 1),
                                                                      (0.5, 0, 3, 2),
                                                                      (0.8, 4, 6, 2),
                                                                      (1.2, 7, 9, 2),
                                                                      (1.6, 10, 12, 2),
                                                                      (2, 13, 15, 2),
                                                                      (2.4, 16, 18,2),
                                                                      (2.8, 19, 21, 2),
                                                                      (3.2, 22, 24, 2),
                                                                      (3.6, 25, 27, 2),
                                                                      (4, 28, 30, 2),
                                                                      (0.5, 0, 3, 3),
                                                                      (0.6, 4, 6, 3),
                                                                      (0.9, 7, 9, 3),
                                                                      (1.2, 10, 12, 3),
                                                                      (1.5, 13, 15, 3),
                                                                      (1.8, 16, 18, 3),
                                                                      (2.1, 19, 21, 3),
                                                                      (2.4, 22, 24, 3),
                                                                      (2.7, 25, 27, 3),
                                                                      (3, 28, 30, 3);


insert into sicoem.municipio (codigo,nombre,codigodepto) values
                                                             ('070101', 'Santa Cruz de la Sierra', '07'),
                                                             ('070102', 'Cotoca', '07'),
                                                             ('070103', 'Ayacucho - Porongo', '07'),
                                                             ('070104', 'La Guardia', '07'),
                                                             ('070105', 'El Torno', '07'),
                                                             ('070201', 'Warnes', '07'),
                                                             ('070202', 'Okinawa', '07'),
                                                             ('070301', 'San Ignacio', '07'),
                                                             ('070302', 'San Miguel', '07'),
                                                             ('070303', 'San Rafael', '07'),
                                                             ('070401', 'Buena Vista', '07'),
                                                             ('070402', 'San Carlos', '07'),
                                                             ('070403', 'Yapacani', '07'),
                                                             ('070404', 'San Juan', '07'),
                                                             ('070501', 'San Jose', '07'),
                                                             ('070502', 'Pailon', '07'),
                                                             ('070503', 'Robore', '07'),
                                                             ('070601', 'Portachuelo', '07'),
                                                             ('070602', 'Santa Rosa del Sara', '07'),
                                                             ('070603', 'Colpa Belgica', '07'),
                                                             ('070701', 'Lagunillas', '07'),
                                                             ('070702', 'Charagua', '07'),
                                                             ('070703', 'Cabezas', '07'),
                                                             ('070704', 'Cuevo', '07'),
                                                             ('070705', 'Gutierrez', '07'),
                                                             ('070706', 'Camiri', '07'),
                                                             ('070707', 'Boyuibe', '07'),
                                                             ('070801', 'Valle Grande', '07'),
                                                             ('070802', 'Trigal', '07'),
                                                             ('070803', 'Moro Moro', '07'),
                                                             ('070804', 'Postrer Valle', '07'),
                                                             ('070805', 'Pucara', '07'),
                                                             ('070901', 'Samaipata', '07'),
                                                             ('070902', 'Pampa Grande', '07'),
                                                             ('070903', 'Mairana', '07'),
                                                             ('070904', 'Quirusillas', '07'),
                                                             ('071001', 'Montero', '07'),
                                                             ('071002', 'General Saavedra', '07'),
                                                             ('071003', 'Mineros', '07'),
                                                             ('071004', 'Puerto Fernandez Alonso', '07'),
                                                             ('071005', 'San Pedro', '07'),
                                                             ('071101', 'Concepcion', '07'),
                                                             ('071102', 'San Javier', '07'),
                                                             ('071103', 'San Ramon', '07'),
                                                             ('071104', 'San Julian', '07'),
                                                             ('071105', 'San Antonio del Lomerio', '07'),
                                                             ('071106', 'Cuatro Cañadas', '07'),
                                                             ('071201', 'San Matias', '07'),
                                                             ('071301', 'Comarapa', '07'),
                                                             ('071302', 'Saipina', '07'),
                                                             ('071401', 'Puerto Suarez', '07'),
                                                             ('071402', 'Puerto Quijarro', '07'),
                                                             ('071403', 'Carmen Rivero Torres', '07'),
                                                             ('071501', 'Ascencion de Guarayos', '07'),
                                                             ('071502', 'Urubicha', '07'),
                                                             ('071503', 'El Puente', '07');


