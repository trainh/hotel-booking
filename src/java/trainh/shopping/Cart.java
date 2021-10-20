/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.shopping;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import trainh.room.Tbl_Room_DTO;

/**
 *
 * @author trainh
 */
public class Cart implements Serializable {

    private Map<Integer, Tbl_Room_DTO> cart;

    public Cart() {
    }
    
    public Cart(Map<Integer, Tbl_Room_DTO> cart) {
        this.cart = cart;
    }

    public Map<Integer, Tbl_Room_DTO> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, Tbl_Room_DTO> cart) {
        this.cart = cart;
    }

    public void addRoom(Tbl_Room_DTO room) {
        if (cart == null) {
            this.cart = new HashMap<>();
        }
        if (!this.cart.containsKey(room.getRoomID())) {
            cart.put(room.getRoomID(), room);
        }
    }
    
    public int getSize() {
        return this.cart.size();
    }
}
