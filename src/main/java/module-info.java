module com.example.nofx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.nofx to javafx.fxml;
    exports com.example.nofx;
}