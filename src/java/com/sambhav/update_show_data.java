package com.sambhav;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "update_show_data", urlPatterns = {"/update_show_data"})
public class update_show_data extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_show_data</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Data for the entered roll number:<br></h1>");          
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);        
        int enter_rno= Integer.parseInt(request.getParameter("rno"));//roll number entered in the text box
        
        studentdb db= new studentdb();
        
        student data;
            
            response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet update_show_data</title>");            
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
                out.println("<th>" + data.getRollno() + "</th>");
                out.println("<th>" + data.getName()+ "</th>");
                out.println("<th>" + data.getGender()+ "</th>");
                out.println("<th>" + data.getTotmarks()+ "</th>");
                out.println("</tr>");
                out.println("</table>");
                out.println("<br>");
                out.println("Please update with the correct details below:");
                //request.getRequestDispatcher("stu_entry.jsp").include(request, response);
                out.println("<form name=\"myform\" action=\"update_servlet\" method=\"get\">");
                
                out.println("<table>");
                out.println("<tr>");
                out.println("<td>Roll No.: <input type= \"text\" name= \"sturno\" value=\"" + data.getRollno() + "\"> </td>");
                out.println("</tr>");
                out.println("<tr>");
                out.println("<td>Name: <input type= \"text\" name= \"stuname\" value=\"" + data.getName()+ "\"> </td>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<td>Gender: <input type= \"text\" name= \"stugender\" value=\"" + data.getGender()+ "\"> </td>");
                out.println("</tr>");
                
                out.println("<tr>");
                out.println("<td>Marks: <input type= \"text\" name= \"stumarks\" value=\"" + data.getTotmarks()+ "\"> </td>");
                out.println("</tr>");
                
                out.println("</table>");
                out.println("<br><input type=\"submit\"  value= \"Update\" />");
           
                
                out.println("</form>");
                
                
            out.println("</body>");
            out.println("</html>");
            }  
            catch(Exception e)
            {
                
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
