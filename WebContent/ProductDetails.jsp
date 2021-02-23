<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Details</title>
</head>
<body>

<center>
<h1>Product Table</h1>
<form action="AppController">
		<input type="hidden" name="Protocol"value="<c:out value='AddProduct' />" />
		<input type="Submit" value="Create product">
</form>
<br>
<br>
<form action="AppController">
		<input type="hidden" name="Protocol"value="<c:out value='DisplayProductList' />" />
		<input type="Submit" value="Display product list">
</form>

<c:if test="${productList != null}">
<form action ="AppController">
	<input type="hidden" name="Protocol"value="<c:out value='SearchProduct' />" />
    <div class="form-actions no-color">
        <p>
            Find by name: <input type="text" name="SearchString" />
            <input type="submit" value="Search" class="btn btn-default"/> 
           
        </p>
       
    </div>
</form>
<table class="table">
    <thead>
        <tr style="color: Gray">
            <th>
              Product ID
            </th>
            <th>
              Product Name
            </th>
            <th>
              Product Price
            </th>
            <th>
              Product Stock
            </th>
            <th>
              Comments
            </th>
           
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
	<c:forEach var ="PD" items ="${productList}" >
	<tr>
		<td><c:out value="${PD.ID}" /></td>
		<td><c:out value="${PD.name}" /></td>
		<td><c:out value="${PD.price}" /></td>
		<td><c:out value="${PD.stock}" /></td>
		<td><c:out value="${PD.comments }" /></td>
		
		<td>
		<form action="AppController">
			<input type="hidden" name="Protocol"value="<c:out value='EditProduct' />" />
			<input type="hidden" name="PID"value="<c:out value='${PD.ID}' />" />
			<input type="Submit" value="Edit">
		</form>
		</td>
		<td>
		<form action="AppController">
			<input type="hidden" name="Protocol"value="<c:out value='DeleteProduct' />" />
			<input type="hidden" name="PID"value="<c:out value='${PD.ID}' />" />
			<input type="Submit" value="Delete">
		</form>
		</td>
		
	</tr>
	</c:forEach>
    </tbody>
</table>
</c:if>







<c:if test="${productListss != null}">
<form action ="AppContoller">
	<input type="hidden" name="Protocol"value="<c:out value='SearchProduct' />" />
    <div class="form-actions no-color">
        <p>
            Find by name: <input type="text" name="SearchString" />
            <input type="submit" value="Search" class="btn btn-default"/> 
           
        </p>
        
    </div>
</form>
<table class="table">
    <thead>
        <tr style="color: Gray">
            <th>
              Product ID
            </th>
            <th>
              Product Name
            </th>
            <th>
              Product Price
            </th>
            <th>
              Product Stock
            </th>
            <th>
              Comments
            </th>
           
            <th></th>
            <th></th>
        </tr>
    </thead>
    <tbody>
	<c:forEach var ="PD" items ="${productListss}" >
	<tr>
		<td><c:out value="${PD.ID}" /></td>
		<td><c:out value="${PD.name}" /></td>
		<td><c:out value="${PD.price}" /></td>
		<td><c:out value="${PD.stock}" /></td>
		<td><c:out value="${PD.comments }" /></td>
		
		<td>
		<form action="AppController">
			<input type="hidden" name="Protocol"value="<c:out value='EditProduct' />" />
			<input type="hidden" name="PID"value="<c:out value='${PD.ID}' />" />
			<input type="Submit" value="Edit">
		</form>
		</td>
		<td>
		<form action="AppController">
			<input type="hidden" name="Protocol"value="<c:out value='DeleteProduct' />" />
			<input type="hidden" name="PID"value="<c:out value='${PD.ID}' />" />
			<input type="Submit" value="Delete">
		</form>
		</td>
		
	</tr>
	</c:forEach>
    </tbody>
</table>
</c:if>

</center>
</body>
</html>