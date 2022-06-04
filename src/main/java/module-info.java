module com.example.pnvstudent {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens com.example.pnvstudent to javafx.fxml;
    exports com.example.pnvstudent;
}