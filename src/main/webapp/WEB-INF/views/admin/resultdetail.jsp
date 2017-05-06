<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page session="false"%>
<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-edit"></i>Result detail
		</div>
	</div>
	<div class="portlet-body">
		<div class="table-toolbar">
			<div class="row">
				<div class="col-md-6">
				</div>
			</div>
		</div>
		<h3>${total}</h3>
		<table class="table table-striped table-hover table-bordered"
			id="sample_editable_1">
			<thead>
				<tr>
					<th>No</th>
					<th>Question</th>
					<th>Result</th>
		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${answers}" var="answer" varStatus="status">
					<tr>
					    <td>${status.count}</td>
						<td>${answer.key.question.description}</td>
						<td>${answer.value ? "&#10004" : "&#x2718"}</td>
						<td><button value="${student.userId}" type="button"
								class="btnDelUser btn btn-xs btn-default pull-right">Detail</button></td>
																	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

