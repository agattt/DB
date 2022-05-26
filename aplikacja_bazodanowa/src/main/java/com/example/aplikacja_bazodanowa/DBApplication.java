package com.example.aplikacja_bazodanowa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;

public class DBApplication extends Application {

    public TableView<Book> BOOKS = new TableView<Book>();

    public static DBConnect dbcon;

    @Override
    public void start(Stage stage) throws IOException {

        dbcon = new DBConnect();

        dbcon.prepareDb();

        dbcon.setConnection();

        Parent root = FXMLLoader.load(getClass().getResource("/com/example/aplikacja_bazodanowa/DB-view.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Twoje książki");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}