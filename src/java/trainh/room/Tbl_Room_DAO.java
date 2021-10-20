/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.room;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import trainh.utils.DBHelper;
import trainh.utils.MyConstants;

/**
 *
 * @author trainh
 */
public class Tbl_Room_DAO implements Serializable {

    Connection con = null;
    PreparedStatement stm = null;
    ResultSet rs = null;

    private void closeDB() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            con.close();
        }
    }

    public ArrayList<Tbl_Room_DTO> getListRoomByHotel(String hotel) throws NamingException, SQLException {
        ArrayList<Tbl_Room_DTO> list = new ArrayList<>();
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT roomID, roomNumber, kindOfRoom, price "
                        + "FROM tbl_Room WHERE statusID = ? AND hotel = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, MyConstants.STATUS_EMPTY);
                stm.setString(2, hotel);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomID = rs.getInt("roomID");
                    int roomNumber = rs.getInt("roomNumber");
                    String kindOfRoom = rs.getString("kindOfRoom");
                    int price = rs.getInt("price");
                    list.add(new Tbl_Room_DTO(roomID, roomNumber, hotel, kindOfRoom, price));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public ArrayList<Tbl_Room_DTO> getListRoomByHotelAndKindOfRoom(String hotel, String kind) throws NamingException, SQLException {
        ArrayList<Tbl_Room_DTO> list = new ArrayList<>();
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT roomID, roomNumber, hotel, kindOfRoom, price "
                        + "FROM tbl_Room "
                        + "WHERE hotel = ? AND kindOfRoom = ? AND statusID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, hotel);
                stm.setString(2, kind);
                stm.setInt(3, MyConstants.STATUS_EMPTY);
                rs = stm.executeQuery();
                while (rs.next()) {
                    int roomID = rs.getInt("roomID");
                    int roomNumber = rs.getInt("roomNumber");
                    String kindOfRoom = rs.getString("kindOfRoom");
                    int price = rs.getInt("price");
                    list.add(new Tbl_Room_DTO(roomID, roomNumber, hotel, kindOfRoom, price));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public ArrayList<Tbl_Room_DTO> getListKindOfRoomByHotel(String hotel) throws NamingException, SQLException {
        ArrayList<Tbl_Room_DTO> list = new ArrayList<>();
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT DISTINCT kindOfRoom "
                        + "FROM tbl_Room "
                        + "WHERE hotel = ? AND statusID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, hotel);
                stm.setInt(2, MyConstants.STATUS_EMPTY);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String kindOfRoom = rs.getString("kindOfRoom");
                    list.add(new Tbl_Room_DTO(kindOfRoom));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public boolean checkEmptyRoom(int roomID) throws NamingException, SQLException {
        boolean vaild = false;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT roomID "
                        + "FROM tbl_Room "
                        + "WHERE roomID = ? AND statusID = ?";
                stm = con.prepareStatement(sql);
                stm.setInt(1, roomID);
                stm.setInt(2, MyConstants.STATUS_EMPTY);
                rs = stm.executeQuery();
                if (rs.next()) {
                    vaild = true;
                }
            }
        } finally {
            closeDB();
        }
        return vaild;
    }

    public boolean bookingRoom(String email, int roomID, Date checkOutDate) throws NamingException, SQLException {
        boolean vaild = false;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "UPDATE tbl_Room "
                        + "SET email = ?, dateBooking = GETDATE(), dateCheck = ?, statusID = ? "
                        + "WHERE roomID = ? AND statusID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setDate(2, checkOutDate);
                stm.setInt(3, MyConstants.STATUS_BOOKING);
                stm.setInt(4, roomID);
                stm.setInt(5, MyConstants.STATUS_EMPTY);
                vaild = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return vaild;
    }
}
