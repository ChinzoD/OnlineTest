function generateAccessCode(){
	
	if( $('#accessCode').val() ) {
		$("#errorMessage").empty();
		var msg ="<strong>Warning! </strong>Student has already been assigned the test "		
		$("#errorMessage").append(msg);
		$("#errorMessage").removeClass("hidden");
		$("#errorMessage").show();
		return false;
	}

	$.ajax({
		url:'http://localhost:8080/onlinetest/assignment/generateTest',
		type:"GET",
		success:function(data){
			
			$("#accessCode").val(data.accessCode);
			$("#accessLink").val(data.accessLink);
			
		}
	});
	
}


function assignmentDone(userId){

	if( !$('#accessCode').val() ) {
		$("#errorMessage").empty();
		var msg ="<strong>Warning!</strong> access Code is empty, you can not save "		
		$("#errorMessage").append(msg);
		$("#errorMessage").removeClass("hidden");
		$("#errorMessage").show();
		return false;
	}
	
	if(!$("#sentEmail").val()){
		$("#errorMessage").empty();
		var msg ="<strong>Warning!</strong> You need to send test to student. Please send email "		
		$("#errorMessage").append(msg);
		$("#errorMessage").removeClass("hidden");
		$("#errorMessage").show();
		return false;
	}
	$.ajax({ 
	   type: "POST",
	   url: 'http://localhost:8080/onlinetest/coach/saveAssignment',
	   data:{
		   userId:userId,
		   accessCode :$('#accessCode').val(),
		   accessLink:$('#accessLink').val(),
		   
	   },
	   success: function(data){        
		   
		   if(data === "success"){
			   window.location.href = "http://localhost:8080/onlinetest/coach/home";
			   
		   }
		   
	   }
	});

}


function assignmentCancel(){

	window.location.href = "http://localhost:8080/onlinetest/coach/home";

}

function sendEmail(userId){
	var msg;
	if( !$('#accessCode').val() ) {
		$("#errorMessage").empty();
		msg ="<strong>Warning!</strong> access Code is empty, you can not send email please generate code "
	
		$("#errorMessage").append(msg);
		$("#errorMessage").removeClass("hidden");
		$("#errorMessage").show();
		return false;
	}
	
	$("#errorMessage").addClass("hidden");
	
	alert("accessLink:$('#accessLink').val(),"+$('#accessLink').val());
	
	$.ajax({
		url:'http://localhost:8080/onlinetest/coach/sendEmail',
		data:{
			 userId:userId,		
			 accessLink:$('#accessLink').val(),
			 accessCode:$('#accessCode').val(),
			 email:$('#email').html(), 
		},
		type:"GET",
		success:function(data){
			alert("data"+data)
			if(data=="success"){
				alert("email sent success")
				$("#errorMessage").empty();
				msg ="<strong>Success!</strong> Email has been sent successfully! "
				$("#errorMessage").append(msg);
				$("#errorMessage").removeClass("hidden");
				$("#sentEmail").val(true);
			}
			
				 
		}
	});

}

function saveJobSearchStatusChange(userId){

$.ajax({ 
   type: "POST",
   url: 'http://localhost:8080/onlinetest/coach/changeStudentJobSearchStatus',
   data:{
	   userId:userId,
	   jobSearchStatus :$('input[name=jobSearchStatus]:checked').val(),
	   
	   
   },
   success: function(data){        
	   
	   if(data === "success"){
		   window.location.href = "http://localhost:8080/onlinetest/coach/home";
		   
	   }
	   
   }
});

}