CREATE DATABASE `empleados`;
USE `empleados`;

CREATE TABLE IF NOT EXISTS `empleado` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `nombre` varchar(50) NOT NULL,
    `apellidos` varchar(50) NOT NULL,
    `email` varchar(255) NOT NULL,
    `salario` float NOT NULL,    
    `creado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modificado` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    KEY `idx_empleado_email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

delimiter //
CREATE TRIGGER `empleado_actualizado` BEFORE UPDATE ON `empleado`
    for each row begin
    set NEW.modificado=current_timestamp;
END; //
delimiter ;

INSERT INTO empleado(nombre, apellidos, email, salario)
VALUES ('Tony', 'Stark', 't.stark@test.com', 35000.00);
INSERT INTO empleado(nombre, apellidos, email, salario)
VALUES ('Bruce', 'Wayne', 'b.wayne@test.com', 23500.00);
INSERT INTO empleado(nombre, apellidos, email, salario)
VALUES ('Clark', 'Kent', 'c.kent@test.com', 42500.00);
INSERT INTO empleado(nombre, apellidos, email, salario)
VALUES ('Bruce', 'Banner', 'b.banner@test.com', 27600.00);
INSERT INTO empleado(nombre, apellidos, email, salario)
VALUES ('Steve', 'Rogers', 's.rogers@test.com', 15000.00);
INSERT INTO empleado(nombre, apellidos, email, salario)
VALUES ('Benito', 'Bodoque', 'b.bodoque@test.com', 75000.00);

