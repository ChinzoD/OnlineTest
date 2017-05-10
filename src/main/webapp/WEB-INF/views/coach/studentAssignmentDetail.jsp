<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="content">
	<div class="portlet box blue">
		<div class="portlet-title">
			<div class="caption">
				<i class="fa fa-gift"></i>Student Assignment Detail
			</div>
		</div>
		<div class="portlet-body form">
		<div id="errorMessage" class="alert alert-warning hidden"></div>
		<input type="hidden" value="${assignment.accesscode}" id="sentEmail" />
		<form action="#" class="form-horizontal">
		<div class="form-body">
			<div class="form-group">
				<label class="col-md-3 control-label">Student</label>
				<div class="col-md-3">
					<p class="form-control-static">${student.studentId}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Student Name:</label>
				<div class="col-md-3">
					<p class="form-control-static">${student.firstName} ${student.lastName}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Student Email:</label>
				<div class="col-md-4">
					<p class="form-control-static" id="email" name="email">${student.email}</p>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Access Link</label>
				<div class="col-md-4">
					<div class="input-icon">
						<input type="text" class="form-control" id="accessLink" name="accessLink" readonly="readonly" value="www.test.com">
					</div>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-3 control-label">Access Code</label>
				<div class="col-md-4">
					<div class="input-icon">
						<input type="text" class="form-control" value="${assignment.accesscode}" readonly="readonly"
							id="accessCode" name="accessCode" >
					</div>
				</div>
			</div>
		</div>
		<div class="form-actions">
			<div class="row">
				<div class="col-md-offset-3 col-md-9">
					<button type="button" id="generate-test-btn"
							onclick="generateAccessCode()" name="generate-test-btn"
							class="btn btn-circle blue">Generate Test</button>
					<button type="button" id="send-test-btn"
							onclick="sendEmail(${student.userId})" name="send-test-btn"
							class="btn btn-circle blue">Send Email</button>
					<button type="button" id="student-assignment-cancelbtn" onclick="assignmentCancel()" 
							class="btn btn-circle blue uppercase pull-right ">Cancel</button>
					<button type="button" id="student-assignment-donebtn"
						onclick="assignmentDone(${student.userId})"
						class="btn btn-circle blue uppercase pull-right">Save</button>
				</div>
			</div>
		</div>
	</form>
	</div>
	</div>
</div>
<script src="<c:url value="/metronic/assets/coach/scripts/assignment.js" />" type="text/javascript"></script>

