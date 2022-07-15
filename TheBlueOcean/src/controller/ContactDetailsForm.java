package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Loader;

import java.io.IOException;

public class ContactDetailsForm implements Loader {
    public AnchorPane context;

    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/DashBoard2Form");
    }

    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../" + location + ".fxml"));
        context.getChildren().add(parent);
    }
}
