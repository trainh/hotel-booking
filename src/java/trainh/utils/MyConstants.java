/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.utils;

import java.io.Serializable;

/**
 *
 * @author trainh
 */
public class MyConstants implements Serializable {

    public static final int TOTAL_ITEM_IN_PAGE = 4;

    //Role
    public static final int ROLE_USER = 2,
            ROLE_AD = 1;

    //Status
    public static final int STATUS_ACTIVE = 1,
            STATUS_INACTIVE = 2,
            STATUS_EMPTY = 3,
            STATUS_BOOKING = 4,
            STATUS_CHECK = 5,
            STATUS_PAID = 6,
            STATUS_UNPAID = 7;
}
