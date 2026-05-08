INSERT INTO categorias (nombre, descripcion, estado) VALUES
                ('Conciertos',
                 'No dejes que te lo cuenten: vive una experiencia unica que te volara la cabeza y asegura tu lugar antes de que se agoten!',
                 'Activo'),
                ('Teatro',
                 'Siente la magia del escenario y déjate atrapar por una historia que te hara reir, llorar y vibrar de principio a fin: asegura tu butaca hoy mismo!',
                 'Activo'),
                ('Stand up y Monologos',
                 'Preparate para reirte de lo que nadie se atreve a decir en una noche de pura catarsis y carcajadas: ven por el show y quedate por el chisme!',
                 'Activo'),
                ('Espectaculos',
                 'Preparate para un despliegue de talento y emocion que desafia tus sentidos: una experiencia monumental que no veras dos veces en la vida!',
                 'Activo');

INSERT INTO sedes (nombre, direccion, ciudad, capacidad, telefono, tipo, estado) VALUES
                ('Estadio Nacional', 'Av. Jose Diaz', 'Lima', 45000, '(01) 433-1718', 'Estadio', 'Activo'),
                ('Teatro Municipal', 'Jr. Ica 377', 'Lima', 850, '(01) 428-2155', 'Teatro', 'Activo'),
                ('Centro de Convenciones', 'Av. Javier Prado Este 2465', 'Lima', 3000, '(01) 611-8000', 'Auditorio', 'Activo'),
                ('Parque de la Exposicion', 'Paseo Colon', 'Lima', 10000, '(01) 423-2000', 'Parque', 'Activo');

INSERT INTO artistas (nombre_artistico, genero, nacionalidad, correo, telefono, estado) VALUES
                ('Banda Rockera', 'Rock', 'Peruana', 'banda@gmail.com', '987654321', 'Activo'),
                ('Teatro Nacional', 'Teatro', 'Peruana', 'teatro@gmail.com', '912345678', 'Activo'),
                ('Franco Escamilla', 'Comedia', 'Mexicana', 'franco@gmail.com', '999888777', 'Activo'),
                ('Arte Vivo', 'Espectaculo', 'Internacional', 'artevivo@gmail.com', '945678901', 'Activo');
INSERT INTO eventos (nombre, categoria, fecha, sede, precio, capacidad, artista, estado) VALUES
                ('Gran Concierto Rock', 'Conciertos', '2026-05-15', 'Estadio Nacional', 150, 500, 'Banda Rockera', 'Activo'),
                ('Romeo y Julieta', 'Teatro', '2026-05-20', 'Teatro Municipal', 80, 200, 'Teatro Nacional', 'Activo'),
                ('Franco Escamilla en Lima', 'Stand up y Monologos', '2026-05-25', 'Centro de Convenciones', 200, 300, 'Franco Escamilla', 'Activo'),
                ('Circo del Sol', 'Espectaculos', '2026-05-30', 'Parque de la Exposicion', 200, 1000, 'Arte Vivo', 'Activo');

INSERT INTO usuarios (nombre, apellido, dni, correo, telefono, rol, contrasena, estado) VALUES
                ('Juan', 'Perez', '12345678', 'juan@gmail.com', '987654321', 'Cliente', '123', 'Activo'),
                ('Alan', 'Garcia', '87654321', 'alan@gmail.com', '912345678', 'Cliente', '123', 'Activo');