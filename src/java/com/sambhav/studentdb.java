package com.sambhav;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class studentdb {
  
    static Connection currentCon;
    static PreparedStatement st;
    static Statement st1;
    static String qry;
    
    public void insert(student stu) 
    {
        currentCon= ConnectionManager.getConnection();  //we are connecting to connectionManager.java here.
        st= null;
        try {
            st= currentCon.prepareStatement("INSERT INTO student_info (rollno, name, gender, totmarks) VALUES(?,?,?,?)");
            st.setInt(1, stu.getRollno());
            st.setString(2, stu.getName());
            st.setString(3, stu.getGender());
            st.setDouble(4, stu.getTotmarks());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(studentdb.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public student show(int r) throws SQLException            
    {
        student s= new student();
        currentCon= ConnectionManager.getConnection();
        st= null;
        try
        {
            qry= "SELECT * FROM student_info WHERE rollno="+r;
            st1= currentCon.createStatement() ;
            ResultSet rs= st1.executeQuery(qry);
            while(rs.next())
            {
                s.setRollno(rs.getInt(1));
                s.setName(rs.getString(2));
                s.setGender(rs.getString(3));
                s.setTotmarks(rs.getDouble(4));       
            }
             
        }catch(SQLException e)
        {
            
        }      
        return  s;
    }
    public boolean update(student s) throws SQLException
    {
        int c=0;
        
        currentCon= ConnectionManager.getConnection();          //we are connecting to connectionManager.java here.
        try
        {
           qry=  "UPDATE student_info SET name=?, gender=?, totmarks=? WHERE rollno=?";
           st= currentCon.prepareStatement(qry);
           
                st.setInt(4, s.getRollno());
                st.setString(1, s.getName());
                st.setString(2, s.getGender());
                st.setDouble(3, s.getTotmarks());
               
           c = st.executeUpdate();
           
            
        }catch(SQLException e)
        {
            
        }
       if (c > 0)
               return true;
           else
               return false;
    }
    
    public boolean delete(int r)
    {
        int c = 0;
        currentCon= ConnectionManager.getConnection();  //we are connecting to ConnectionManager.java here
        try
        {           
            qry= "DELETE FROM student_info WHERE rollno="  + r ;
            st1= currentCon.createStatement();
            
            c= st1.executeUpdate(qry); 
            
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
      
        if (c>0)
            return true;
        else
            return false;
    }
 }
