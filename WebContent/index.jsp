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
<title>Real Estate Listings</title>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css" />
</head>
<body>

	<jsp:include page="header.html" />

	<div class="container is-three-fifths is-offset-one-fifth">
		<div class="columns">
			<div class="column has-text-centered">
				<a class="is-size-1" href="/CIS175_MiniProject/view-all.jsp?type=realtor">View
			
					Realtors</a>
			</div>
			<div class="column has-text-centered">
				<a class="is-size-1" href="/CIS175_MiniProject/view-all.jsp?type=listing">View
					Listings</a>
			</div>

		</div>
	</div>

</body>
</html>