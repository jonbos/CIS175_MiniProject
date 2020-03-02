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
						enctype="multipart/form-data"
						action="editServlet?type=realtor&id=${param.id }">
						<jsp:include page="realtor-form.jsp" />
						<a
							class="button is-danger"
							href="deleteServlet?type=realtor&id=${toEdit.id }">Delete</a>

					</form>
				</c:when>
				<c:when test="${param.type == 'listing'}">
					<jsp:useBean
						id="listingDAO"
						class="controller.ListingDetailDAO" />
					<c:set
						var="listingToEdit"
						scope="request"
						value="${listingDAO.get(param.id) }" />
					<form
						method="post"
						enctype="multipart/form-data"
						action="editServlet?type=listing&id=${listingToEdit.id }">
						<jsp:include page="address-form.jsp" />
						<jsp:include page="listing-form.jsp" />
						<div class="field">
							<label
								class="label"
								for="submit"></label>
							<div class="control">
								<button
									id="submit"
									name="submit"
									class="button is-info">Submit</button>
								<a
									class="button is-danger"
									href="deleteServlet?type=listing&id=${listingToEdit.id }">Delete</a>
							</div>
						</div>
					</form>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>