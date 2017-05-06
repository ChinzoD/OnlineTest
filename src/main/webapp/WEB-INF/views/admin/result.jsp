<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page session="false"%>

                                               

<div class="portlet box blue">
	<div class="portlet-title">
		<div class="caption">
			<i class="fa fa-edit"></i>Result List
		</div>
	</div>
	<div class="portlet-body">
		<div class="table-toolbar">
			<div class="row">
				<div class="col-md-6">
				</div>
			</div>
		</div>
		
		
		
		
		
		<h3>${total} Out of ${questions}</h3>
		<table class="table table-striped table-hover table-bordered"
			id="sample_editable_1">
			<thead>
				<tr>
					<th>Subject</th>
					<th>Category</th>
					<th>Result</th>
		
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${reports}" var="report">
					<tr>
						<td>${report.key.category.name}</td>
					    <td>${report.key.name}</td>
						<td>${report.value}</td>
																	
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

