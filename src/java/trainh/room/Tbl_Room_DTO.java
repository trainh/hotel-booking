/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.room;

import java.sql.Date;

/**
 *
 * @author trainh
 */
public class Tbl_Room_DTO {

    private int roomID;
    private int roomNumber;
    private String hotel;
    private String email;
    private String kindOfRoom;
    private int price;
    private Date booking;
    private Date check;
    private int statusID;

    public Tbl_Room_DTO() {
    }

    public Tbl_Room_DTO(String kindOfRoom) {
        this.kindOfRoom = kindOfRoom;
    }

    public Tbl_Room_DTO(int roomID, int roomNumber, String hotel, String kindOfRoomID, int price) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.hotel = hotel;
        this.kindOfRoom = kindOfRoomID;
        this.price = price;
    }

    public Tbl_Room_DTO(int roomID, int roomNumber, String hotel, String email, String kindOfRoomID, int price, Date booking, Date check, int statusID) {
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.hotel = hotel;
        this.email = email;
        this.kindOfRoom = kindOfRoomID;
        this.price = price;
        this.booking = booking;
        this.check = check;
        this.statusID = statusID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getHotelID() {
        return hotel;
    }

    public void setHotelID(String hotelID) {
        this.hotel = hotelID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKindOfRoom() {
        return kindOfRoom;
    }

    public void setKindOfRoom(String kindOfRoom) {
        this.kindOfRoom = kindOfRoom;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getBooking() {
        return booking;
    }

    public void setBooking(Date booking) {
        this.booking = booking;
    }

    public Date getCheck() {
        return check;
    }

    public void setCheck(Date check) {
        this.check = check;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }
}
