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
import trainh.account_information.Tbl_Account_Information_DTO;
import trainh.room.Tbl_Room_DTO;

/**
 *
 * @author trainh
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final String REGISTER_CONTROLLER = "RegisterController";
    private final String LOGIN_CONTROLLER = "LoginController";
    private final String LOGOUT_CONTROLLER = "LogoutController";
    private final String GET_ROOM_CONTROLLER = "GetRoomController";
    private final String GET_HOTEL_CONTROLLER = "GetHotelController";
    private final String INVALID_PAGE = "invalid.jsp";
    private final String GET_ROOM_BY_KIND_CONTROLLER = "GetRoomByKindController";
    private final String BOOKING_A_ROOM_CONTROLLER = "BookingARoomController";
    private final String CHECK_OUT_A_ROOM_CONTROLLER = "CheckOutARoomController";
    private final String ADD_TO_CART_CONTROLLER = "AddToCartController";
    private final String DELETE_ROOM_IN_CART_CONTROLLER = "DeleteRoomInCartController";
    private final String BOOKING_ROOM_IN_CART_CONTROLLER = "BookingRoomInCartController";
    private final String CHECKOUT_ROOM_IN_CART_CONTROLLER = "CheckoutRoomInCartController";
    private final String GET_HISTORY = "GetHistoryController";
    private final String DELETE_ROOM_HISTORY = "DeleteRoomHistoryController";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("bntAction");
        String url = LOGIN_PAGE;
        HttpSession session = request.getSession();
        try {
            Tbl_Account_Information_DTO user = (Tbl_Account_Information_DTO) request.getSession().getAttribute("USER");
            ArrayList<Tbl_Room_DTO> listRoom = (ArrayList<Tbl_Room_DTO>) request.getSession().getAttribute("LIST_HOTEL");
            if (listRoom == null) {
                url = GET_HOTEL_CONTROLLER;
            } else {
                if (user == null) {
                    if (action == null) {
                        url = LOGIN_PAGE;
                    } else if (action.equals("Login")) {
                        url = LOGIN_CONTROLLER;
                    } else if ("Register".equals(action)) {
                        url = REGISTER_CONTROLLER;
                    } else if ("getRoom".equals(action)) {
                        url = GET_ROOM_CONTROLLER;
                    } else if ("Search Kind".equals(action)) {
                        url = GET_ROOM_BY_KIND_CONTROLLER;
                    } else if ("bookingNow".equals(action)) {
                        url = LOGIN_PAGE;
                        session.setAttribute("NEXT_PAGE", "booking.jsp");
                    } else if ("Add To Cart".equals(action)) {
                        url = ADD_TO_CART_CONTROLLER;
                    } else if ("Delete".equals(action)) {
                        url = DELETE_ROOM_IN_CART_CONTROLLER;
                    } else if ("Booking Room In Cart".equals(action)) {
                        url = LOGIN_PAGE;
                        session.setAttribute("NEXT_PAGE", "cart.jsp");
                    }
                } else {
                    if (user.getRoleID() == 2) {
                        if (action == null) {
                            request.setAttribute("ERROR_STRING", "Don't support this function!");
                            url = INVALID_PAGE;
                        } else if (action.equals("Logout")) {
                            url = LOGOUT_CONTROLLER;
                        } else if ("getRoom".equals(action)) {
                            url = GET_ROOM_CONTROLLER;
                        } else if ("Search Kind".equals(action)) {
                            url = GET_ROOM_BY_KIND_CONTROLLER;
                        } else if ("bookingNow".equals(action)) {
                            url = BOOKING_A_ROOM_CONTROLLER;
                        } else if ("Check Out One Room".equals(action)) {
                            url = CHECK_OUT_A_ROOM_CONTROLLER;
                        } else if ("Add To Cart".equals(action)) {
                            url = ADD_TO_CART_CONTROLLER;
                        } else if ("Delete".equals(action)) {
                            url = DELETE_ROOM_IN_CART_CONTROLLER;
                        } else if ("Booking Room In Cart".equals(action)) {
                            url = BOOKING_ROOM_IN_CART_CONTROLLER;
                        } else if ("Checkout Cart".equals(action)){
                            url = CHECKOUT_ROOM_IN_CART_CONTROLLER;
                        } else if ("history".endsWith(action)) {
                            url = GET_HISTORY;
                        } else if ("Delete Room History".equals(action)) {
                            url = DELETE_ROOM_HISTORY;
                        }
                    } else {
                        request.setAttribute("ERROR_STRING", "Your role don't support");
                        url = INVALID_PAGE;
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
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
