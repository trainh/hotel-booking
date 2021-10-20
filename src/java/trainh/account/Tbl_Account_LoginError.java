/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.account;

/**
 *
 * @author trainh
 */
public class Tbl_Account_LoginError {
    private String errorEmail;
    private String errorPassword;

    public Tbl_Account_LoginError() {
    }

    public Tbl_Account_LoginError(String errorEmail, String errorPassword) {
        this.errorEmail = errorEmail;
        this.errorPassword = errorPassword;
    }

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    } 
}
