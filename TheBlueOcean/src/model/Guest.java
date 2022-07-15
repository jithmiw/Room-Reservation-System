package model;

import java.time.LocalDate;

public class Guest {
    private int roomNo;
    private String roomType;
    private String name;
    private String nicNo;
    private String telNo;
    private String email;
    private String address;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double fees;
    private String mealPlan;

    public Guest() {
    }

    public Guest(int roomNo) {
        this.roomNo = roomNo;
    }

    public Guest(int roomNo, String roomType, String name, String nicNo, String telNo, String email, String address, LocalDate checkInDate, LocalDate checkOutDate, Double fees, String mealPlan) {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.name = name;
        this.nicNo = nicNo;
        this.telNo = telNo;
        this.email = email;
        this.address = address;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.fees = fees;
        this.mealPlan = mealPlan;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNicNo() {
        return nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Double getFees() {
        return fees;
    }

    public void setFees(Double fees) {
        this.fees = fees;
    }

    public String getMealPlan() {
        return mealPlan;
    }

    public void setMealPlan(String mealPlan) {
        this.mealPlan = mealPlan;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "roomNo=" + roomNo +
                ", roomType='" + roomType + '\'' +
                ", name='" + name + '\'' +
                ", nicNo='" + nicNo + '\'' +
                ", telNo='" + telNo + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", fees=" + fees +
                ", mealPlan='" + mealPlan + '\'' +
                '}';
    }
}
