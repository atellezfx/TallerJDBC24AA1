package dev.atellezfx.taller.sql;

public interface EmpleadoDML {

    // Todos los atributos de una interfaz son automáticamente
    // públicos y final (constantes).
    String SQL_SELECT_EMPLEADOS = "SELECT * FROM empleado";
    String SQL_SELECT_EMPLEADO_POR_ID = "SELECT * FROM empleado WHERE id=?";
    String SQL_UPDATE_EMPLEADO = "UPDATE empleado SET nombre=?, apellidos=?, email=?, salario=? WHERE id=?";
    String SQL_INSERT_EMPLEADO = "INSERT INTO empleado (nombre, apellidos, email, salario) VALUES (?, ?, ?, ?)";
    String SQL_DELETE_EMPLEADO = "DELETE FROM empleado WHERE id=?";

}
