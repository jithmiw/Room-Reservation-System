package database;

import model.Room;

import java.util.ArrayList;

public class RoomsDatabase {
    public static ArrayList<Room> roomTable = new ArrayList<>();

    static {
        roomTable.add(new Room(1, "Single", 5000.0, 7500.0));
        roomTable.add(new Room(2, "Double", 7500.0, 10000.0));
        roomTable.add(new Room(3, "Triple", 10000.0, 12500.0));
        roomTable.add(new Room(4, "Squad", 12500.0, 15000.0));
        roomTable.add(new Room(5, "Single", 5000.0, 7500.0));
        roomTable.add(new Room(6, "Single", 5000.0, 7500.0));
        roomTable.add(new Room(7, "Double", 7500.0, 10000.0));
        roomTable.add(new Room(8, "Double", 7500.0, 10000.0));
        roomTable.add(new Room(9, "Triple", 10000.0, 12500.0));
        roomTable.add(new Room(10, "Triple", 10000.0, 12500.0));
        roomTable.add(new Room(11, "Squad", 12500.0, 15000.0));
        roomTable.add(new Room(12, "Squad", 12500.0, 15000.0));
        roomTable.add(new Room(13, "Single", 5000.0, 7500.0));
        roomTable.add(new Room(14, "Single", 5000.0, 7500.0));
        roomTable.add(new Room(15, "Single", 5000.0, 7500.0));
        roomTable.add(new Room(16, "Double", 7500.0, 10000.0));
        roomTable.add(new Room(17, "Double", 7500.0, 10000.0));
        roomTable.add(new Room(18, "Double", 7500.0, 10000.0));
        roomTable.add(new Room(19, "Triple", 10000.0, 12500.0));
        roomTable.add(new Room(20, "Triple", 10000.0, 12500.0));
        roomTable.add(new Room(21, "Triple", 10000.0, 12500.0));
        roomTable.add(new Room(22, "Squad", 12500.0, 15000.0));
        roomTable.add(new Room(23, "Squad", 12500.0, 15000.0));
        roomTable.add(new Room(24, "Squad", 12500.0, 15000.0));
        roomTable.add(new Room(25, "Squad", 12500.0, 15000.0));
    }
}
