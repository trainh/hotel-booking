/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.discount_code;

import java.io.Serializable;

/**
 *
 * @author trainh
 */
public class Tbl_DiscountCode_DTO implements Serializable{
    
    private String codeDis;
    private float discount;

    public Tbl_DiscountCode_DTO() {
    }

    public Tbl_DiscountCode_DTO(String codeDis, float discount) {
        this.codeDis = codeDis;
        this.discount = discount;
    }

    public String getCodeDis() {
        return codeDis;
    }

    public void setCodeDis(String codeDis) {
        this.codeDis = codeDis;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

}
