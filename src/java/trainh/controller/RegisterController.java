/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainh.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Pattern;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import trainh.account.Tbl_Account_DAO;
import trainh.account.Tbl_Account_DTO;
import trainh.account_information.Tbl_Account_Information_DAO;
import trainh.account_information.Tbl_Account_Information_DTO;
import trainh.account_information.Tbl_Account_Information_RegisterError;
import trainh.utils.Encode_256;
import trainh.utils.MyConstants;

/**
 *
 * @author trainh
 */
@WebServlet(name = "RegisterController", urlPatterns = {"/RegisterController"})
public class RegisterController extends HttpServlet {

    private final String REGISTER_JSP_PAGE = "register.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = REGISTER_JSP_PAGE;
        String email = request.getParameter("txtEmail").trim();
        String password = request.getParameter("txtPassword").trim();
        String confirm = request.getParameter("txtConfirm").trim();
        String name = request.getParameter("txtName").trim();
        String phone = request.getParameter("txtPhone").trim();
        String address = request.getParameter("txtAddress").trim();
        Tbl_Account_DAO account = new Tbl_Account_DAO();
        Tbl_Account_Information_DAO info = new Tbl_Account_Information_DAO();
        Tbl_Account_Information_RegisterError error = new Tbl_Account_Information_RegisterError();
        HttpSession session = request.getSession();
        boolean vaildInput;
        boolean vaildRegister = false;
        try {
            vaildInput = inputValidate(new Tbl_Account_Information_DTO(email, name, phone, address), error, password, confirm);
            if (vaildInput) {
                password = Encode_256.encodePassword(password);
                info.insertAnAccount(new Tbl_Account_Information_DTO(email, name, phone, address, MyConstants.ROLE_USER));
                vaildRegister = account.insertAnAccount(new Tbl_Account_DTO(email, password));
            } else {
                session.setAttribute("ErrorRegisterAccount", error);
                url = REGISTER_JSP_PAGE + "?email=" + email + "&name=" + name + "&phone=" + phone + "&address=" + address;
            }
            if (vaildRegister) {
                session.setAttribute("StatusRegisterAccount", "Register success.");
                url = REGISTER_JSP_PAGE;
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

    private boolean validate(Tbl_Account_Information_DTO dto, Tbl_Account_Information_RegisterError error, String password, String confirm) throws SQLException, NamingException {
        boolean valid = true;

        return valid;
    }

    private boolean inputValidate(Tbl_Account_Information_DTO dto, Tbl_Account_Information_RegisterError error, String password, String confirm) throws NamingException, SQLException {
        boolean valid = true;
        if (dto.getName() == null || "".equals(dto.getName())) {
            error.setNameError("Input name!");
            valid = false;
        } else {
            if (dto.getName().length() > 50) {
                error.setNameError("Name cann't exceed 50 characters!");
                valid = false;
            }
        }
        if (dto.getPhone() == null || "".equals(dto.getPhone())) {
            error.setPhoneError("Input phone number!");
            valid = false;
        } else {
            if (!Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$").matcher((dto.getPhone())).find()) {
                error.setPhoneError("Phone number isn't valid!!!");
                valid = false;
            }
        }
        if (dto.getAddress() == null || "".equals(dto.getAddress())) {
            error.setAddressError("Input address!");
            valid = false;
        } else {
            if (dto.getAddress().length() > 200) {
                error.setAddressError("Address cann't exceed 200 characters!");
                valid = false;
            }
        }
        if (dto.getEmail() == null || "".equals(dto.getEmail())) {
            error.setEmailError("Input email!");
            valid = false;
        } else {
            if (!Pattern.compile("^[\\w.+\\-]+@gmail\\.com$").matcher(dto.getEmail()).find()) {
                error.setEmailError("Email isn't vailid!");
                valid = false;
            } else {
                Tbl_Account_DAO account = new Tbl_Account_DAO();
                if (account.checkAccountByEmail(dto.getEmail())) {
                    error.setEmailError("Email already exists!");
                    valid = false;
                }
            }
        }

        if (!Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,}$").matcher((password)).find()) {
            error.setPasswordError("Password isn't valid!!!");
            valid = false;
        } else {
            if ((password != null && !"".equals(password)) && (confirm != null && !"".equals(confirm))) {
                if (!password.equals(confirm)) {
                    error.setComfirmPassword("Comfirm password incorrec!");
                    valid = false;
                }
            }
        }
        return valid;
    }
}
