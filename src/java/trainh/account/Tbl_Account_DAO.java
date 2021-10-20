/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import trainh.utils.DBHelper;

/**
 *
 * @author trainh
 */
public class Tbl_Account_DAO implements Serializable {

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

    public boolean insertAnAccount(Tbl_Account_DTO dto) throws SQLException, NamingException {
        boolean valid = false;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "INSERT INTO tbl_Account (email, password) "
                        + "VALUES (?, ?)";
                stm = con.prepareCall(sql);
                stm.setString(1, dto.getEmail());
                stm.setString(2, dto.getPassword());
                valid = stm.executeUpdate() > 0;
            }
        } finally {
            closeDB();
        }
        return valid;
    }
    
    public boolean checkAccountByEmail(String email) throws NamingException, SQLException {
        boolean valid = false;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT email "
                        + "FROM tbl_Account "
                        + "WHERE email = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, email);
                rs = stm.executeQuery();
                if (rs.next()) {
                    valid = true;
                }
            }
        } finally {
            closeDB();
        }
        return valid;
    }
}
