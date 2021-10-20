/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.hotel;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import trainh.utils.DBHelper;

/**
 *
 * @author trainh
 */
public class Tbl_Hotel_DAO implements Serializable {

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
    
    public ArrayList<Tbl_Hotel_DTO> getListHotel() throws NamingException, SQLException {
        ArrayList<Tbl_Hotel_DTO> list = new ArrayList<>();
        try {
            con = DBHelper.getConnect();
            if (con != null) {
                String sql = "SELECT hotel, address "
                        + "FROM tbl_Hotel";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("hotel");
                    String address = rs.getString("address");
                    list.add(new Tbl_Hotel_DTO(name, address));
                }
            }
        } finally {
            closeDB();
        }
        return list;
    }
}
