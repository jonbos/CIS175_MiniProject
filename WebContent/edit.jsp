<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css" />
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.html" />
	<div class="container is-three-fifths is-offset-one-fifth">
		<div class="box">
			<c:choose>
				<c:when test="${param.type == 'realtor'}">
					<jsp:useBean
						id="realtorDAO"
						class="controller.RealtorDAO" />
					<c:set
						var="toEdit"
						scope="request"
						value="${realtorDAO.get(param.id) }" />
					<h1 class="title">
						Editing
						<c:out value="${toEdit.name }"></c:out>
					</h1>
					<form
						method="post"
						action="editServlet?type=realtor&id=${param.id }">
						<jsp:include page="realtor-form.jsp" />
					</form>
				</c:when>
				<c:when test="${param.type == 'listing'}">
			EDITING REALTOR
			<c:out value="${param.id }">
					</c:out>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>