package com.example.aplikacja_bazodanowa;

import java.sql.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import javafx.scene.control.*;

public class DBConnect {

    @FXML
    private TextArea txtDescription;
    @FXML
    private TextField txtAuthorName;
    @FXML
    private TextField txtAuthorSurname;
    @FXML
    private TextField txtTitle;
    @FXML
    private TextField txtPublisher;
    @FXML
    private TextField txtPublicationYear;

    @BeforeAll
    public static void prepareDb() {
        try (Connection c = DriverManager.getConnection("jdbc:hsqldb:file:BOOKS", "SA", "")) {
            try (Statement st = c.createStatement()) {
                st.execute("CREATE TABLE IF NOT EXISTS BOOKS (ID INT IDENTITY, TITLE VARCHAR(50), NAME VARCHAR(20), " +
                        "SURNAME VARCHAR(20),  YEAR VARCHAR(4), PUBLISHER VARCHAR(50), DESCRIPTION VARCHAR (150))");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    public static Connection getConnection() throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:hsqldb:file:BOOKS", "SA", "");

        return connection;

    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (getConnection() != null && !getConnection().isClosed()) {
                getConnection().close();
            }
        } catch (Exception e){
            throw e;
        }
    }

}
