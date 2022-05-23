package com.example.aplikacja_bazodanowa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class DBApplication extends Application {

    public TableView<Book> BOOKS = new TableView<Book>();

    @Override
    public void start(Stage stage) throws IOException {

        DBConnect.prepareDb();

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