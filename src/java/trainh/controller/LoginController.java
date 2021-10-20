/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.account.Tbl_Account_DAO;
import trainh.account.Tbl_Account_LoginError;
import trainh.account_information.Tbl_Account_Information_DAO;
import trainh.account_information.Tbl_Account_Information_DTO;
import trainh.utils.Encode_256;

/**
 *
 * @author trainh
 */
@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private final String INDEX_PAGE = "index.jsp";
    private final String LOGIN_JSP_PAGE = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = INDEX_PAGE;
        String email = request.getParameter("txtEmail").trim();
        String password = request.getParameter("txtPassword");
        HttpSession session = request.getSession();
        Tbl_Account_Information_DAO dao = new Tbl_Account_Information_DAO();
        Tbl_Account_Information_DTO dto;
        Tbl_Account_LoginError error = new Tbl_Account_LoginError();
        boolean checkEmail = true;
        String nextPage = (String) session.getAttribute("NEXT_PAGE");
        try {
            checkEmail = checkEmail(email, error);
            if (!checkEmail) {
                session.setAttribute("ErrorStringLogin", error);
                url = LOGIN_JSP_PAGE + "?email=" + email;
            } else {
                password = Encode_256.encodePassword(password);
                dto = dao.checkLogin(email, password);
                if (dto != null) {
                    if (nextPage == null) {
                        session.setAttribute("USER", dto);
                        url = INDEX_PAGE;
                    } else {
                        session.setAttribute("USER", dto);
                        url = nextPage;
                    }
                } else {
                    error.setErrorPassword("Incorect password!");
                    session.setAttribute("ErrorStringLogin", error);
                    url = LOGIN_JSP_PAGE + "?email=" + email;
                }
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

    private boolean checkEmail(String email, Tbl_Account_LoginError erroer) throws NamingException, SQLException {
        boolean checkEmail;
        boolean valid = true;
        Tbl_Account_DAO dao = new Tbl_Account_DAO();
        checkEmail = dao.checkAccountByEmail(email);
        if (email == null || "".equals(email)) {
            erroer.setErrorEmail("Input email!");
            valid = false;
        } else {
            if (!checkEmail) {
                erroer.setErrorEmail("Email doesn't exist!");
                valid = false;
            }
        }
        return valid;
    }
}
