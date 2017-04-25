<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="content">
	<div class="portlet light">
		<c:if test="${not empty success}">
			<c:out value="${success}" />
		</c:if>
		<h3>Assign Coach</h3>
		<p class="hint">Enter your personal details below:</p>
		<div class="form-group">
			<label class="control-label">Coach</label> <select
				class="select2_category form-control coachId"
				data-placeholder="Choose a Coach" tabindex="1">
				<c:forEach items="${coaches}" var="coach">
					<option value="${coach.userId}">${coach.firstName} ${coach.lastName}</option>
				</c:forEach>
			</select>
			<form:errors cssClass="text-danger" />
		</div>
		<div class="form-group">
			<label class="control-label">Student</label> <select
				class="select2_category form-control studentId"
				data-placeholder="Choose a Student" tabindex="1">
				<c:forEach items="${students}" var="student">
					<option value="${student.userId}">${student.firstName} ${student.firstName}</option>
				</c:forEach>
			</select>
			<form:errors cssClass="text-danger" />
		</div>
		<!-- <div class="form-actions">
				<button type="submit" id="register-submit-btn"
					class="btn btn-success uppercase pull-right">Submit</button>
			</div> -->
		<br /> <br />
	</div>
</div>
