<%@ page
	language="java"
	contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset>

	<!-- Text input-->
	<div class="field">
		<label
			class="label"
			for="name">Name</label>
		<div class="control">
			<input
				id="name"
				name="name"
				type="text"
				class="input "
				placeholder="<c:out value="${empty toEdit ? 'Name' : ''}" />"
				value="<c:out value='${empty toEdit ? "" : toEdit.name }' />"
				required>

		</div>
	</div>

	<!-- Textarea -->
	<div class="field">
		<label
			class="label"
			for="description">Description</label>
		<div class="control">
			<textarea
				class="textarea"
				id="description"
				name="description"
				placeholder="<c:out value="${empty toEdit ? 'Realtor Description' : ''}" />"><c:out
					value="${empty toEdit ? '' : toEdit.description }" /></textarea>
		</div>
	</div>

	<!-- File Button -->

	<label
		class="label"
		for="photo">Photo</label>
	<c:choose>
		<c:when test="${!empty toEdit }">
			<figure class="image is-128x128">
				<!-- pass the the url data back to the servlet for the image -->
				<img
					src="imageServlet?type=realtor&id=${param.id }"
					alt="${param.name }"
					title="${param.name }">
			</figure>
		</c:when>
	</c:choose>
	<div class="file">
		<label class="file-label"> <input
			class="file-input"
			type="file"
			name="photo"
			onchange="if (this.files.length > 0) document.getElementById('filename-photo').innerHTML = this.files[0].name;">
			<span class="file-cta"> <span class="file-icon"> <i
					class="fa fa-upload"></i>
			</span> <span
				class="file-label"
				id="filename-photo"> Choose a file… </span>
		</span>
		</label>
	</div>

	<!-- Button -->
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

</fieldset>
