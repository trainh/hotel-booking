/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.room.Tbl_Room_DAO;
import trainh.room.Tbl_Room_DTO;
import trainh.shopping.Cart;

/**
 *
 * @author trainh
 */
@WebServlet(name = "GetRoomController", urlPatterns = {"/GetRoomController"})
public class GetRoomController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INDEX_PAGE;
        String hotel = request.getParameter("hotel");
        Tbl_Room_DAO room = new Tbl_Room_DAO();
        HttpSession session = request.getSession();
        ArrayList<Tbl_Room_DTO> listRoom;
        ArrayList<Tbl_Room_DTO> listKindOfRoom;
        Cart cart = (Cart) session.getAttribute("CART");
        try {
            listRoom = room.getListRoomByHotel(hotel);
            listKindOfRoom = room.getListKindOfRoomByHotel(hotel);
            session.setAttribute("LIST_ROOM", listRoom);
            session.setAttribute("LIST_KIND", listKindOfRoom);
            session.setAttribute("KIND_OF_NAME", "All");
            session.setAttribute("HOTEL", hotel);
            url = INDEX_PAGE;
            if (cart != null) {
                deleteRoomInListRoom(cart, listRoom);
            }
        } catch (NamingException e) {
            log("Error NamingException at " + this.getClass().getName() + ": " + e.getMessage());
        } catch (SQLException e) {
            log("Error SQLException at " + this.getClass().getName() + ": " + e.getMessage());
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

    private void deleteRoomInListRoom(Cart cart, ArrayList<Tbl_Room_DTO> listRoom) {
        for (int i = listRoom.size() - 1; i >= 0; i--) {
            if (cart.getCart().containsKey(listRoom.get(i).getRoomID())) {
                listRoom.remove(i);
            }
        }
//        int i = listRoom.size() - 1;
//        while (i >= 0) {
//            if (cart.getCart().containsKey(listRoom.get(i).getRoomID())) {
//                listRoom.remove(i);
//            }
//            i --;
//        }
    }
}
