module dev.atellezfx.taller {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;

    opens dev.atellezfx.taller to javafx.fxml;
    exports dev.atellezfx.taller;
    exports dev.atellezfx.taller.sql;
    opens dev.atellezfx.taller.sql to javafx.fxml;
}