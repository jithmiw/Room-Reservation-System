package controller;

import com.jfoenix.controls.JFXTextField;
import database.MealsDatabase;
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
import model.Meal;
import tm.MealTM;
import util.Loader;

import java.io.IOException;
import java.util.Optional;

public class MenusForm1Controller implements Loader {
    public AnchorPane context;
    public TableColumn colMealName;
    public TableColumn colMealType;
    public TableColumn colPrice;
    public TableColumn colAction;
    public JFXTextField txtMealName;
    public JFXTextField txtMealType;
    public JFXTextField txtPrice;
    public TableView<MealTM> mealTMTable;

    public void backOnAction(MouseEvent mouseEvent) throws IOException {
        loadUi("Dashboard1Form");
    }

    @Override
    public void loadUi(String location) throws IOException {
        context.getChildren().clear();
        Parent parent = FXMLLoader.load(getClass().getResource("../adminview/" + location + ".fxml"));
        context.getChildren().add(parent);
    }

    public void btnAddNewMealOnAction(ActionEvent actionEvent) {
        Meal meal = new Meal(txtMealName.getText(), txtMealType.getText(), Double.parseDouble(txtPrice.getText()));
        MealsDatabase.mealTable.add(meal);
        loadAllMeals();
    }

    public void btnModifyMealOnAction(ActionEvent actionEvent) {
        for (Meal tm : MealsDatabase.mealTable
        ) {
            if (tm.getMealName().equals(txtMealName.getText())) {
                tm.setMealName(txtMealName.getText());
                tm.setMealType(txtMealType.getText());
                tm.setPrice(Double.parseDouble(txtPrice.getText()));
                loadAllMeals();
                return;
            }
        }
    }

    public void initialize() {

        colMealName.setCellValueFactory(new PropertyValueFactory("mealName"));
        colMealType.setCellValueFactory(new PropertyValueFactory("mealType"));
        colPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllMeals();

        mealTMTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setData(newValue);
            }
        });
    }

    private void setData(MealTM tm) {
        txtMealName.setText(tm.getMealName());
        txtMealType.setText(tm.getMealType());
        txtPrice.setText(String.valueOf(tm.getPrice()));
    }

    private void loadAllMeals() {
        ObservableList<MealTM> mealsObList = FXCollections.observableArrayList();

        for (Meal m : MealsDatabase.mealTable) {
            Button btn = new Button("Delete Meal");
            btn.setFont(Font.font("Lucida Bright", 14.0));
            MealTM tm = new MealTM(m.getMealName(), m.getMealType(), m.getPrice(), btn);
            mealsObList.add(tm);

            btn.setOnAction((e) -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this meal?", ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();

                if (buttonType.get().equals(ButtonType.YES)) {
                    RoomsDatabase.roomTable.remove(m);
                    mealsObList.remove(tm);
                }
            });
        }
        mealTMTable.setItems(mealsObList);
    }
}