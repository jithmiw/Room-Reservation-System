package model;

public class Meal {
    private String mealName;
    private String mealType;
    private Double price;

    public Meal() {
    }

    public Meal(String mealName, String mealType, Double price) {
        this.mealName = mealName;
        this.mealType = mealType;
        this.price = price;
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

    @Override
    public String toString() {
        return "Meal{" +
                "mealName='" + mealName + '\'' +
                ", mealType='" + mealType + '\'' +
                ", price=" + price +
                '}';
    }
}
