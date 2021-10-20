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
public class Tbl_Account_Information_RegisterError implements Serializable{
    private String emailError;
    private String nameError;
    private String phoneError;
    private String addressError;
    private String passwordError;
    private String comfirmPassword;
    
    public Tbl_Account_Information_RegisterError() {
    }

    public Tbl_Account_Information_RegisterError(String emailError, String nameError, String phoneError, String addressError, String passwordError, String comfirmPassword) {
        this.emailError = emailError;
        this.nameError = nameError;
        this.phoneError = phoneError;
        this.addressError = addressError;
        this.passwordError = passwordError;
        this.comfirmPassword = comfirmPassword;
    }

    public String getEmailError() {
        return emailError;
    }

    public void setEmailError(String emailError) {
        this.emailError = emailError;
    }

    public String getNameError() {
        return nameError;
    }

    public void setNameError(String nameError) {
        this.nameError = nameError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }
}
