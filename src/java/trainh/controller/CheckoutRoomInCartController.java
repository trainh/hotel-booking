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
import trainh.history.Tbl_History_DAO;
import trainh.history.Tbl_History_DTO;
import trainh.room.Tbl_Room_DAO;

/**
 *
 * @author trainh
 */
@WebServlet(name = "CheckoutRoomInCartController", urlPatterns = {"/CheckoutRoomInCartController"})
public class CheckoutRoomInCartController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";
    private final String CART_PAGE = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INDEX_PAGE;
        HttpSession session = request.getSession();
        ArrayList<Tbl_History_DTO> listCheckout = (ArrayList<Tbl_History_DTO>) session.getAttribute("LIST_CHECKOUT");
        int posRoomEmpty;
        boolean checkInsert;
        try {
            if (listCheckout != null) {
                posRoomEmpty = checkEmptyRoom(listCheckout);
                if (posRoomEmpty == -1) {
                    checkInsert = insertEmailInRoom(listCheckout);
                    if (!checkInsert) {
                        session.setAttribute("ERRORSTRING", "Check out fail!");
                        session.removeAttribute("CART");
                        session.removeAttribute("LIST_CHECKOUT");
                        url = INDEX_PAGE;
                    } else {
                        insertHistory(listCheckout);
                        session.removeAttribute("CART");
                        session.setAttribute("ERRORSTRING", "Check out successful!");
                        url = INDEX_PAGE;
                    }
                } else {
                    session.setAttribute("ERROR_CHECKOUT", "Room " + listCheckout.get(posRoomEmpty).getRoomNumber() + "of " + listCheckout.get(posRoomEmpty).getHotel() + "is already booked");
                    url = CART_PAGE;
                }
            } else {
                session.setAttribute("ERRORSTRING", "Check out fail!");
                session.removeAttribute("CART");
                session.removeAttribute("LIST_CHECKOUT");
                url = INDEX_PAGE;
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

    private int checkEmptyRoom(ArrayList<Tbl_History_DTO> listCheckout) throws NamingException, SQLException {
        Tbl_Room_DAO roomDAO = new Tbl_Room_DAO();
        int pos = -1;
        boolean checkEmptyRoom = true;
        for (Tbl_History_DTO history : listCheckout) {
            checkEmptyRoom = roomDAO.checkEmptyRoom(history.getRoomID());
            if (!checkEmptyRoom) {
                return history.getRoomID();
            }
        }
        return pos;
    }

    private boolean insertEmailInRoom(ArrayList<Tbl_History_DTO> listCheckout) throws NamingException, SQLException {
        Tbl_Room_DAO dao = new Tbl_Room_DAO();
        boolean checkInsert = true;
        for (Tbl_History_DTO dto : listCheckout) {
            checkInsert = dao.bookingRoom(dto.getEmail(), dto.getRoomID(), dto.getCheckOutDate());
            if (!checkInsert) {
                return false;
            }
        }
        return checkInsert;
    }

    private void insertHistory(ArrayList<Tbl_History_DTO> listCheckout) throws NamingException, SQLException {
        Tbl_History_DAO hisDAO = new Tbl_History_DAO();
        for (Tbl_History_DTO dto : listCheckout) {
            hisDAO.insertHistory(dto);
        }
    }
}
