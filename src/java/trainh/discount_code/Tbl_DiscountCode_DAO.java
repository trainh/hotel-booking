/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.discount_code;

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
public class Tbl_DiscountCode_DAO implements Serializable {

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
    public Tbl_DiscountCode_DTO getDiscount(String codedis) throws NamingException, SQLException {
        Tbl_DiscountCode_DTO dto = null;
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT discount "
                        + "FROM tbl_DiscountCode "
                        + "WHERE codeDis = ? AND expiryDate > GETDATE()";
                stm = con.prepareStatement(sql);
                stm.setString(1, codedis);
                rs = stm.executeQuery();
                if (rs.next()) {
                    float discount = rs.getFloat("discount");
                    dto = new Tbl_DiscountCode_DTO(codedis, discount);
                }
            }
        } finally {
            closeDB();
        }
        return dto;
    }
}
