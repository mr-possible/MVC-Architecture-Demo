<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Entry Page</title>
    </head>
    <body>
        <%@ include file= "header.jsp" %>
        <br>
        <form name="myform" action="entry_servlet" method="GET">
            <table>
                <tr>
                    <td>Enter Roll Number:</td>
                    <td><input type="text" name="sturno"/></td>
                </tr>
                <br>
                <tr>
                    <td>Enter Name:</td>
                    <td><input type="text" name="stuname"/></td>
                </tr>
                <br>
                <tr>
                    <td>Enter Gender:</td>
                    <td><input type="text" name="stugender"/></td>
                </tr>
                <br>
                <tr>
                    <td>Enter Total Marks:</td>
                    <td><input type="text" name="stumarks"/></td>
                </tr>
                <br>
            </table>
            <br>
            <center><input type="submit" value="Submit"/></center>
        </form>
        
    </body>
</html>
