<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="content">
	<div class="portlet light">
		<div id="errorMessage" class="alert alert-warning hidden" ></div>
		<input type="hidden" value="${assignment.accesscode}" id="sentEmail" />	
		<h3>Student Assignment Detail</h3>
	
		<table class=" table-hover "
			id="sample_editable_1">
			
			<tbody>
					<tr>
						<td style="width:25%"><label class="control-label">Student ID:</label></td>
						<td><label class="control-label">${student.studentId} </label></td>
					</tr>
				
					<tr>
						<td><label class="control-label">Student Name:</label></td>
						<td><label class="control-label">${student.firstName} ${student.lastName}   </label></td>
					</tr>
				
					<tr>
						<td><label class="control-label">Student Email:</label></td>
						<td><label class="control-label" id="email" name="email">${student.email}  </label></td>
					</tr>
	
				
				
					<tr>
						<td><label class="control-label" > Access Link </label></td>
						<td><input type="text" class="control-label" readonly="readonly"  id="accessLink" name="accessLink" value="<c:if test='${not empty assignment.accesscode}'> '<c:out value='www.test.com' />' </c:if>" /> 			
						</td>
					
					</tr>
				
					<tr>
						<td><label class="control-label" > Access Code </label>	</td>
						<td> <input type="text" class="control-label" value="${assignment.accesscode}" readonly="readonly" id="accessCode" name="accessCode"/>
						</td>
					</tr>
		
					<tr>
						<td><button type="button" id="generate-test-btn" onclick="generateAccessCode()" name="generate-test-btn" class="btn btn-success">Generate Test</button>
			  				<button type="button" id="send-test-btn" onclick="sendEmail(${student.userId})" name="send-test-btn" class="btn btn-success">Send Email</button>
						</td>
					</tr>
			</tbody>
		</table>
	
			<div class="form-actions">
				<button  type="button" id="student-assignment-cancelbtn" onclick="assignmentCancel()"
			     class="btn btn-success uppercase pull-right ">Cancel</button>
			     
				<button  type="button" id="student-assignment-donebtn" onclick="assignmentDone(${student.userId})"
			     class="btn btn-success uppercase pull-right">Save</button>			     
			</div>
	</div>
</div>
<script src="<c:url value="/metronic/assets/coach/scripts/assignment.js" />" type="text/javascript"></script>

