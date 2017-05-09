<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="content">
	<div class="portlet light">


		<h3 class="panel-title">Student Name:
			${assignment.studentId.firstName} ${assignment.studentId.lastName}</h3>
		<h3 class="panel-title">Student Id:
			${assignment.studentId.userId}</h3>
		<h3 class="panel-title">Questions</h3>


		<div class="portlet-body form">
			<form class="form-horizontal" role="form">
				<div class="form-body">
					
						<label id="description">${test.question.description}</label>
						<div class="radio-list" id="qList">
							<c:forEach items="${test.question.choices}" var="choice">
								<label><input type="radio" name="optionsRadios" id="optionsRadios${choice.id}"
									value="${choice.id}"> ${choice.description} </label>
							</c:forEach>
						</div>
					<br/>
					<input class="btn btn-lg btn-success btn-mini btnPrev"
						type="button" id="0" style="display: none;" value="Previous">
					<input class="btn btn-lg btn-success btn-mini btnNext"
						type="button" id="0" value="Next">
				</div>
			</form>
		</div>

	</div>
</div>
