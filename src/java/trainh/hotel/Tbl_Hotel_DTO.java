/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.hotel;

import java.io.Serializable;

/**
 *
 * @author trainh
 */
public class Tbl_Hotel_DTO implements Serializable{
    
    private String hotel;
    private String address;

    public Tbl_Hotel_DTO() {
    }

    public Tbl_Hotel_DTO(String hotel, String address) {
        this.hotel = hotel;
        this.address = address;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
