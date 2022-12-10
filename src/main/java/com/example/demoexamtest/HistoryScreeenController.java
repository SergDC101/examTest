package com.example.demoexamtest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HistoryScreeenController {

    dbConnect connect = new dbConnect();

    private ObservableList<User> userData = FXCollections.observableArrayList();

    @FXML
    private TableView<User> tableView;

    @FXML
    private TableColumn<User, String> historyColumn;

    @FXML
    private TableColumn<User, String> idColumn;

    @FXML
    private TableColumn<User, String> loginColumn;

    @FXML
    private TableColumn<User, String> nameColumn;

    @FXML
    private TableColumn<User, String> passColumn;


    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {
        initData();
        //Имена должны соответствовать fxml
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));
        passColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        historyColumn.setCellValueFactory(new PropertyValueFactory<>("log_history"));
        tableView.setItems(userData);
    }

    private void initData() throws SQLException, ClassNotFoundException {
        ResultSet result = connect.getTableWorkers();
        while (result.next()){
            userData.add(new User(
                    result.getString(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5)));
        }
    }

}
