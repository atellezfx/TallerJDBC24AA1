package dev.atellezfx.taller;

import dev.atellezfx.taller.sql.Empleado;
import dev.atellezfx.taller.sql.EmpleadoDAO;

import java.util.Optional;

public class PruebaJDBC {

    public static void main(String[] args) {
        EmpleadoDAO dao = new EmpleadoDAO();
        Optional<Empleado> opt = dao.obtener(1);
        if( opt.isPresent() ) {
            System.out.println(opt.get());
        } else {
            System.out.println("El id no existe!!");
        }

    }

}
