<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib
	prefix="fmt"
	uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib
	uri="http://java.sun.com/jsp/jstl/functions"
	prefix="fn"%>


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
		<c:choose>
			<c:when test="${param.type == 'realtor'}">
				<div class="level">
					<div class="level-left">
						<h1 class="title level-item">Viewing All Realtors</h1>

					</div>
					<div class="level-right">
						<a
							class="button level-item"
							href="add.jsp?type=realtor">Add a Realtor</a>

					</div>
				</div>
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
												<!-- Just passing the data already here to the next page -->
												<a
													href="view-realtor-details.jsp?realtor=${realtor.id}&name=${realtor.name }&descr=${realtor.description }"><c:out
														value="${realtor.name }" /></a>
											</p>
										</div>
									</div>

									<div class="content">
										<p>${fn:substring(realtor.description,0,200)}...</p>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:when>
			<c:when test="${param.type == 'listing'}">
				<div class="level">
					<div class="level-left">
						<h1 class="title level-item">Viewing All Listings</h1>

					</div>
					<div class="level-right">
						<a
							class="button level-item"
							href="add.jsp?type=listing">Add a Listing</a>

					</div>
				</div>
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
												<!-- Just passing the data already here to the next page -->
												<a
													href="view-listing-details.jsp?listing_id=${listing.id }&address=${listing.address.getHouseNumberAndStreet() }&city=${listing.address.city }&state=${listing.address.state }&price=${listing.price}&listing_date=${listing.created}&descr=${listing.description }"><c:out
														value="${listing.address.getHouseNumberAndStreet() }" /></a>

											</p>
											<p class="subtitle is-6">
												<c:out
													value="${listing.address.city }, ${listing.address.state }" />
												<br />
												<fmt:setLocale value="en_US" />
												<fmt:formatNumber
													value="${listing.price}"
													type="currency" />
												<br /> Listing Date:
												<fmt:formatDate
													type="both"
													value="${listing.created }" />
											</p>
										</div>
									</div>

									<div class="content">
										<p>${fn:substring(listing.description,0,200)}...</p>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</c:when>
		</c:choose>
	</div>
</body>
</html>