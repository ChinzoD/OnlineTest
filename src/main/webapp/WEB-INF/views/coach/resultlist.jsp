
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page session="false"%>



<div id="report" class="portlet light ">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject bold uppercase font-dark">Student
				Test Score </span>

		</div>
		<div class="actions">
			<jsp:useBean id="now" class="java.util.Date" />
			<button id="exportResult"
				class="btn btn-circlebtn-icon-only  btn-default">Export</button>
			<a class="btn btn-circle btn-icon-only btn-default fullscreen"
				href="#" data-original-title="" title=""> </a>
		</div>
	</div>
	<div class="portlet-body">





		<table class="table table-sm" id="sample_editable_1">
			<thead>
				<tr>
					<th>No</th>
					<th>Coach</th>
					<th>StudentID</th>
					<th>Full Name</th>
					<th>Entry</th>
					<th>Email</th>
					<th>Date Finished</th>
					<th>Score</th>


				</tr>
			</thead>

			<tbody>
				<c:forEach items="${reports}" var="report" varStatus="status">
					<tr>

						<td>${status.count}</td>
						<td>${report.key.coachId.firstName}</td>
						<td>${report.key.studentId.studentId}</td>
						<td>${report.key.studentId.firstName}
							${report.key.studentId.lastName}</td>
						<td>${report.key.studentId.entry}</td>
						<td>${report.key.studentId.email}</td>
						<td>${report.key.end_date}</td>
						<td><c:choose>
								<c:when test="${report.value>75}">
									<p class="text-success">${report.value}</p>
								</c:when>
								<c:when test="${report.value < 75}">
									<p class="text-danger">${report.value}</p>
								</c:when>

								<c:otherwise>

								</c:otherwise>
							</c:choose></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</div>










