/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.account_information.Tbl_Account_Information_DTO;
import trainh.discount_code.Tbl_DiscountCode_DAO;
import trainh.discount_code.Tbl_DiscountCode_DTO;
import trainh.history.Tbl_History_DTO;

/**
 *
 * @author trainh
 */
@WebServlet(name = "BookingARoomController", urlPatterns = {"/BookingARoomController"})
public class BookingARoomController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";
    private final String BOOKING_PAGE = "booking.jsp";
    private final String CHECK_OUT_PAGE = "check-out.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INDEX_PAGE;
        String hotel = request.getParameter("hotel").trim();
        String roomID = request.getParameter("roomID").trim();
        String roomNumber = request.getParameter("roomNumber").trim();
        String kindOfRoom = request.getParameter("kindOfRoom").trim();
        String checkOutDate = request.getParameter("checkOutDate").trim();
        String discountCode = request.getParameter("discountCode").trim();
        HttpSession session = request.getSession();
        Tbl_Account_Information_DTO account = (Tbl_Account_Information_DTO) session.getAttribute("USER");
        Tbl_DiscountCode_DAO disDAO = new Tbl_DiscountCode_DAO();
        Tbl_DiscountCode_DTO disDTO;
        Tbl_History_DTO history;
        try {
            if (checkOutDate == null || "".equals(checkOutDate)) {
                request.setAttribute("ERRORR_CHECKOUTDATE", "Input check out date!");
                url = BOOKING_PAGE;
            } else {
                int price = Integer.parseInt(request.getParameter("price"));
                long dayQuatity = dayQuatity(checkOutDate);
                if (dayQuatity > 30 || dayQuatity <= 0) {
                    request.setAttribute("ERRORSTRING", "Invalid check out date! (You can booking 1 day to 30 days) ");
                    url = BOOKING_PAGE;
                } else {
                    if (discountCode == null || "".equals(discountCode)) {
                        history = new Tbl_History_DTO(account.getEmail(), hotel, Integer.parseInt(roomID), Integer.parseInt(roomNumber), kindOfRoom, price, (int) dayQuatity, Date.valueOf(checkOutDate), "", 1, price * (int) dayQuatity);
                        session.setAttribute("CHECK_OUT", history);
                        url = CHECK_OUT_PAGE;
                    } else {
                        disDTO = disDAO.getDiscount(discountCode);
                        if (disDTO == null) {
                            request.setAttribute("ERRORSTRING", "Invalid discount code!");
                            url = BOOKING_PAGE;
                        } else {
                            history = new Tbl_History_DTO(account.getEmail(), hotel, Integer.parseInt(roomID), Integer.parseInt(roomNumber), kindOfRoom, price, (int) dayQuatity, Date.valueOf(checkOutDate), disDTO.getCodeDis(), disDTO.getDiscount(), (int) (disDTO.getDiscount() * price * (int) dayQuatity));
                            session.setAttribute("CHECK_OUT", history);
                            url = CHECK_OUT_PAGE;
                        }
                    }
                }
            }
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

    private long dayQuatity(String checkOutDate) {

        long millis = System.currentTimeMillis();
        java.sql.Date dateNow = new java.sql.Date(millis);

        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        Date date1 = dateNow;
        Date date2 = Date.valueOf(checkOutDate);

        c1.setTime(date1);
        c2.setTime(date2);
        long day = (c2.getTime().getTime() - c1.getTime().getTime());
        if (day > 0) {
            day = ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000)) + 1;
        } else {
            day = ((c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000));
        }
        return day;
    }
}
