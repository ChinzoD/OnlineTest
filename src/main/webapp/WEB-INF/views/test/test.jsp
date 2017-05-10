<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="content">
	<div class="portlet light">
		<h3 class="">Student Name: ${assignment.studentId.firstName}
			${assignment.studentId.lastName}</h3>
		<%-- <h3 class="">Student Id:
			${assignment.studentId.userId}</h3> --%>
		<h3 class="questionNumber">Questions 1/80</h3>
		<hr>
		<div class="portlet-body form">
			<form class="form-horizontal" role="form">
				<div class="form-body" id="radOption">
						<label id="description"><h4>${test.question.description}</h4></label>
						<div class="radio-list" id="qList">
							<c:forEach items="${test.question.choices}" var="choice">
								<label><input type="radio" name="optionsRadios"
									id="optionsRadios${choice.id}" value="${choice.id}">
									${choice.description} </label>
							</c:forEach>
						</div>
						<br /> <input class="btn btn-lg btn-success btn-mini btnPrev"
							type="button" id="0" style="display: none;" value="Previous">
						<input class="btn btn-lg btn-success btn-mini btnNext"
							type="button" id="0" value="Next">
						<a href="#myModal3" role="button" style="display: none;" class="btn btn-lg btn-success btnTestSubmit" data-toggle="modal">
							Submit for grading </a>
				</div>
			</form>
		</div>
		<div id="myModal3" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel3" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true"></button>
						<h4 class="modal-title">Confirm Header</h4>
					</div>
					<div class="modal-body">
						<p>Do you want to submit for grading?</p>
					</div>
					<div class="modal-footer">
						<button class="btn default" data-dismiss="modal"
							aria-hidden="true">Close</button>
						<button data-dismiss="modal" class="btn blue btnTestFinish">Confirm</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
