<%@ page
	language="java"
	contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Realtor <%=request.getParameter("name")%> Details
</title>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css" />
</head>
<body>
	<jsp:include page="header.html" />
	<div class="container is-three-fifths is-offset-one-fifth">
		<h1 class="title">
			Viewing
			<%=request.getParameter("name")%></h1>
		<div class="columns is-multiline">
			<div class="column is-one-third">
				<div class="card">
					<div class="card-image">
						<figure class="image is-4by3">
							<!-- pass the the url data back to the servlet for the image -->
							<img
								src="imageServlet?type=realtor&id=<%int image_id = Integer.parseInt(request.getParameter("realtor"));
			out.println(image_id);%>"
								alt="<%=request.getParameter("name")%>"
								title="<%=request.getParameter("name")%>">
						</figure>
					</div>
					<div class="card-content">
						<div class="media">
							<div class="media-content">
								<p class="title is-4">
									<%=request.getParameter("name")%>
								</p>
							</div>
						</div>

						<div class="content">
							<p>
								<%=request.getParameter("descr")%>
							</p>
						</div>
						<a
							href="edit.jsp?id=${param.realtor }&type=realtor"
							class="button">Edit</a>

					</div>
				</div>
			</div>
		</div>

	</div>
</body>
</html>