<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="content">
	<div class="portlet light">
		<form:form modelAttribute="question">
			<h3>Add Question</h3>
			<p class="hint">Enter Question and its choices below:</p>


			<div class="form-group">
				<form:label path="category"
					class="control-label visible-ie8 visible-ie9">Category Name</form:label>
				<form:select id="idCategory" path="category"
					class="form-control placeholder-no-fix"
					placeholder="Choice Category"  multiple="true"
					 >
					
					<form:option value="" label="Select Category" />
    <form:options items="${categories}" itemLabel="name" itemValue="id" />
					
  </form:select>
			</div>
			<div class="form-group">
				<form:label path="subcategory.id"
					class="control-label visible-ie8 visible-ie9">Sub category</form:label>
				<form:select id="idSubCategory" path="subcategory.id"
					class="form-control placeholder-no-fix" multiple="true"
					itemValue="id" itemLabel="name" >
					<form:option value="" label="Sub Categories" />
			</form:select>


			</div>



			<div class="form-group">
			<form:label path="description"
					class="control-label visible-ie8 visible-ie9">Question</form:label>
				<form:input path="description" id="description" class="form-control placeholder-no-fix"
					type="text" placeholder="Type the Question"  />
				
			</div>
				<div class="form-actions">
				<button type="submit" class="btn btn-lg btn-success btn-mini"
					class="btn btn-success uppercase pull-right">Submit</button>
			</div>
			
			<div id="result"></div>

		</form:form>
	</div>
</div>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
	$(document)
			.ready(
					function() {

						$('#idCategory')
								.change(
										function(event) {

											var producer = $('#idCategory')
													.val();
											// alert(producer);
											/*  var model = $('#model').val();
											 var price = $('#price').val();
											 var json = { "producer" : producer, "model" : model, "price": price}; */
											$
													.getJSON(
															"http://localhost:8080/onlinetest/subcategories",
															{
																catId : producer
															},
															function(data) {

																$(
																		'#idSubCategory')
																		.empty();

																$
																		.each(
																				data,
																				function(
																						i,
																						value) {

																					$(
																							'#idSubCategory')
																							.append(
																									$(
																											"<option />")
																											.val(
																													value[0].id)
																											.text(
																													value[0].name));

																				});
															});

											//  event.preventDefault();
										});

					});
</script>
