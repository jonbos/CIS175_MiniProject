<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<fieldset>

	<!-- Text input-->
	<div class="field">
		<label
			class="label"
			for="price">Asking Price</label>
		<div class="control">
			<input
				id="price"
				name="price"
				type="text"
				class="input "
				required="">
		</div>
	</div>

	<div class="field">
		<label
			class="label"
			for="num_beds">Number/Bedrooms</label>
		<div class="control">
			<input
				id="num_beds"
				name="num_beds"
				type="text"
				placeholder=""
				class="input ">
		</div>
	</div>

	<!-- Text input-->
	<div class="field">
		<label
			class="label"
			for="num_baths">Number/Bathrooms</label>
		<div class="control">
			<input
				id="num_baths"
				name="num_baths"
				type="text"
				placeholder=""
				class="input ">
		</div>
	</div>

	<!-- Select Basic -->
	<div class="field">
		<label
			class="label"
			for="listing_agent">Listing Agent</label>
		<div class="control">
			<div class="select">
				<select
					id="listing_agent"
					name="listing_agent"
					class="">
					<jsp:useBean
						id="realtorDAO"
						class="controller.RealtorDAO" />
					<option
						selected="selected"
						disabled>Select Listing Agent</option>

					<c:forEach
						var="realtor"
						items="${realtorDAO.getAll()}">
						<option value="${realtor.id }"><c:out
								value="${realtor.name }" /></option>
					</c:forEach>
				</select>
			</div>
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
				name="description"></textarea>
		</div>
	</div>
	<!-- File Button -->

	<label
		class="label"
		for="photo">Photo</label>
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
				id="filename-photo"> Choose a file... </span>
		</span>
		</label>
	</div>


</fieldset>
