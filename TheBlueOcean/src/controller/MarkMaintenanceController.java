package controller;

import database.RoomMaintenanceDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import model.Room;
import tm.RoomTM;
import util.Loader;

import java.io.IOException;
import java.util.Optional;

public class MarkMaintenanceController implements Loader {
    public AnchorPane context;
    public TableView<RoomTM> roomTMTable;
    public TableColumn colRoomNo;
    public TableColumn colRoomType;
    public TableColumn colAction;
    public TableColumn colStatus;

    public void initialize() {
        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("roomType"));
        colStatus.setCellValueFactory(new PropertyValueFactory("isEmpty"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllRooms();

    }

    private void loadAllRooms() {
        ObservableList<RoomTM> roomsObList = FXCollections.observableArrayList();

        for (Room r : RoomMaintenanceDatabase.maintenanceTable) {
            Button btn = new Button();
            if (r.getIsEmpty().equals("Available")) {
                btn.setText("Mark As Under Maintenance");
            } else {
                btn.setText("Unmark As Under Maintenance");
            }
            btn.setFont(Font.font("Lucida Bright", 14.0));
            RoomTM tm = new RoomTM(r.getRoomNo(), r.getRoomType(), r.getIsEmpty(), btn);
            roomsObList.add(tm);

            btn.setOnAction((e) -> {
                String alertText;
                if (btn.getText().equals("Mark As Under Maintenance")) {
                    alertText = "Are you sure you want to mark this room as under maintenance?";
                } else {
                    alertText = "Are you sure you want to unmark this room as under maintenance?";
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, alertText, ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (btn.getText().equals("Mark As Under Maintenance") && buttonType.get().equals(ButtonType.YES)) {
                    btn.setText("Unmark As Under Maintenance");
                    r.setIsEmpty("Not Available");
                    tm.setIsEmpty("Not Available");
                } else if (btn.getText().equals("Unmark As Under Maintenance") && buttonType.get().equals(ButtonType.YES)) {
                    btn.setText("Mark As Under Maintenance");
                    r.setIsEmpty("Available");
                    tm.setIsEmpty("Available");
                }
                roomsObList.add(tm);
            });
        }
        roomTMTable.setItems(roomsObList);
    }

    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("Dashboard2Form");
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../receptionistview/" + location + ".fxml"));
        context.getChildren().add(parent);
    }
}
