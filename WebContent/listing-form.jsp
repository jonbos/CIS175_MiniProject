<form class="form-horizontal" >
<fieldset>

<!-- Form Name -->
<legend>Listing Detail</legend>

<!-- Text input-->
<div class="field">
  <label class="label" for="price">Asking Price</label>
  <div class="control">
    <input id="price" name="price" type="text" class="input " required="">
    
  </div>
</div>

<!-- Text input-->
<div class="field">
  <label class="label" for="num_beds">Number/Bedrooms</label>
  <div class="control">
    <input id="num_beds" name="num_beds" type="text" placeholder="placeholder" class="input ">
    <p class="help">help</p>
  </div>
</div>

<!-- Text input-->
<div class="field">
  <label class="label" for="num_baths">Number/Bathrooms</label>
  <div class="control">
    <input id="num_baths" name="num_baths" type="text" placeholder="placeholder" class="input ">
    <p class="help">help</p>
  </div>
</div>

<!-- Select Basic -->
<div class="field">
  <label class="label" for="listing_agent">Listing Agent</label>
  <div class="control">
  	<div class="select">
	    <select id="listing_agent" name="listing_agent" class="">
	      <option>Option one</option>
	      <option>Option two</option>
	    </select>
	</div>
  </div>
</div>

<!-- Textarea -->
<div class="field">
  <label class="label" for="description">Description</label>
  <div class="control">                     
    <textarea class="textarea" id="description" name="description"></textarea>
  </div>
</div>

</fieldset>
</form>
