package controller;

import com.jfoenix.controls.JFXTextField;
import database.RoomMaintenanceDatabase;
import database.RoomsDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class RoomsForm2Controller implements Loader {
    public AnchorPane context;
    public TableColumn colRoomNo;
    public TableColumn colRoomType;
    public TableColumn colAction;
    public TableColumn colPriceForNight;
    public TableColumn colPriceForDay;
    public JFXTextField txtRoomNo;
    public JFXTextField txtRoomType;
    public JFXTextField txtPriceForNight;
    public JFXTextField txtPriceForDay;
    public TableView<RoomTM> roomTMTable;

    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("Dashboard1Form");
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../adminview/" + location + ".fxml"));
        context.getChildren().add(parent);
    }

    public void btnModifyRoomOnAction(ActionEvent actionEvent) {
        for (Room tm : RoomsDatabase.roomTable
        ) {
            if (tm.getRoomNo() == Integer.parseInt(txtRoomNo.getText())) {
                tm.setRoomNo(Integer.parseInt(txtRoomNo.getText()));
                tm.setRoomType(txtRoomType.getText());
                tm.setPriceForNight(Double.parseDouble(txtPriceForNight.getText()));
                tm.setPriceForDay(Double.parseDouble(txtPriceForDay.getText()));
                loadAllRooms();
                return;
            }
        }
    }

    public void btnAddNewRoomOnAction(ActionEvent actionEvent) {
        Room room = new Room(Integer.parseInt(txtRoomNo.getText()), txtRoomType.getText(), Double.parseDouble(txtPriceForNight.getText()), Double.parseDouble(txtPriceForDay.getText()));
        RoomsDatabase.roomTable.add(room);
        RoomMaintenanceDatabase.maintenanceTable.add(room);
        loadAllRooms();
    }

    public void initialize() {

        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("roomType"));
        colPriceForNight.setCellValueFactory(new PropertyValueFactory("priceForNight"));
        colPriceForDay.setCellValueFactory(new PropertyValueFactory("priceForDay"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllRooms();

        roomTMTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(RoomTM tm) {
        txtRoomNo.setText(String.valueOf(tm.getRoomNo()));
        txtRoomType.setText(tm.getRoomType());
        txtPriceForNight.setText(String.valueOf(tm.getPriceForNight()));
        txtPriceForDay.setText(String.valueOf(tm.getPriceForDay()));
    }

    private void loadAllRooms() {
        ObservableList<RoomTM> roomsObList = FXCollections.observableArrayList();

        for (Room r : RoomsDatabase.roomTable) {
            Button btn = new Button("Delete Room");
            btn.setFont(Font.font("Lucida Bright", 14.0));
            RoomTM tm = new RoomTM(r.getRoomNo(), r.getRoomType(), r.getPriceForNight(), r.getPriceForDay(), btn);
            roomsObList.add(tm);

            btn.setOnAction((e) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this room?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)) {
                    RoomsDatabase.roomTable.remove(r);
                    RoomMaintenanceDatabase.maintenanceTable.remove(r);
                    roomsObList.remove(tm);
                }
            });
        }
        roomTMTable.setItems(roomsObList);
    }
}