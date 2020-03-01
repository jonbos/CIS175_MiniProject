<%@ taglib
	prefix="c"
	uri="http://java.sun.com/jsp/jstl/core"%>

<c:out value='${empty listingToEdit ? "" : "Listing Loaded" }' />
<form class="form-horizontal">
	<fieldset>

		<!-- Text input-->
		<div class="field">
			<label
				class="label"
				for="house_num">House Number</label>
			<div class="control">
				<input
					id="house_num"
					name="house_num"
					type="text"
					class="input"
					value="<c:out value='${empty listingToEdit ? "" : listingToEdit.address.houseNumber }' />"
					required>
			</div>
		</div>

		<!-- Text input-->
		<div class="field">
			<label
				class="label"
				for="apt_suite">Apartment/Suite</label>
			<div class="control">
				<input
					id="apt_suite"
					name="apt_suite"
					value="<c:out value='${empty listingToEdit ? "" : listingToEdit.address.aptSuite }' />"
					type="text"
					class="input ">

			</div>
		</div>

		<!-- Text input-->
		<div class="field">
			<label
				class="label"
				for="street">Street</label>
			<div class="control">
				<input
					id="street"
					name="street"
					type="text"
					class="input "
					value="<c:out value='${empty listingToEdit ? "" : listingToEdit.address.street }' />"
					required="">
			</div>
		</div>

		<!-- Text input-->
		<div class="field">
			<label
				class="label"
				for="city">City</label>
			<div class="control">
				<input
					id="city"
					name="city"
					type="text"
					value="<c:out value='${empty listingToEdit ? "" : listingToEdit.address.city }' />"
					class="input "
					required="">

			</div>
		</div>

		<!-- Text input-->
		<div class="field">
			<label
				class="label"
				for="state">State</label>
			<div class="control">
				<input
					id="state"
					name="state"
					type="text"
					value="<c:out value='${empty listingToEdit ? "" : listingToEdit.address.state }' />"
					class="input "
					required="">

			</div>
		</div>

		<!-- Text input-->
		<div class="field">
			<label
				class="label"
				for="zip">Zip Code</label>
			<div class="control">
				<input
					id="zip"
					value="<c:out value='${empty listingToEdit ? "" : listingToEdit.address.zip }' />"
					name="zip"
					type="text"
					class="input "
					required="">

			</div>
		</div>

	</fieldset>