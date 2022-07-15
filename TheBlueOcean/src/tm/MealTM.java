package tm;


import javafx.scene.control.Button;

public class MealTM {
    private String mealName;
    private String mealType;
    private Double price;
    private Button btn;

    public MealTM(String mealName, String mealType, Double price, Button btn) {
        this.mealName = mealName;
        this.mealType = mealType;
        this.price = price;
        this.btn = btn;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "MealTM{" +
                "mealName='" + mealName + '\'' +
                ", mealType='" + mealType + '\'' +
                ", price=" + price +
                ", btn=" + btn +
                '}';
    }
}
