/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
        
        Cookie[] storeCookies = request.getCookies();
        
        for(int i = 0; i < storeCookies.length; i++) {
            
            if(storeCookies[i].getName().equals("username")) {
                request.setAttribute("username", storeCookies[i].getValue());
            request.setAttribute("rememberMe", "checked");
            } else {
                response.sendRedirect("home");
                }
            
            request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } 
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        UserService user = new UserService();
        HttpSession session = request.getSession();
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        if (username == null || password == null) {
                request.setAttribute("message", "Invalid entry, please try again");
                getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        } else {
           session.setAttribute("username", username);
           if(request.getParameter("remembeMe") != null) {
               Cookie cookie = new Cookie("username", username);
               response.addCookie(cookie);
           } 
//           else {
//               for(Cookie c : cookie){
//                   c.setMaxAge(0);
//                   response.addCookie(c);   
//               }
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        
    }
}
