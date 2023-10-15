package dev.atellezfx.taller.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmpleadoDAO implements EmpleadoDML {

    public List<Empleado> lista(int id) {
        var empleados = new ArrayList<Empleado>();
        try( Connection dbcon = DataSource.abrirConexion() ) {
            PreparedStatement pstm = dbcon.prepareStatement( SQL_SELECT_EMPLEADOS );
            ResultSet rs = pstm.executeQuery();
            while( rs.next() ) empleados.add( crearEmpleado( rs ) );
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return empleados;
    }

    public Optional<Empleado> obtener(int id) {
        Empleado emp = null;
        try( Connection dbcon = DataSource.abrirConexion() ) {
            PreparedStatement pstm = dbcon.prepareStatement( SQL_SELECT_EMPLEADO_POR_ID );
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if( rs.next() ) emp = crearEmpleado( rs );
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return Optional.ofNullable( emp );
    }

    public int actualizar(Empleado emp) {
        try( Connection dbcon = DataSource.abrirConexion() ) {
            PreparedStatement pstm = dbcon.prepareStatement( SQL_UPDATE_EMPLEADO );
            pstm.setString(1, emp.getNombre());
            pstm.setString(2, emp.getApellidos());
            pstm.setString(3, emp.getEmail());
            pstm.setFloat(4, emp.getSalario());
            pstm.setInt(5, emp.getId());
            return pstm.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int insertar(Empleado emp) {
        try( Connection dbcon = DataSource.abrirConexion() ) {
            PreparedStatement pstm = dbcon.prepareStatement( SQL_INSERT_EMPLEADO );
            pstm.setString(1, emp.getNombre());
            pstm.setString(2, emp.getApellidos());
            pstm.setString(3, emp.getEmail());
            pstm.setFloat(4, emp.getSalario());
            return pstm.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public int eliminar(Empleado emp) {
        try( Connection dbcon = DataSource.abrirConexion() ) {
            PreparedStatement pstm = dbcon.prepareStatement( SQL_DELETE_EMPLEADO );
            pstm.setInt(1, emp.getId());
            return pstm.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private Empleado crearEmpleado(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String apellidos = rs.getString("apellidos");
        String email = rs.getString("email");
        float salario = rs.getFloat("salario");
        return new Empleado(id, nombre, apellidos, email, salario);
    }

}
