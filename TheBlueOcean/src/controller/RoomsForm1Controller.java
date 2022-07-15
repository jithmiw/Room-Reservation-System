package controller;

import database.GuestsDatabase;
import database.RoomMaintenanceDatabase;
import database.RoomsDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Guest;
import model.Room;
import tm.RoomTM;
import util.Loader;

import java.io.IOException;

public class RoomsForm1Controller implements Loader {
    public AnchorPane context;
    public TableView<RoomTM> roomTMTable;
    public TableColumn colRoomNo;
    public TableColumn colRoomType;
    public TableColumn colStatus;
    public TableColumn colPriceForNight;
    public TableColumn colPriceForDay;

    public void initialize() {
        for (Room r : RoomsDatabase.roomTable) {
            r.setIsEmpty("Available");
            for (Guest g : GuestsDatabase.guestTable) {
                if (g.getRoomNo() == r.getRoomNo()) {
                    r.setIsEmpty("Booked");
                    break;
                }
            }
        }
        for (Room r : RoomsDatabase.roomTable) {
            for (Room mRoom : RoomMaintenanceDatabase.maintenanceTable) {
                if (r.getRoomNo() == mRoom.getRoomNo() && mRoom.getIsEmpty().equals("Not Available")) {
                    r.setIsEmpty("Not Available");
                    break;
                }
            }
        }
        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("roomType"));
        colPriceForNight.setCellValueFactory(new PropertyValueFactory("priceForNight"));
        colPriceForDay.setCellValueFactory(new PropertyValueFactory("priceForDay"));
        colStatus.setCellValueFactory(new PropertyValueFactory("isEmpty"));
        loadAllRooms();
    }

    private void loadAllRooms() {
        ObservableList<RoomTM> roomsObList = FXCollections.observableArrayList();

        for (Room r : RoomsDatabase.roomTable) {
            RoomTM tm = new RoomTM(r.getRoomNo(), r.getRoomType(), r.getPriceForNight(), r.getPriceForDay(), r.getIsEmpty());
            roomsObList.add(tm);
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
