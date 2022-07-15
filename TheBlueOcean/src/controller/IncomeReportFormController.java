package controller;

import database.GuestsDatabase;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Guest;
import util.Loader;

import java.io.IOException;
import java.time.LocalDate;

public class IncomeReportFormController implements Loader {
    public AnchorPane context;
    public Text txtMIncome;
    public Text txtYIncome;

    public void initialize() {

        Double mIncome = 0.0;
        Double yIncome = 0.0;

        for (Guest g : GuestsDatabase.guestTable) {
            if (g.getCheckOutDate().getYear() == LocalDate.now().getYear() && g.getCheckOutDate().getMonth() == LocalDate.now().getMonth()) {
                mIncome += g.getFees();
            }
            if (g.getCheckOutDate().getYear() == LocalDate.now().getYear()) {
                yIncome += g.getFees();
            }
        }
        txtMIncome.setText(mIncome + "    LKR");
        txtYIncome.setText(yIncome + "    LKR");
    }

    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("Dashboard1Form");
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../adminview/" + location + ".fxml"));
        context.getChildren().add(parent);
    }
}