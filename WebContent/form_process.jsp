<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test JSP Results Page</title>
</head>
<body>
	<h3>Form Data passed to this page</h3>
	<img src="media/images/mockRealtor.jpg" alt="Mock Realtor" title="Mock Realtor">
	<br>
	<p>Name: <%=request.getParameter("name")%></p>
	<p>Address: <%=request.getParameter("address")%></p>
	<p>Zip Code: <%=request.getParameter("zipcode")%></p>


</body>
</html>