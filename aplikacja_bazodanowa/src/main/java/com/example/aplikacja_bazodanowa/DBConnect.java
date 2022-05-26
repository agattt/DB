package com.example.aplikacja_bazodanowa;

import java.sql.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import javafx.scene.control.*;

public class DBConnect {

    private Connection connection;

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

    public void setConnection(){

        try {

            this.connection = DriverManager.getConnection("jdbc:hsqldb:file:BOOKS", "SA", "");


        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    private Connection getConnection(){

        return connection;

    }

    private void testConnection(){

        try {
            if (connection.isClosed() || connection.isValid(1000)){

                setConnection();
            }


        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

    public Connection getValidatedConnection(){

        testConnection();

        return connection;

    }

}
