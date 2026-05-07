INSERT INTO categorias (nombre, descripcion, estado) VALUES
                ('Conciertos', 'Eventos musicales en vivo', 'Activo'),
                ('Teatro', 'Obras y musicales', 'Activo'),
                ('Stand up y Monologos', 'Comedia en vivo', 'Activo'),
                ('Espectaculos', 'Shows en vivo', 'Activo');

INSERT INTO sedes (nombre, direccion, ciudad, capacidad, telefono, tipo, estado) VALUES
                ('Estadio Nacional', 'Av. Jose Díaz s/n', 'Lima', 45000, '(01) 433-1718', 'Estadio', 'Activo'),
                ('Teatro Municipal', 'Jr. Ica 377', 'Lima', 850, '(01) 428-2155', 'Teatro', 'Activo'),
                ('Centro de Convenciones', 'Av. Javier Prado Este 2465', 'Lima', 3000, '(01) 611-8000', 'Auditorio', 'Activo'),
                ('Parque de la Exposición', 'Paseo Colón s/n', 'Lima', 10000, '(01) 423-2000', 'Parque', 'Activo');

INSERT INTO artistas (nombre_artistico, genero, nacionalidad, correo, telefono, estado) VALUES
                ('Banda Rockera', 'Rock', 'Peruana', 'banda@gmail.com', '987654321', 'Activo'),
                ('Teatro Nacional', 'Teatro', 'Peruana', 'teatro@gmail.com', '912345678', 'Activo'),
                ('Franco Escamilla', 'Comedia', 'Mexicana', 'franco@gmail.com', '999888777', 'Activo'),
                ('Arte Vivo', 'Espectáculo', 'Internacional', 'artevivo@gmail.com', '945678901', 'Activo');
INSERT INTO eventos (nombre, categoria, fecha, sede, precio, capacidad, artista, estado) VALUES
                ('Gran Concierto Rock', 'Conciertos', '2026-05-15', 'Estadio Nacional', 150, 500, 'Banda Rockera', 'Activo'),
                ('Romeo y Julieta', 'Teatro', '2026-05-20', 'Teatro Municipal', 80, 200, 'Teatro Nacional', 'Activo'),
                ('Franco Escamilla en Lima', 'Stand up y Monólogos', '2026-05-25', 'Centro de Convenciones', 200, 300, 'Franco Escamilla', 'Activo'),
                ('Circo del Sol', 'Espectáculos', '2026-05-30', 'Parque de la Exposición', 200, 1000, 'Arte Vivo', 'Activo');

INSERT INTO usuarios (nombre, apellido, dni, correo, telefono, rol, contrasena, estado) VALUES
                ('Juan', 'Pérez', '12345678', 'juan@gmail.com', '987654321', 'Cliente', '123', 'Activo'),
                ('María', 'García', '87654321', 'maria@gmail.com', '912345678', 'Cliente', '123', 'Activo');