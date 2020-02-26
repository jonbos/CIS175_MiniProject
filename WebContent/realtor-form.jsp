<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<fieldset>

<!-- Form Name -->
<legend>Realtor Form</legend>

<!-- Text input-->
<div class="field">
  <label class="label" for="name">Name</label>
  <div class="control">
    <input id="name" name="name" type="text" class="input " required="">
    
  </div>
</div>

<!-- Textarea -->
<div class="field">
  <label class="label" for="description">Description</label>
  <div class="control">                     
    <textarea class="textarea" id="description" name="description"></textarea>
  </div>
</div>

<!-- File Button --> 

<label class="label" for="photo">Photo</label>
<div class="file">
  <label class="file-label">
    <input class="file-input" type="file" name="photo" onchange="if (this.files.length > 0) document.getElementById('filename-photo').innerHTML = this.files[0].name;">
    <span class="file-cta">
      <span class="file-icon">
        <i class="fa fa-upload"></i>
      </span>
      <span class="file-label" id="filename-photo">
        Choose a file…
      </span>
    </span>
  </label>
</div>
</fieldset>
