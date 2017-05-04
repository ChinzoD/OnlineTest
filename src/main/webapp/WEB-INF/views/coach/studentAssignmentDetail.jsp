<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="content">
	<div class="portlet light">
	
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
						<td><label class="control-label">${student.email}  </label></td>
					</tr>
	
				
				
					<tr>
						<td><label class="control-label" > Access Link </label></td>
						<td><label class="control-label" id="accessLink" name="accessLink" value="">  </label>			
						</td>
					
					</tr>
				
					<tr>
						<td><label class="control-label" > Access Code </label>	</td>
						<td><label class="control-label" id="accessCode" name="accessCode" value="">  </label>
						</td>
					</tr>
		
					<tr>
						<td><button type="button" id="generate-test-btn" onclick="generateAccessCode()" name="generate-test-btn" class="btn ">Generate Test</button>
			  				<button type="button" id="send-test-btn" class="btn">Send</button>
						</td>
						
					</tr>
			</tbody>
		</table>
	
			<div class="form-actions">
				<button  type="button" id="student-assignment-donebtn" onclick="assignmentDone(${student.userId})"
			     class="btn btn-success uppercase pull-right">Done</button>
			</div>
			<br/><br/>
	
	</div>
</div>


<script src="<c:url value="/metronic/assets/coach/scripts/assignment.js" />" type="text/javascript"></script>

