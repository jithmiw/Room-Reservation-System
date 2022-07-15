package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import util.Loader;

import java.io.IOException;

public class DashBoard2FormController implements Loader {
    public AnchorPane context;

    public void checkInOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/CheckInForm");
    }

    public void checkOutOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/CheckInForm");
    }

    public void cancelBookingOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/CheckInForm");
    }

    public void checkAvailabilityOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/RoomsForm1");
    }

    public void guestsOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/CheckInForm");
    }

    public void roomsOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/MarkMaintenanceForm");
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

    public void txtRoomsOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/RoomDetailsForm");
    }

    public void txtMenusOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/MenuDetailsForm");
    }

    public void txtContactOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("receptionistview/ContactDetailsForm");
    }
}