package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Loader;

import java.io.IOException;

public class LoginForm1Controller implements Loader {
    public AnchorPane context;

    public void AdministratorOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("LoginForm2");
    }

    public void ReceptionistOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("LoginForm2");
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../login/" + location + ".fxml"));
        context.getChildren().add(parent);
    }
}

