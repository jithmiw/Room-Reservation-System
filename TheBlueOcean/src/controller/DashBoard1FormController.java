package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Loader;

import java.io.IOException;

public class DashBoard1FormController implements Loader {
    public AnchorPane context;

    public void roomsOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("adminview/RoomsForm2");
    }

    public void menusOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("adminview/MenusForm1");
    }

    public void incomeReportOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("adminview/IncomeReportForm");
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../" + location + ".fxml"));
        context.getChildren().add(parent);
    }

    public void logOutOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("login/LoginForm1");
    }
}