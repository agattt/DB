package com.example.aplikacja_bazodanowa;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.junit.jupiter.api.Assertions;
import javafx.stage.Stage;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import java.util.ResourceBundle;
import java.util.function.Predicate;
import javax.swing.*;
import javax.swing.table.JTableHeader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import java.io.IOException;

public class DBController implements Initializable {


    @FXML
    private TableView<Book> BOOKS;
    @FXML
    private TextField txtDescription;
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
    @FXML
    private TextField txtFilter;
    @FXML
    private TableColumn<Book, String> colTitle;
    @FXML
    private TableColumn<Book, String> colName;
    @FXML
    private TableColumn<Book, String> colSurname;
    @FXML
    private TableColumn<Book, String> colYear;
    @FXML
    private TableColumn<Book, String> colPublisher;
    @FXML
    private TableColumn<Book, String> colDescription;

    ObservableList<Book> data = FXCollections.observableArrayList();

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle){

        try {

            Connection con = DBConnect.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM BOOKS");

            while (rs.next()) {

                System.out.println();

                Book obj = new Book(
                        rs.getString("TITLE"),
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("YEAR"),
                        rs.getString("PUBLISHER"),
                        rs.getString("DESCRIPTION"));

                obj.setId(rs.getInt("ID"));

                data.add(obj);

            }

        } catch (SQLException exception) {

            System.out.println("Problem z utworzeniem bazy danych na początku");

        }

        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colName.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        colSurname.setCellValueFactory(new PropertyValueFactory<>("authorSurname"));
        colYear.setCellValueFactory(new PropertyValueFactory<>("publicationYear"));
        colPublisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        BOOKS.setItems(data);

        BOOKS.setEditable(true);

        colTitle.setCellFactory(TextFieldTableCell.forTableColumn());
        colName.setCellFactory(TextFieldTableCell.forTableColumn());
        colSurname.setCellFactory(TextFieldTableCell.forTableColumn());
        colYear.setCellFactory(TextFieldTableCell.forTableColumn());
        colPublisher.setCellFactory(TextFieldTableCell.forTableColumn());
        colDescription.setCellFactory(TextFieldTableCell.forTableColumn());

    }

    public void changeTitleCellEvent(TableColumn.CellEditEvent editedcell) throws SQLException {

        Book bSelected = BOOKS.getSelectionModel().getSelectedItem();

        int id = bSelected.getId();

        String newTitle = editedcell.getNewValue().toString();

        bSelected.setTitle(newTitle);

        try (Connection c = DBConnect.getConnection()) {

            try (PreparedStatement st = c.prepareStatement("UPDATE BOOKS SET TITLE = ? WHERE ID = ?")) {
                st.setString(1, newTitle);
                st.setInt(2, id);
                st.executeUpdate();
            }

        }

    }

    public void changeNameCellEvent(TableColumn.CellEditEvent editedcell) throws SQLException {

        Book bSelected = BOOKS.getSelectionModel().getSelectedItem();

        int id = bSelected.getId();

        String newName = editedcell.getNewValue().toString();

        bSelected.setAuthorName(newName);

        try (Connection c = DBConnect.getConnection()) {

            try (PreparedStatement st = c.prepareStatement("UPDATE BOOKS SET NAME = ? WHERE ID = ?")) {
                st.setString(1, newName);
                st.setInt(2, id);
                st.executeUpdate();
            }

        }

    }

    public void changeSurnameCellEvent(TableColumn.CellEditEvent editedcell) throws SQLException {

        Book bSelected = BOOKS.getSelectionModel().getSelectedItem();

        int id = bSelected.getId();

        String newSurname = editedcell.getNewValue().toString();

        bSelected.setAuthorSurname(newSurname);

        try (Connection c = DBConnect.getConnection()) {

            try (PreparedStatement st = c.prepareStatement("UPDATE BOOKS SET SURNAME = ? WHERE ID = ?")) {
                st.setString(1, newSurname);
                st.setInt(2, id);
                st.executeUpdate();
            }

        }

    }

    public void changeYearCellEvent(TableColumn.CellEditEvent editedcell) throws SQLException{

        Book bSelected = BOOKS.getSelectionModel().getSelectedItem();

        int id = bSelected.getId();

        String newYear = editedcell.getNewValue().toString();

        bSelected.setAuthorSurname(newYear);

        try (Connection c = DBConnect.getConnection()) {

            try (PreparedStatement st = c.prepareStatement("UPDATE BOOKS SET YEAR = ? WHERE ID = ?")) {
                st.setString(1, newYear);
                st.setInt(2, id);
                st.executeUpdate();
            }

        }

    }

    public void changePublisherCellEvent(TableColumn.CellEditEvent editedcell) throws SQLException{

        Book bSelected = BOOKS.getSelectionModel().getSelectedItem();

        int id = bSelected.getId();

        String newPublisher = editedcell.getNewValue().toString();

        bSelected.setAuthorSurname(newPublisher);

        try (Connection c = DBConnect.getConnection()) {

            try (PreparedStatement st = c.prepareStatement("UPDATE BOOKS SET PUBLISHER = ? WHERE ID = ?")) {
                st.setString(1, newPublisher);
                st.setInt(2, id);
                st.executeUpdate();
            }

        }

    }

    public void changeDescriptionCellEvent(TableColumn.CellEditEvent editedcell) throws SQLException{

        Book bSelected = BOOKS.getSelectionModel().getSelectedItem();

        int id = bSelected.getId();

        String newDescription = editedcell.getNewValue().toString();

        bSelected.setAuthorSurname(newDescription);

        try (Connection c = DBConnect.getConnection()) {

            try (PreparedStatement st = c.prepareStatement("UPDATE BOOKS SET DESCRIPTION = ? WHERE ID = ?")) {
                st.setString(1, newDescription);
                st.setInt(2, id);
                st.executeUpdate();
            }

        }

    }

    @FXML
    public void onAddButtonClick(ActionEvent event) throws SQLException {

        Connection c = DBConnect.getConnection();

        try (PreparedStatement st = c.prepareStatement("INSERT INTO BOOKS (TITLE, NAME, SURNAME, YEAR, PUBLISHER, DESCRIPTION) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)){

            String title = txtTitle.getText();
            String name = txtAuthorName.getText();
            String surname = txtAuthorSurname.getText();
            String year = txtPublicationYear.getText();
            String publisher = txtPublisher.getText();
            String description = txtDescription.getText();

            Book obj = new Book(title, name, surname, year, publisher, description);

            st.setString(1, obj.getTitle());
            st.setString(2, obj.getAuthorName());
            st.setString(3, obj.getAuthorSurname());
            st.setString(4, obj.getPublicationYear());
            st.setString(5, obj.getPublisher());
            st.setString(6, obj.getDescription());
            st.execute();

            try (ResultSet rs = st.getGeneratedKeys()) {
                rs.next();
                obj.setId(rs.getInt(1));
            }

            BOOKS.getItems().add(obj);

            txtTitle.setText("");
            txtAuthorName.setText("");
            txtAuthorSurname.setText("");
            txtPublicationYear.setText("");
            txtPublisher.setText("");
            txtDescription.setText("");


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @FXML
    public void onDeleteButtonClick(ActionEvent event) {

        int id = BOOKS.getSelectionModel().getSelectedItem().getId();

        try (Connection c = DBConnect.getConnection();
             Statement st = c.createStatement()) {

            st.execute("DELETE FROM BOOKS WHERE id = " + id);

            ObservableList<Book> data, book1;

            data = BOOKS.getItems();

            book1 = BOOKS.getSelectionModel().getSelectedItems();

            book1.forEach(data::remove);

            BOOKS.setItems(data);

        } catch (Exception e) {
            Assertions.fail(e);
        }

    }

    @FXML
    public void onFilterButtonClick(ActionEvent event) {

        String keyword = txtFilter.getText();

        ObservableList<Book> dataList = BOOKS.getItems();

        ObservableList<Book> filteredData = FXCollections.observableArrayList() ;

        String lowerCaseFilter = keyword.toLowerCase();


        for (Book book : dataList) {

            if (book.getTitle().toLowerCase().contains(lowerCaseFilter)) {

                filteredData.add(book); // Filter matches title.

            } else if (book.getAuthorName().toLowerCase().contains(lowerCaseFilter)) {

                filteredData.add(book);// Filter matches name.

            } else if (book.getAuthorSurname().toLowerCase().contains(lowerCaseFilter)) {

                filteredData.add(book);// Filter matches last name.

            } else if (book.getPublicationYear().toLowerCase().contains(lowerCaseFilter)) {

                filteredData.add(book);// Filter matches year.

            } else if (book.getPublisher().toLowerCase().contains(lowerCaseFilter)) {

                filteredData.add(book);// Filter matches publisher.

            } else if (book.getDescription().toLowerCase().contains(lowerCaseFilter)) {

                filteredData.add(book);// Filter matches description.

            }

        }

        BOOKS.setItems(filteredData);

    }

    @FXML
    public void onStopButtonClick() {

        ObservableList<Book> dataDB = FXCollections.observableArrayList();

        try {

            Connection con = DBConnect.getConnection();

            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM BOOKS");

            while (rs.next()) {

                Book obj = new Book(
                        rs.getString("TITLE"),
                        rs.getString("NAME"),
                        rs.getString("SURNAME"),
                        rs.getString("YEAR"),
                        rs.getString("PUBLISHER"),
                        rs.getString("DESCRIPTION"));

                obj.setId(rs.getInt("ID"));

                dataDB.add(obj);

            }

        } catch (SQLException exception) {

            System.out.println("Problem z utworzeniem bazy danych na początku");

        }

        BOOKS.setItems(dataDB);

        txtFilter.setText("");

    }

}