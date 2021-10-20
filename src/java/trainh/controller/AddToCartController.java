/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.room.Tbl_Room_DTO;
import trainh.shopping.Cart;

/**
 *
 * @author trainh
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCartController"})
public class AddToCartController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INDEX_PAGE;
        HttpSession session = request.getSession();
        Tbl_Room_DTO room;
        Cart cart = (Cart) session.getAttribute("CART");
        if (cart == null) {
            cart = new Cart();
        }
        ArrayList<Tbl_Room_DTO> listRoom = (ArrayList<Tbl_Room_DTO>) session.getAttribute("LIST_ROOM");
        String hotel = request.getParameter("hotel");
        String kindOfRoom = request.getParameter("kindOfRoom");
        try {
            int roomID = Integer.parseInt(request.getParameter("roomID"));
            int roomNumber = Integer.parseInt(request.getParameter("roomNumber"));
            int price = Integer.parseInt(request.getParameter("price"));
            room = new Tbl_Room_DTO(roomID, roomNumber, hotel, kindOfRoom, price);
            cart.addRoom(room);
            deleteRoomInListRoom(roomID, listRoom);
            session.setAttribute("CART", cart);
        } catch (Exception e) {
            log("Error Exception at " + this.getClass().getName() + ": " + e.getMessage());
        } finally {
            response.sendRedirect(url);
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    private void deleteRoomInListRoom(int roomID, ArrayList<Tbl_Room_DTO> listRoom) {
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getRoomID() == roomID) {
                listRoom.remove(i);
            }
        }
    }
}
