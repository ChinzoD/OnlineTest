<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<div class="portlet box blue">
	<div class="portlet-body">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-edit"></i>User List
			</div>
		</div>
		<table class="table table-striped table-hover table-bordered" id="sample_editable_1">
			<thead>
				<tr>
					<th>Student ID</th>
					<th>Full Name</th>
					<th>Email</th>
					<th>Year</th>
					<!-- <th>Edit</th> -->
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr id="user${student.userId}" >
						<td>${student.username}</td>
						<td>${student.firstName} ${user.lastName}</td>
						<td>${student.email}</td>
						<td class="center">${student.entry}</td>
						<!-- <td><a class="edit" href="javascript:;"> Edit </a></td> -->
						<td><button  value="${student.userId}" type="button" class="btnDelUser btn btn-xs btn-default pull-right">Delete</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>

