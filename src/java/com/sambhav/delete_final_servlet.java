
package com.sambhav;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "delete_final_servlet", urlPatterns = {"/delete_final_servlet"})
public class delete_final_servlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delete_final_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet delete_final_servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");          
        student stu;
        stu= delete_confirm_servlet.data;
        studentdb obj= new studentdb();
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet delete_final_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            boolean b= obj.delete( stu.getRollno() );
                      
            if(b)
                out.println("<marquee>The entered entry has been deleted!</marquee>");
            else
            out.println("<h1>ERROR!!!!</h1>");
            
            out.println("<br><center><h3> <a href= \"index.html\">Back to Choice Page </a> ");
            out.println("<br><br><center><h3> <a href= \"stu_delete.jsp\">Delete Another Entry </a> ");
            
            out.println("</body>");
            out.println("</html>");
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
