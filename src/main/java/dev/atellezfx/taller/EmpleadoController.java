package dev.atellezfx.taller;

import dev.atellezfx.taller.sql.Empleado;
import dev.atellezfx.taller.sql.EmpleadoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Optional;

public class EmpleadoController {

    @FXML private TextField cmpId;
    @FXML private TextField cmpNombre;
    @FXML private TextField cmpApellidos;
    @FXML private TextField cmpEmail;
    @FXML private TextField cmpSalario;

    private EmpleadoDAO dao = new EmpleadoDAO();

    @FXML
    protected void buscar() {
        int id = Integer.parseInt(cmpId.getText());
        Optional<Empleado> opt = dao.obtener( id );
        if( opt.isPresent() ) {
            Empleado emp = opt.get();
            cmpNombre.setText( emp.getNombre() );
            cmpApellidos.setText( emp.getApellidos() );
            cmpEmail.setText( emp.getEmail() );
            cmpSalario.setText( String.valueOf(emp.getSalario()) );
        }
    }

    @FXML
    protected void guardar() {

    }

    @FXML
    protected void cancelar() {

    }

}