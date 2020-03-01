<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib
	prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Viewing List</title>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css" />
</head>
<body>
	<jsp:include page="header.html" />
	<div class="container is-three-fifths is-offset-one-fifth">
		<div class="box">
			<h1 class="title"><%=request.getParameter("address")%>
				Details
			</h1>
			<div class="columns is-multiline">
				<div class="column is-one-third">
					<div class="card">
						<div class="card-image">
							<figure class="image is-4by3">
								<!-- pass the the url data back to the servlet for the image -->
								<img
									src='imageServlet?type=listing&amp;id=<%int image_id = Integer.parseInt(request.getParameter("listing_id"));
			out.println(image_id);%>'
									alt='<%=request.getParameter("address")%>'
									title='<%=request.getParameter("address")%>'>
							</figure>
						</div>
						<div class="card-content">
							<div class="media">
								<div class="media-content">
									<p class="title is-4">
										<%=request.getParameter("address")%>
									</p>
									<p class="subtitle is-6">
										<%=request.getParameter("city")%>,
										<%=request.getParameter("state")%>
										<br />

										<fmt:setLocale value="en_US" />
										<fmt:formatNumber
											value="${param.price}"
											type="currency" />
										<br />

									</p>
								</div>
							</div>

							<fmt:setLocale value="en_US" />
							<div class="content">
								<p>
									<%=request.getParameter("descr")%>
								</p>
							</div>
							<a
								href="edit.jsp?id=${param.listing_id }&type=listing"
								class="button">Edit</a>


						</div>
					</div>

				</div>
			</div>

		</div>
	</div>
</body>
</html>