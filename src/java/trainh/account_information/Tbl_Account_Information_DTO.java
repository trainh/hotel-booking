/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.account_information;

import java.io.Serializable;

/**
 *
 * @author trainh
 */
public class Tbl_Account_Information_DTO implements Serializable {
    
    private String email;
    private String name;
    private String phone;
    private String address;
    private int roleID;

    public Tbl_Account_Information_DTO() {
    }

    public Tbl_Account_Information_DTO(String email, String name, String phone, String address) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
 
    public Tbl_Account_Information_DTO(String email, String phone, String address) {
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    public Tbl_Account_Information_DTO(String email, String name, String phone, String address, int roleID) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.roleID = roleID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }
    
    
}
