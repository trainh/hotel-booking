/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.account;

import java.io.Serializable;

/**
 *
 * @author trainh
 */
public class Tbl_Account_DTO implements Serializable {

    private String email;
    private String password;

    public Tbl_Account_DTO() {
    }

    public Tbl_Account_DTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
