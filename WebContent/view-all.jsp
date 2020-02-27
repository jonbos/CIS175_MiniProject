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
<title>Viewing List</title>
<link
	rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css" />
</head>
<body>
	<jsp:include page="header.html" />
	<div class="container is-three-fifths is-offset-one-fifth">
		<div class="box">
			<c:choose>
				<c:when test="${param.type == 'realtor'}">
					<h1 class="title">Viewing All Realtors</h1>

					<jsp:useBean
						id="realtorDAO"
						class="controller.RealtorDAO" />
					<div class="columns is-multiline">
						<c:forEach
							var="realtor"
							items="${realtorDAO.getAll()}">
							<div class="column is-one-third">
								<div class="card">
									<div class="card-image">
										<figure class="image is-4by3">
											<img
												src="imageServlet?type=realtor&id=${realtor.id }"
												alt="Placeholder image">
										</figure>
									</div>
									<div class="card-content">
										<div class="media">
											<div class="media-content">
												<p class="title is-4">
													<a href="#"><c:out value="${realtor.name }" /></a>
												</p>
											</div>
										</div>

										<div class="content">
											<p>
												<c:out value="${realtor.description }" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:when>
				<c:when test="${param.type == 'listing'}">
					<h1 class="title">Viewing All Listings</h1>
					<jsp:useBean
						id="listingDetailDAO"
						class="controller.ListingDetailDAO" />
					<div class="columns is-multiline">
						<c:forEach
							var="listing"
							items="${listingDetailDAO.getAll()}">
							<div class="column is-one-third">
								<div class="card">
									<div class="card-image">
										<figure class="image is-4by3">
											<img
												src="imageServlet?type=listing&id=${listing.id }"
												alt="Placeholder image">
										</figure>
									</div>
									<div class="card-content">
										<div class="media">
											<div class="media-content">
												<p class="title is-4">
													<a href="#"><c:out
															value="${listing.address.getHouseNumberAndStreet() }" /></a>

												</p>
												<p class="subtitle is-6">
													<c:out
														value="${listing.address.city }, ${listing.address.state }" />
												</p>
											</div>
										</div>

										<div class="content">
											<p>
												<c:out value="${realtor.description }" />
											</p>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
				</c:when>
			</c:choose>
		</div>
	</div>
</body>
</html>