<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Table</title>
</head>
<body>
<center>
		<h1>Product Management</h1>
        
	</center>
    <div align="center">
		<form action="AppController">
		<input type="hidden" name="Protocol"value="<c:out value='InsertProduct' />" />
        <table cellpadding="5">
            <caption>
            	Add Product
            </caption>        
            <tr>
                <th>Product Name: </th>
                <td>
                	<input type="text" name="productName" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Price: </th>
                <td>
                	<input type="text" name="productPrice" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Product Stock: </th>
                <td>
                	<input type="text" name="productStock" size="45"/>
                </td>
            </tr>
             <tr>
                <th>Product Comment: </th>
                <td>
                	<input type="text" name="productComments" size="45"/>
                </td>
            </tr>
            <tr>
            	<td colspan="2" align="center">
            		<input type="submit" value="Save" />
            	</td>
            </tr>
        </table>
        </form>
    </div>	
</body>
</html>