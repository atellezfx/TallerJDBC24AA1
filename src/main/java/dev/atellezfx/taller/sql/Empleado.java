package dev.atellezfx.taller.sql;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Empleado { // Clase de entidad

    private int id;
    private String nombre, apellidos, email;
    private float salario;

}
