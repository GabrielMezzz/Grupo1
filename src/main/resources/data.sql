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
INSERT INTO artistas (nombre_artistico, genero, nacionalidad, correo, telefono, estado, nombre_sede, direccion_sede, ciudad_sede, capacidad_sede, fecha_evento, hora_evento) VALUES
                                                                                                                                                                                 ('Banda Rockera', 'Rock', 'Peruana', 'banda@gmail.com', '987654321', 'Activo', 'Estadio Nacional', 'Av. Jose Diaz s/n', 'Lima', 45000, '2026-05-15', '20:00'),
                                                                                                                                                                                 ('Teatro Nacional', 'Teatro', 'Peruana', 'teatro@gmail.com', '912345678', 'Activo', 'Teatro Municipal', 'Jr. Ica 377', 'Lima', 850, '2026-05-20', '19:00'),
                                                                                                                                                                                 ('Franco Escamilla', 'Comedia', 'Mexicana', 'franco@gmail.com', '999888777', 'Activo', 'Centro de Convenciones', 'Av. Javier Prado Este 2465', 'Lima', 3000, '2026-05-25', '21:00'),
                                                                                                                                                                                 ('Arte Vivo', 'Espectaculo', 'Internacional', 'artevivo@gmail.com', '945678901', 'Activo', 'Parque de la Exposicion', 'Paseo Colon s/n', 'Lima', 10000, '2026-05-30', '18:00');

INSERT INTO eventos (nombre, categoria, fecha, hora, sede, precio, capacidad, artista, estado) VALUES
                                                                                                   ('Gran Concierto Rock', 'Conciertos', '2026-05-15', '20:00', 'Estadio Nacional', 150, 45000, 'Banda Rockera', 'Activo'),
                                                                                                   ('Romeo y Julieta', 'Teatro', '2026-05-20', '19:00', 'Teatro Municipal', 80, 850, 'Teatro Nacional', 'Activo'),
                                                                                                   ('Franco Escamilla en Lima', 'Comedia', '2026-05-25', '21:00', 'Centro de Convenciones', 200, 3000, 'Franco Escamilla', 'Activo'),
                                                                                                   ('Circo del Sol', 'Espectaculo', '2026-05-30', '18:00', 'Parque de la Exposicion', 200, 10000, 'Arte Vivo', 'Activo');
INSERT INTO usuarios (nombre, apellido, dni, correo, telefono, rol, contrasena, estado) VALUES
                ('Juan', 'Perez', '12345678', 'juan@gmail.com', '987654321', 'Cliente', '123', 'Activo'),
                ('Alan', 'Garcia', '87654321', 'alan@gmail.com', '912345678', 'Cliente', '123', 'Activo');