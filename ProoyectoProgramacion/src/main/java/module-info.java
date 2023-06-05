module com.example.prooyectoprogramacion {
    requires javafx.controls;
    requires javafx.fxml;


    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.prooyectoprogramacion to javafx.fxml;
    opens Asignacion to javafx.fxml;
    exports com.example.prooyectoprogramacion;
    exports Asignacion;
}
