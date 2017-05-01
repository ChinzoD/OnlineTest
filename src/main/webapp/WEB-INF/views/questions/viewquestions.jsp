

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-edit"></i>Question Bank
		</div>
	</div>
	<div class="portlet-body">

		<table class="table table-striped table-hover table-bordered"
			id="sample_editable_1">
			<thead>
				<tr>
					<th>Question Id</th>
					<th>Question</th>
				<!-- 	<th>Sub Category</th>
					<th>Category</th>
					<th>Edit</th> -->
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="question">
					<c:if test="${question!= null}">
						<tr id="${question.id}">
						<td>${question.id}</td>
							<td>${question.description}</td>
						
							
							<!-- <td><a class="edit" href="javascript:;"> Edit </a></td> -->
							<td><button value="${question.id}" type="button"
									class="btnDelUser btn btn-xs btn-default pull-right">Delete</button></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>


