package com.sambhav;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class entry_servlet extends HttpServlet {
    
    static Connection currentCon= null;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>entry_servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            try
            {
                int student_rollno=Integer.parseInt( request.getParameter("sturno"));
                String student_name= request.getParameter("stuname");
                String student_gender= request.getParameter("stugender");
                double student_marks= Double.parseDouble(request.getParameter("stumarks"));
                
                student stu= new student();
                stu.setRollno(student_rollno);
                stu.setName(student_name);
                stu.setGender(student_gender);
                stu.setTotmarks(student_marks);
                
                
                studentdb db = new studentdb();
                db.insert(stu);
                
                out.println("<marquee><h4>Record Inserted Successfully!!!</h4></marquee>");
                out.println("<center><a href=\"stu_entry.jsp\">Enter another student entry (CLICK HERE)</a></center>");
                
                
            }catch(NumberFormatException e)
            {
                out.println("<h3>Database Connection Error!!!</h3>");
            }
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
