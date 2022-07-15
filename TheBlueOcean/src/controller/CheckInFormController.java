package controller;

import com.jfoenix.controls.JFXDatePicker;
import database.GuestsDatabase;
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
import javafx.scene.text.Text;
import model.Guest;
import tm.GuestTM;
import util.Loader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

public class CheckInFormController implements Loader {
    public RadioButton rdBtnDouble;
    public RadioButton rdBtnTriple;
    public RadioButton rdBtnSqaud;
    public AnchorPane context;
    public TextField txtName;
    public TextField txtNICNo;
    public TextField txtPhoneNo;
    public TextField txtEmail;
    public TextField txtAddress;
    public TextField txtRoomNo;
    public TextField txtFees;
    public TableView<GuestTM> guestTMTable;
    public TableColumn colRoomNo;
    public TableColumn colRoomType;
    public TableColumn colName;
    public TableColumn colNICNo;
    public TableColumn colPhoneNo;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colCheckInDate;
    public TableColumn colCheckOutDate;
    public TableColumn colFees;
    public JFXDatePicker dtCheckInDate;
    public JFXDatePicker dtCheckOutDate;
    public RadioButton rdBtnSingle;
    public ToggleGroup roomType;
    public TableColumn colAction;
    public RadioButton rdBtnEuropean;
    public ToggleGroup mealPlan;
    public RadioButton rdBtnContinental;
    public RadioButton rdBtnAmerican;
    public RadioButton rdBtnModifiedAmerican;
    public Text tknDate;
    public Text tknTime;
    public Text tknName;
    public Text tknCheckOut;
    public Text tknRoomNo;
    public Text tknNICNo;
    public Text tknPhoneNo;
    public Text tknFees;
    public Text tknCheckIn;
    public AnchorPane hotelToken;

    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("DashBoard2Form");
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../receptionistview/" + location + ".fxml"));
        context.getChildren().add(parent);
    }

    public void btnModifyOnAction(ActionEvent actionEvent) {
        for (Guest tm : GuestsDatabase.guestTable
        ) {
            if (tm.getRoomNo() == Integer.parseInt(txtRoomNo.getText())) {
                tm.setRoomNo(Integer.parseInt(txtRoomNo.getText()));
                tm.setRoomType(roomType.getSelectedToggle().equals(rdBtnSingle) ? "Single" : roomType.getSelectedToggle().equals(rdBtnDouble) ? "Double" : roomType.getSelectedToggle().equals(rdBtnTriple) ? "Triple" : "Squad");
                tm.setName(txtName.getText());
                tm.setNicNo(txtNICNo.getText());
                tm.setTelNo(txtPhoneNo.getText());
                tm.setEmail(txtEmail.getText());
                tm.setAddress(txtAddress.getText());
                tm.setCheckInDate(dtCheckInDate.getValue());
                tm.setCheckOutDate(dtCheckOutDate.getValue());
                tm.setMealPlan(mealPlan.getSelectedToggle().equals(rdBtnEuropean) ? "European Plan" : mealPlan.getSelectedToggle().equals(rdBtnContinental) ? "Continental Plan" : mealPlan.getSelectedToggle().equals(rdBtnAmerican) ? "American Plan" : "Modified American Plan");
                tm.setFees(Double.parseDouble(txtFees.getText()));
                loadAllGuests();
                return;
            }
        }
    }

    public void btnCheckInOnAction(ActionEvent actionEvent) {
        Guest guest = new Guest(Integer.parseInt(txtRoomNo.getText()), roomType.getSelectedToggle().equals(rdBtnSingle) ? "Single" : roomType.getSelectedToggle().equals(rdBtnDouble) ? "Double" : roomType.getSelectedToggle().equals(rdBtnTriple) ? "Triple" : "Squad",
                txtName.getText(), txtNICNo.getText(), txtPhoneNo.getText(), txtEmail.getText(), txtAddress.getText(), dtCheckInDate.getValue(), dtCheckOutDate.getValue(), Double.parseDouble(txtFees.getText()),
                mealPlan.getSelectedToggle().equals(rdBtnEuropean) ? "European Plan" : mealPlan.getSelectedToggle().equals(rdBtnContinental) ? "Continental Plan" : mealPlan.getSelectedToggle().equals(rdBtnAmerican) ? "American Plan" : "Modified American Plan");
        GuestsDatabase.guestTable.add(guest);
        loadAllGuests();
    }

    public void initialize() {
        dtCheckInDate.setValue(LocalDate.now());
        dtCheckOutDate.setValue(LocalDate.now());

        colRoomNo.setCellValueFactory(new PropertyValueFactory("roomNo"));
        colRoomType.setCellValueFactory(new PropertyValueFactory("roomType"));
        colName.setCellValueFactory(new PropertyValueFactory("name"));
        colNICNo.setCellValueFactory(new PropertyValueFactory("nicNo"));
        colPhoneNo.setCellValueFactory(new PropertyValueFactory("telNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colCheckInDate.setCellValueFactory(new PropertyValueFactory("checkInDate"));
        colCheckOutDate.setCellValueFactory(new PropertyValueFactory("checkOutDate"));
        colFees.setCellValueFactory(new PropertyValueFactory("fees"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllGuests();

        guestTMTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(GuestTM tm) {
        txtRoomNo.setText(String.valueOf(tm.getRoomNo()));
        roomType.selectToggle(tm.getRoomType().equals("Single") ? (rdBtnSingle) : tm.getRoomType().equals("Double") ? (rdBtnDouble) : tm.getRoomType().equals("Triple") ? (rdBtnTriple) : (rdBtnSqaud));
        txtName.setText(tm.getName());
        txtNICNo.setText(tm.getNicNo());
        txtPhoneNo.setText(tm.getTelNo());
        txtEmail.setText(tm.getEmail());
        txtAddress.setText(tm.getAddress());
        dtCheckInDate.setValue(tm.getCheckInDate());
        dtCheckOutDate.setValue(tm.getCheckOutDate());
        txtFees.setText(String.valueOf(tm.getFees()));
        mealPlan.selectToggle(tm.getMealPlan().equals("European Plan") ? (rdBtnEuropean) : tm.getMealPlan().equals("Continental Plan") ? (rdBtnContinental) : tm.getMealPlan().equals("American Plan") ? (rdBtnAmerican) : (rdBtnModifiedAmerican));
    }

    private void loadAllGuests() {
        ObservableList<GuestTM> obList = FXCollections.observableArrayList();

        for (Guest g : GuestsDatabase.guestTable) {
            Button btn = new Button("Cancel Booking");
            btn.setFont(Font.font("Lucida Bright", 14.0));
            GuestTM tm = new GuestTM(g.getRoomNo(), g.getRoomType(), g.getName(), g.getNicNo(), g.getTelNo(), g.getEmail(), g.getAddress(), g.getCheckInDate(), g.getCheckOutDate(), g.getFees(), g.getMealPlan(), btn);
            obList.add(tm);

            btn.setOnAction((e) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to cancel this booking?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)) {
                    GuestsDatabase.guestTable.remove(g);
                    obList.remove(tm);
                }
            });
        }
        guestTMTable.setItems(obList);
    }
}


