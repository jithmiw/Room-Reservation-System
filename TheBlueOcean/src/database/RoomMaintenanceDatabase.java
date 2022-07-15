package database;

import model.Room;

import java.util.ArrayList;

public class RoomMaintenanceDatabase {
    public static ArrayList<Room> maintenanceTable = new ArrayList();

    static {
        maintenanceTable.add(new Room(1, "Single", "Available"));
        maintenanceTable.add(new Room(2, "Double", "Available"));
        maintenanceTable.add(new Room(3, "Triple", "Available"));
        maintenanceTable.add(new Room(4, "Squad", "Available"));
        maintenanceTable.add(new Room(5, "Single", "Available"));
        maintenanceTable.add(new Room(6, "Single", "Available"));
        maintenanceTable.add(new Room(7, "Double", "Available"));
        maintenanceTable.add(new Room(8, "Double", "Available"));
        maintenanceTable.add(new Room(9, "Triple", "Available"));
        maintenanceTable.add(new Room(10, "Triple", "Available"));
        maintenanceTable.add(new Room(11, "Squad", "Available"));
        maintenanceTable.add(new Room(12, "Squad", "Available"));
        maintenanceTable.add(new Room(13, "Single", "Available"));
        maintenanceTable.add(new Room(14, "Single", "Available"));
        maintenanceTable.add(new Room(15, "Single", "Available"));
        maintenanceTable.add(new Room(16, "Double", "Available"));
        maintenanceTable.add(new Room(17, "Double", "Available"));
        maintenanceTable.add(new Room(18, "Double", "Available"));
        maintenanceTable.add(new Room(19, "Triple", "Available"));
        maintenanceTable.add(new Room(20, "Triple", "Available"));
        maintenanceTable.add(new Room(21, "Triple", "Available"));
        maintenanceTable.add(new Room(22, "Squad", "Available"));
        maintenanceTable.add(new Room(23, "Squad", "Available"));
        maintenanceTable.add(new Room(24, "Squad", "Available"));
        maintenanceTable.add(new Room(25, "Squad", "Available"));
    }

}
