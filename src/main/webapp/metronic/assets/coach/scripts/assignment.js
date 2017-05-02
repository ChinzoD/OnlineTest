

//$('#generate-test-btn').click(function() { 
		
	function generateAccessCode(){
		$.ajax({
			url:'http://localhost:8080/onlinetest/assignment/generateTest',
			type:"GET",
			success:function(data){
				
				
				$("#accessCode").html(data.accessCode);
				$("#accessLink").html(data.accessLink);
				
			}
		});
		
}
					



function assignmentDone(userId){
	

	$.ajax({ 
	   type: "POST",
	   url: 'http://localhost:8080/onlinetest/coach/saveAssignment',
	   data:{
		   userId:userId,
		   accessCode :$('#accessCode').html(),
		   accessLink:$('#accessLink').html(),
		   
	   },
	   success: function(data){        
		   
		   if(data === "success"){
			   window.location.href = "http://localhost:8080/onlinetest/coach/home";
			   
		   }
		   
	   }
	});

}