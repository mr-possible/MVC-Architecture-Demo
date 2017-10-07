
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


@WebServlet(name = "update_servlet", urlPatterns = {"/update_servlet"})
public class update_servlet extends HttpServlet {

   studentdb db= new studentdb();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
     }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       try {
           processRequest(request, response);
       } catch (SQLException ex) {
           Logger.getLogger(update_servlet.class.getName()).log(Level.SEVERE, null, ex);
       }
            
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                
                int student_rollno=Integer.parseInt(request.getParameter("sturno"));
                String student_name= request.getParameter("stuname");
                String student_gender= request.getParameter("stugender");
                double student_marks= Double.parseDouble(request.getParameter("stumarks"));
               
                student stu= new student();
                stu.setRollno(student_rollno);
                stu.setName(student_name);
                stu.setGender(student_gender);
                stu.setTotmarks(student_marks);   
                
                
                try {
                
                    boolean b = db.update(stu);
                    
                    if(b)
                        
                        out.println("<marquee><h4>Record Updated Successfully!!!</h4></marquee>");
                    
                    else
                        
                        out.println("Error!!!");                
                
                
                } catch (SQLException ex) 
                {
                   
                    Logger.getLogger(update_servlet.class.getName()).log(Level.SEVERE, null, ex);
                }  
                
                
                
            }catch(NumberFormatException e)
            {
                out.println("<h3>Database Connection Error!!!</h3>");
            }
            out.println("</body>");
            out.println("</html>");
         }
        
        
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(update_servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
