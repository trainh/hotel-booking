/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.history;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author trainh
 */
public class Tbl_History_DTO implements Serializable{
    
    private int historyID;
    private String email;
    private String hotel;
    private int roomID;
    private int roomNumber;
    private String kindOfRoom;
    private int price;
    private int rentalDay;
    private Date bookingDate;
    private Date checkOutDate;
    private String codeDis;
    private float discount;
    private int total;
    private int statusID;

    public Tbl_History_DTO() {
    }

    public Tbl_History_DTO(int historyID, String hotel, int roomID, int roomNumber, String kindOfRoom, int price, Date bookingDate, Date checkOutDate, String codeDis, int total, int statusID) {
        this.historyID = historyID;
        this.hotel = hotel;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.kindOfRoom = kindOfRoom;
        this.price = price;
        this.bookingDate = bookingDate;
        this.checkOutDate = checkOutDate;
        this.codeDis = codeDis;
        this.total = total;
        this.statusID = statusID;
    }

    public Tbl_History_DTO(String email, String hotel, int roomID, int roomNumber, String kindOfRoom, int price, int rentDay, Date checkOutDate, int total) {
        this.email = email;
        this.hotel = hotel;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.kindOfRoom = kindOfRoom;
        this.price = price;
        this.rentalDay = rentDay;
        this.checkOutDate = checkOutDate;
        this.total = total;
    }

    public Tbl_History_DTO(String email, String hotel, int roomID, int roomNumber, String kindOfRoom, int price, int rentDay, Date checkOutDate, String codeDis, float discount, int total) {
        this.email = email;
        this.hotel = hotel;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.kindOfRoom = kindOfRoom;
        this.price = price;
        this.rentalDay = rentDay;
        this.checkOutDate = checkOutDate;
        this.codeDis = codeDis;
        this.discount = discount;
        this.total = total;
    }

    public Tbl_History_DTO(String email, String hotel, int roomID, int roomNumber, String kindOfRoom, int price, int rentDay, Date bookingDate, Date checkOutDate, String codeDis, float discount, int total) {
        this.email = email;
        this.hotel = hotel;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.kindOfRoom = kindOfRoom;
        this.price = price;
        this.rentalDay = rentDay;
        this.bookingDate = bookingDate;
        this.checkOutDate = checkOutDate;
        this.codeDis = codeDis;
        this.discount = discount;
        this.total = total;
    }

    public Tbl_History_DTO(int historyID, String email, String hotel, int roomID, int roomNumber, String kindOfRoom, int price, int rentalDay, Date bookingDate, Date checkOutDate, String codeDis, float discount, int total, int statusID) {
        this.historyID = historyID;
        this.email = email;
        this.hotel = hotel;
        this.roomID = roomID;
        this.roomNumber = roomNumber;
        this.kindOfRoom = kindOfRoom;
        this.price = price;
        this.rentalDay = rentalDay;
        this.bookingDate = bookingDate;
        this.checkOutDate = checkOutDate;
        this.codeDis = codeDis;
        this.discount = discount;
        this.total = total;
        this.statusID = statusID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
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

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getCodeDis() {
        return codeDis;
    }

    public void setCodeDis(String codeDis) {
        this.codeDis = codeDis;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
    
    public int Total() {
        return (int) (price * discount);
    }

    public int getRentalDay() {
        return rentalDay;
    }

    public void setRentalDay(int rentalDay) {
        this.rentalDay = rentalDay;
    }

    public int getStatusID() {
        return statusID;
    }

    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }

    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }
    
}
