<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Student Record Search</h1>
        <form name="myform" action="student_search" method="get">
            <table>
                <tr>
                    <td>Enter Roll Number of the student:</td>
                    <td><input type="text" name="rno"/></td>
                </tr>
                <tr>
                    <td><br><input type="submit" value="Search this roll number:"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
