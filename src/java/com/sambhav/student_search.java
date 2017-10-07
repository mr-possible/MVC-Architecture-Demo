
package com.sambhav;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "student_search", urlPatterns = {"/student_search"})
public class student_search extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet student_search</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);    
        
        int enter_rno= Integer.parseInt(request.getParameter("rno"));    //roll number entered in the text box
        
        studentdb db= new studentdb();
        
        student data;
            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Details Of the Entered Roll number:</title>");            
                out.println("</head>");
                out.println("<body>");
                
                
                data= db.show(enter_rno);
                
                out.println("<table border=\"2\"> ");
                
                out.println("<tr>");
                out.println("<th>Roll Number</th>");
                out.println("<th>Name</th>");
                out.println("<th>Gender</th>");
                out.println("<th>Total Marks</th>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>" + data.getRollno() + "</td>");
                out.println("<td>" + data.getName()+ "</td>");
                out.println("<td>" + data.getGender()+ "</td>");
                out.println("<td>" + data.getTotmarks()+ "</td>");
                out.println("</tr>");
                
                out.println("</table>");
                                
               
          
            out.println("</body>");
            out.println("</html>");

                
        } catch (SQLException ex) {
            Logger.getLogger(student_search.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
