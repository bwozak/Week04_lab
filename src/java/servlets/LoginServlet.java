/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import service.UserService;

/**
 *
 * @author 672762
 */
public class LoginServlet extends HttpServlet {

@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        UserService userService = new UserService();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        if (username != null && username != "" && password != null && password != "") {
            getServletContext().getRequestDispatcher("/WEB-INF/home.jsp").forward(request, response);
        }
        else {
            request.setAttribute("message", "Please enter valid credentials");
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }

}
