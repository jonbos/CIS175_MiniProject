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
<meta charset="UTF-8">
<title>Add</title>
<link
	rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link
	rel="stylesheet"
	href="base.css" />
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">
</head>
<body>
	<jsp:include page="header.html" />
	<div class="container is-three-fifths is-offset-one-fifth">
		<div class="box">
			<c:choose>
				<c:when test="${param.type == 'realtor'}">
					<h1 class="title">Add Realtor</h1>
					<form
						action="addServlet?type=realtor"
						class="form-horizontal"
						method="post"
						enctype="multipart/form-data">
						<jsp:include page="realtor-form.jsp" />
					</form>
				</c:when>
				<c:when test="${param.type == 'listing'}">
					<h1 class="title">Add Listing</h1>
					<form
						method="post"
						action="addServlet?type=listing"
						class="form-horizontal"
						enctype="multipart/form-data">
						<label class="label">Address</label>
						<div class="box">
							<jsp:include page="address-form.jsp" />
						</div>
						<label class="label">Listing Information</label>
						<div class="box">
							<jsp:include page="listing-form.jsp" />
						</div>
						<div class="field">
							<label
								class="label"
								for="submit"></label>
							<div class="control">
								<button
									id="submit"
									name="submit"
									class="button is-info">Submit</button>
							</div>
						</div>
					</form>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>