

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ page session="false"%>

 
                                          
                                           <section id="posts-landing">
                                                <div id="report" class="portlet light ">
                                                    <div class="portlet-title">
                                                        <div class="caption">
                                                            <span class="caption-subject bold uppercase font-dark">Student Test Score </span>                                                       
                                                            
                                                        </div>
                                                        <div class="actions">
                                                         <jsp:useBean id="now" class="java.util.Date"/> 
                                                           Date Time :
                                                            <fmt:formatDate value="${now}" pattern="dd-MM-yyyy HH:mm:ss a z" />
                                                            <a class="btn btn-circle btn-icon-only btn-default" href="#">
                                                                <i class="icon-cloud-upload"></i>
                                                            </a>
                                                            <a class="btn btn-circle btn-icon-only btn-default" href="#">
                                                                <i class="icon-wrench"></i>
                                                            </a>
                                                            <a class="btn btn-circle btn-icon-only btn-default" href="#">
                                                                <i class="icon-trash"></i>
                                                            </a>
                                                            <a class="btn btn-circle btn-icon-only btn-default fullscreen" href="#" data-original-title="" title=""> </a>
                                                        </div>
                                                    </div>
                                                    <div class="portlet-body">
                                                    

    <h3><span>Student Profile </span> </h3>                                                   
	<div class="row">
  <div class="col-md-4">
		
				
		
                 
                  <table class="table table-sm">
                  <thead>
				<tr>
					<th></th>
					<th>Student Information </th>
					
				</tr>
			</thead>
                    <tbody>
                     
                      <tr>
                        <td>Student ID </td>
                        <td>${studentAssignment.studentId.studentId}</td>
                      </tr>
                      <tr>
                        <td>Full Name </td>
                        <td>${studentAssignment.studentId.firstName} ${studentAssignment.studentId.lastName}</td>
                      </tr>
                   
                         
                             <tr>
                        <td>Entry </td>
                        <td>${studentAssignment.studentId.entry}</td>
                      </tr>
                      <tr>
                        <td>Phone No </td>
                        <td>641-451-3529</td>
                      </tr>
                      <tr>
                        <td>Email Address </td>
                        <td><a href="${studentAssignment.studentId.email}">${studentAssignment.studentId.email}</a></td>
                      </tr>
                      
                        <tr>
                        <td>Exam Date  </td>
                        <td>${studentAssignment.start_date}</td>
                      </tr>
                      <tr>
                        <td>Invited By  </td>
                        <td>${studentAssignment.coachId.firstName}${studentAssignment.coachId.lastName}</td>
                      </tr>     
                   <tr>
                        <td>Time Alloted  </td>
                        <td>2:00 Hour</td>
                      </tr>
                     
                    </tbody>
                  </table>
                 
                  <a href="#" class="btn btn-primary">Give Us Your Feedback </a>     
                  <button type="button" class="btn btn-info" onclick="javascript:demoFromHTML();">Export to PDF</button>     
                         
                </div>
           
     
	
	<span class="label label-info"> Score Detail </span>
	<br>
	<div class="col-md-4"><table class="table table-sm">
			<thead>
				<tr>
					<th>Category</th>
					<th>SubCategory</th>
					<th>Result</th>					
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${reports}" var="report">
					<tr>
						<td>${report.key.category.name}</td>
					    <td>${report.key.name}</td>
						<td><span class="label label-success"> ${report.value}</span> </td>
																	
					</tr>
				</c:forEach>
			</tbody>
		</table></div>
		<span class="label label-info"> Overall Score </span>
		<br>
	<div class="col-md-4"><h3>${total} Out of ${questions}</h3> </div>

</div>
  
  </div>  
</div>
</section>
<div id="editor"></div>
	

		
                                               
                                                                                 
                                            
