/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.account_information;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import trainh.utils.DBHelper;
import trainh.utils.MyConstants;

/**
 *
 * @author trainh
 */
public class Tbl_Account_Information_DAO implements Serializable{
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

    public boolean insertAnAccount(Tbl_Account_Information_DTO dto) throws SQLException, NamingException {
        boolean valid = false;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "INSERT INTO tbl_Account_Information(email, name, phone, address, roleID, createDate, statusID) "
                        + "VALUES (?, ?, ?, ?, ?, GETDATE(), ?) ";
                stm = con.prepareCall(sql);
                stm.setString(1, dto.getEmail());
                stm.setString(2, dto.getName());
                stm.setString(3, dto.getPhone());
                stm.setString(4, dto.getAddress());
                stm.setInt(5, dto.getRoleID());
                stm.setInt(6, MyConstants.STATUS_ACTIVE);
                valid = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return valid;
    }
    
    public Tbl_Account_Information_DTO checkLogin(String email, String password) throws NamingException, SQLException {
        Tbl_Account_Information_DTO dto = null;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT name, phone, address,roleID "
                        + "FROM tbl_Account_Information  "
                        + "FULL OUTER JOIN tbl_Account  "
                        + "ON tbl_Account_Information.email = tbl_Account.email "
                        + "WHERE tbl_Account.emaiL = ? AND tbl_Account.password = ? AND statusID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                stm.setString(2, password);
                stm.setInt(3, MyConstants.STATUS_ACTIVE);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String name = rs.getString("name");
                    String phone = rs.getString("phone");
                    String address = rs.getString("address");
                    int roleID = rs.getInt("roleID");
                    dto = new Tbl_Account_Information_DTO(email, name, phone, address, roleID);
                }
            }
        } finally {
            closeDB();
        }
        return dto;
    }
}
