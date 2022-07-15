package tm;

import javafx.scene.control.Button;

public class RoomTM {
    private int roomNo;
    private String roomType;
    private Double priceForNight;
    private Double priceForDay;
    private Button btn;
    private String isEmpty;

    public RoomTM() {
    }

    public RoomTM(int roomNo, String roomType, Button btn) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.btn = btn;
    }

    public RoomTM(int roomNo, String roomType, String isEmpty, Button btn) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.isEmpty = isEmpty;
        this.btn = btn;
    }

    public RoomTM(int roomNo, String roomType, Double priceForNight, Double priceForDay, Button btn) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.priceForNight = priceForNight;
        this.priceForDay = priceForDay;
        this.btn = btn;
    }

    public RoomTM(int roomNo, String roomType, Double priceForNight, Double priceForDay, String isEmpty) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.priceForNight = priceForNight;
        this.priceForDay = priceForDay;
        this.isEmpty = isEmpty;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Double getPriceForNight() {
        return priceForNight;
    }

    public void setPriceForNight(Double priceForNight) {
        this.priceForNight = priceForNight;
    }

    public Double getPriceForDay() {
        return priceForDay;
    }

    public void setPriceForDay(Double priceForDay) {
        this.priceForDay = priceForDay;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    public String getIsEmpty() {
        return isEmpty;
    }

    public void setIsEmpty(String isEmpty) {
        this.isEmpty = isEmpty;
    }

    @Override
    public String toString() {
        return "RoomTM{" +
                "roomNo=" + roomNo +
                ", roomType='" + roomType + '\'' +
                ", priceForNight=" + priceForNight +
                ", priceForDay=" + priceForDay +
                ", btn=" + btn +
                ", isEmpty='" + isEmpty + '\'' +
                '}';
    }
}
