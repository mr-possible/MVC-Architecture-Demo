<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search roll number to update</title>
    </head>
    <body>
        <h1>Student Update:</h1>
        <br>
        <form name="myform" action="update_show_data" method="get">
            <table>
                <tr>
                    <td>Enter Roll Number:</td>
                    <td><input type="text" name="rno"/> <input type="submit" value="Show the data"/> </td>          
                </tr>            
            </table>         
        </form>
    </body>
</html>
