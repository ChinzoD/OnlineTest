<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page session="false"%>
<div class="portlet light ">
	<div class="portlet-title">
		<div class="caption">
			<span class="caption-subject bold uppercase font-dark">Revenue</span>
			<span class="caption-helper">distance stats...</span>
		</div>
		<div class="portlet-body">
			<div class="table-toolbar">
				<div class="row">
					<div class="col-md-6"></div>
				</div>
			</div>
			<br><br>
			
			<div class="row">
  <div class="col-md-8">
  
  <p>Student ID : ${student.studentId }</p>
  <p>Student Name  : ${student.firstName} ${student.lastName}</p>
  <p>Entry  : ${student.entry}</p>
  </div>
  <div class="col-md-4">
  <h2>Your Test Score </h2>
  
 <h1><span class="label label-info"> ${score} <span class="label label-danger"> ${percent}%</span></span> </h1>
 <h1> </h1>
    
  </div>
</div>
			<br><br>
			
			<table class="table table-striped table-hover table-bordered"
				id="sample_editable_1">
				<thead>
					<tr>
						<th>No</th>
						<th>Question</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${answers}" var="answer" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td> <a data-toggle="collapse" href="#${status.count}">${answer.value ? "&#x2705;" : "&#10060;"}
								${answer.key.question.description}</a>
							
								<div id="${status.count}" class="collapse">
									<ol type="A">
										<c:forEach items="${answer.key.question.choices}" var="choice">



											<li><c:choose>
													<c:when
														test="${choice.id == answer.key.answer and choice.answer==true}">
														<p class="text-success">${choice.description}</p>
													</c:when>
													<c:when
														test="${choice.id == answer.key.answer and choice.answer==false}">
														<p class="text-danger">${choice.description}</p>
													</c:when>
													<c:when
														test="${choice.id != answer.key.answer and choice.answer==true}">
														<p class="text-success">${choice.description}</p>
													</c:when>
													<c:when
														test="${choice.id != answer.key.answer and choice.answer==false}">
														<p>${choice.description}</p>
													</c:when>
													<c:otherwise>
            Do something...     
         </c:otherwise>
												</c:choose></li>


										</c:forEach>


									</ol>
								</div>

							</td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>
