package database;

import model.Guest;

import java.time.LocalDate;
import java.util.ArrayList;

public class GuestsDatabase {
    public static ArrayList<Guest> guestTable = new ArrayList<>();

    static {
        guestTable.add(new Guest(1, "Single", "Saman Gamage", "199069655841", "+94857826963", "saman@gmail.com", "Galle", LocalDate.of(2022, 1, 5), LocalDate.of(2022, 1, 6), 7500.00, "European Plan"));
        guestTable.add(new Guest(2, "Double", "Kamal Liyanarachchi", "196546692486", "+94635842984", "kamal@gmail.com", "Colombo", LocalDate.of(2022, 1, 7), LocalDate.of(2022, 1, 9), 20000.00, "Continental Plan"));
        guestTable.add(new Guest(3, "Triple", "Pawan Kariyawasam", "195979542845", "+94365842958", "pawan@gmail.com", "Matara", LocalDate.of(2022, 1, 4), LocalDate.of(2022, 1, 6), 25000.00, "American Plan"));
        guestTable.add(new Guest(4, "Squad", "Amal Surasinghe", "198525455841", "+94258964841", "amal@gmail.com", "Kaluthara", LocalDate.of(2022, 1, 8), LocalDate.of(2022, 1, 10), 30000.00, "Modified American Plan"));
        guestTable.add(new Guest(5, "Single", "Nimal Perera", "198869455587", "+94836584289", "nimal@gmail.com", "Kandy", LocalDate.of(2022, 2, 1), LocalDate.of(2022, 2, 3), 15000.00, "European Plan"));
    }
}

