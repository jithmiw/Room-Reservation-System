package database;

import model.Meal;

import java.util.ArrayList;

public class MealsDatabase {
    public static ArrayList<Meal> mealTable = new ArrayList();

    static {
        mealTable.add(new Meal("Yellow Rice Set Meal", "Sri Lankan", 2000.0));
        mealTable.add(new Meal("Sri Lankan Noodle Family Meal", "Sri Lankan", 2100.0));
        mealTable.add(new Meal("Sri Lankan Godamba Roti Meal", "Sri Lankan", 2000.0));
        mealTable.add(new Meal("String Hopper Kottu Meal", "Sri Lankan", 2200.0));
        mealTable.add(new Meal("Pittu Meal", "Sri Lankan", 2000.0));
        mealTable.add(new Meal("Vegetable Fried Rice", "Sri Lankan", 810.0));
        mealTable.add(new Meal("Seafood Fried Noodle", "Sri Lankan", 1200.0));
        mealTable.add(new Meal("Gamey Rahata (Weekends only)", "Sri Lankan", 1400.0));
        mealTable.add(new Meal("Deep Fried Vegetable Spring Rolls", "Chinese", 500.0));
        mealTable.add(new Meal("Steamed Dumplings (Chicken)", "Chinese", 800.0));
        mealTable.add(new Meal("Steamed Dumplings (Pork)", "Chinese", 800.0));
        mealTable.add(new Meal("Steamed Dumplings (Seafood)", "Chinese", 800.0));
        mealTable.add(new Meal("Sweet Corn and Chicken Soup", "Chinese", 800.0));
        mealTable.add(new Meal("Clear Vegetable Soup", "Chinese", 500.0));
        mealTable.add(new Meal("Hot and Sour Prawn Soup", "Chinese", 800.0));
        mealTable.add(new Meal("Prawn Balls", "Chinese", 1000.0));
        mealTable.add(new Meal("Traditional French Onion Soup with Gruyère Cheese", "French", 1000.0));
        mealTable.add(new Meal("Seafood Chowder", "French", 1100.0));
        mealTable.add(new Meal("Grilled Tuna Salad", "French", 1100.0));
        mealTable.add(new Meal("BBQ Pork Ribs", "French", 1600.0));
        mealTable.add(new Meal("Seafood Pie", "French", 1500.0));
        mealTable.add(new Meal("Baked Crab", "French", 1200.0));
    }
}
