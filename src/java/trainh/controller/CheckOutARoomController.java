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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.history.Tbl_History_DAO;
import trainh.history.Tbl_History_DTO;
import trainh.room.Tbl_Room_DAO;
import trainh.room.Tbl_Room_DTO;

/**
 *
 * @author trainh
 */
@WebServlet(name = "CheckOutARoomController", urlPatterns = {"/CheckOutARoomController"})
public class CheckOutARoomController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INDEX_PAGE;
        Tbl_History_DAO historyDAO = new Tbl_History_DAO();
        Tbl_Room_DAO roomDAO = new Tbl_Room_DAO();
        Tbl_History_DTO historyDTO;
        ArrayList<Tbl_Room_DTO> listRoom;
        HttpSession session = request.getSession();
        historyDTO = (Tbl_History_DTO) session.getAttribute("CHECK_OUT");
        boolean checEmptyRoom;
        boolean bookingRoom;
        try {
            checEmptyRoom = roomDAO.checkEmptyRoom(historyDTO.getRoomID());
            if (checEmptyRoom) {
                bookingRoom = roomDAO.bookingRoom(historyDTO.getEmail(), historyDTO.getRoomID(), historyDTO.getCheckOutDate());
                if (bookingRoom) {
                    historyDAO.insertHistory(historyDTO);
                    request.setAttribute("ERRORSTRING", "Successful booking!");
                    url = INDEX_PAGE;
                    session.removeAttribute("ROOM");
                    session.removeAttribute("CHECK_OUT");
                } else {
                    request.setAttribute("ERRORSTRING", "The room was booked by someone else!");
                    url = INDEX_PAGE;
                }
            } else {
                request.setAttribute("ERRORSTRING", "The room was booked by someone else!");
                url = INDEX_PAGE;
            }
            listRoom = roomDAO.getListRoomByHotel(historyDTO.getHotel());
            session.setAttribute("LIST_ROOM", listRoom);
        } catch (NamingException e) {
            log("Error NamingException at " + this.getClass().getName() + ": " + e.getMessage());
        } catch (SQLException e) {
            log("Error SQLException at " + this.getClass().getName() + ": " + e.getMessage());
        } catch (Exception e) {
            log("Error Exception at " + this.getClass().getName() + ": " + e.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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

}
