module com.example.aplikacja_bazodanowa {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.sql;
    requires org.junit.jupiter.api;
    requires java.desktop;

    opens com.example.aplikacja_bazodanowa to javafx.fxml;
    exports com.example.aplikacja_bazodanowa;
}