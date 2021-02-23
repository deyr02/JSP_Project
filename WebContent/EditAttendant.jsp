<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Attendant </title>
</head>
<body>
<center>
		<h1>Attendant Management</h1>
        
	</center>
    <div align="center">
		<form action="AppController">
		<input type="hidden" name="Protocol"value="<c:out value='UpdateAttendant' />" />
        <table cellpadding="5">
            <caption>
            Edit Attendant
            </caption>   
             <c:if test="${ Row != null}" > 
             <input type="hidden" name="id" value ="<c:out value='${Row.ID}'/>"  />
            <tr>
                <th>Attendant Name: </th>
                <td>
                	<input type="text" name="attendantName" size="45" value ="<c:out value='${Row.name}'/>"  />
                </td>
            </tr>
            <tr>
                <th>Attendant Address: </th>
                <td>
                	<input type="text" name="attendantAddress" size="45"value ="<c:out value='${Row.address}'/>"  />
                </td>
            </tr>
            <tr>
                <th>Attendant Mobile: </th>
                <td>
                	<input type="text" name="attendantMobile" size="45"value ="<c:out value='${Row.num}'/>"  />
                </td>
            </tr>
             <tr>
                <th>Comments: </th>
                <td>
                	<input type="text" name="comments" size="45"value ="<c:out value='${Row.comments}'/>"  />
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
            </c:if>  
        </table>
        </form>
    </div>	
</body>
</html>