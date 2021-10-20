/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.history;

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
public class Tbl_History_DAO implements Serializable {

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

    public void insertHistory(Tbl_History_DTO dto) throws NamingException, SQLException {
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "INSERT INTO tbl_History (email, hotel, roomID, roomNumber, kindOfRoom, price, bookingDate, checkOutDate, codeDis, total, statusID, statusDelete) "
                        + "VALUES (?, ?, ?, ?, ?, ?, GETDATE(), ?, ?, ?, ?, ?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getEmail());
                stm.setString(2, dto.getHotel());
                stm.setInt(3, dto.getRoomID());
                stm.setInt(4, dto.getRoomNumber());
                stm.setString(5, dto.getKindOfRoom());
                stm.setInt(6, dto.getPrice());
                stm.setDate(7, dto.getCheckOutDate());
                stm.setString(8, dto.getCodeDis().trim());
                stm.setInt(9, dto.getTotal());
                stm.setInt(10, MyConstants.STATUS_UNPAID);
                stm.setBoolean(11, false);
                stm.executeUpdate();
            }
        } finally {
            closeDB();
        }
    }

    public ArrayList<Tbl_History_DTO> getListHistoryByEmail(String email) throws NamingException, SQLException {
        ArrayList<Tbl_History_DTO> list = new ArrayList<>();
        try {
            con = DBHelper.getConnect();
            String sql = "SELECT historyID, hotel, roomID, roomNumber, kindOfRoom, price, bookingDate, checkOutDate, codeDis, total, statusID "
                    + "FROM tbl_History "
                    + "WHERE email = ? AND statusDelete = ?";
            stm = con.prepareStatement(sql);
            stm.setString(1, email);
            stm.setBoolean(2, false);
            rs = stm.executeQuery();
            while (rs.next()) {
                int historyID = rs.getInt("historyID");
                String hotel = rs.getString("hotel");
                int roomID = rs.getInt("roomID");
                int roomNumber = rs.getInt("roomNumber");
                String kindOfRoom = rs.getString("kindOfRoom");
                int price = rs.getInt("price");
                Date bookingDate = rs.getDate("bookingDate");
                Date checkOutDate = rs.getDate("checkOutDate");
                String codeDis = rs.getString("codeDis");
                int total = rs.getInt("total");
                int statusID = rs.getInt("statusID");
                list.add(new Tbl_History_DTO(historyID, hotel, roomID, roomNumber, kindOfRoom, price, bookingDate, checkOutDate, codeDis, total, statusID));
            }
        } finally {
            closeDB();
        }
        return list;
    }

    public void updateDeleteRoom(int historyID) throws NamingException, SQLException {
        try {
            con = DBHelper.getConnect();
            String sql = "UPDATE tbl_History "
                    + "SET statusDelete = ? "
                    + "WHERE historyID = ?";
            stm = con.prepareStatement(sql);
            stm.setBoolean(1, true);
            stm.setInt(2, historyID);
            stm.execute();
        } finally {
            closeDB();
        }
    }
}
