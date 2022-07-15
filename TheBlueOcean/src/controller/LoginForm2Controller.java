package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Loader;

import java.io.IOException;

public class LoginForm2Controller implements Loader {
    public AnchorPane context;
    public TextField txtUsername;
    public PasswordField pwdPassword;

    public void BackOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("login/LoginForm1");
    }

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        String tempUsername = txtUsername.getText();
        String tempPassword = pwdPassword.getText();

        if (tempUsername.equals("admin") && tempPassword.equals("1234")) {
            loadUi("adminview/DashBoard1Form");
        } else if (tempUsername.equals("receptionist") && tempPassword.equals("2345")) {
            loadUi("receptionistview/DashBoard2Form");
        } else {
            new Alert(Alert.AlertType.WARNING, "You have entered an invalid username or password. Please try again.").show();
        }
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../" + location + ".fxml"));
        context.getChildren().add(parent);
    }
}

