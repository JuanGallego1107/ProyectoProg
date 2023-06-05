package com.example.prooyectoprogramacion;

import Asignacion.AsignacionAula;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TableView<AsignacionAula> table;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnModify;

    @FXML
    private TableColumn<AsignacionAula, Integer> clmCapacity;

    @FXML
    private TableColumn<AsignacionAula, String> clmClassroom;

    @FXML
    private TableColumn<AsignacionAula, String> clmComment;

    @FXML
    private TableColumn<AsignacionAula, String> clmCourse;

    @FXML
    private TableColumn<AsignacionAula, String> clmTeacher;

    @FXML
    private TableColumn<AsignacionAula, String> clmTime;

    @FXML
    private TextField txtCapacity;

    @FXML
    private TextField txtClassroom;

    @FXML
    private TextField txtComment;

    @FXML
    private TextField txtCourse;

    @FXML
    private TextField txtTeacher;

    @FXML
    private TextField txtTime;

    @FXML
    void Add() {
        String query = "insert into `asignaciones` values(" + txtTeacher.getText() + ",'" + txtCourse.getText() + "','" + txtClassroom.getText() + "'," + txtTime.getText() + "," + txtCapacity.getText() + "," + txtComment.getText() + ")";
        executeQuery(query);
        table();
    }


    @FXML
    void Delete(ActionEvent event) {
        String query = "update asignaciones set TeacherName=" + txtTeacher.getText() + ",'" + txtCourse.getText() + "','" + txtClassroom.getText() + "'," + txtTime.getText() + "," + txtCapacity.getText() + "," + txtComment.getText();
        executeQuery(query);
        table();
    }

    @FXML
    void Modify(ActionEvent event) {
        String query = "delete from asignaciones where capacity=" + txtCapacity.getText() + "";
        executeQuery(query);
        table();
    }


    public Connection getConnection() {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/asignaciónaulas","root","");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<AsignacionAula> getAsignacionList() {
        ObservableList<AsignacionAula> aulasList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from asignaciones ";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            AsignacionAula asAu;
            while (rs.next()) {
                asAu = new AsignacionAula(rs.getString("Profesor/a"), rs.getString("Asignatura"), rs.getString("Aula"), rs.getString("Hora"), rs.getInt("Capacidad"), rs.getString("Comentarios"));
                aulasList.add(asAu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aulasList;
    }

    public void table() {
        ObservableList<AsignacionAula> list = getAsignacionList();

        clmTeacher.setCellValueFactory(new PropertyValueFactory<AsignacionAula, String>("Profesor/a"));
        clmCourse.setCellValueFactory(new PropertyValueFactory<AsignacionAula, String>("Asignatura"));
        clmClassroom.setCellValueFactory(new PropertyValueFactory<AsignacionAula, String>("Aula"));
        clmTime.setCellValueFactory(new PropertyValueFactory<AsignacionAula, String>("Hora"));
        clmCapacity.setCellValueFactory(new PropertyValueFactory<AsignacionAula, Integer>("Capacidad"));
        clmComment.setCellValueFactory(new PropertyValueFactory<AsignacionAula, String>("Comentarios"));

        table.setItems(list);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table();
    }

    public void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
