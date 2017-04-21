var onCall = false;

$(document).ready(function(){/* off-canvas sidebar toggle */
	$('[data-toggle=offcanvas]').click(function() {
		$(this).toggleClass('visible-xs text-center');
		$(this).find('i').toggleClass('glyphicon-chevron-right glyphicon-chevron-left');
		$('.row-offcanvas').toggleClass('active');
		$('#lg-menu').toggleClass('hidden-xs').toggleClass('visible-xs');
		$('#xs-menu').toggleClass('visible-xs').toggleClass('hidden-xs');
		$('#btnShow').toggle();
	});



	/*
	$.notify({
		path : "http://feeds.bbci.co.uk/news/rss.xml", //required
		interval : 2,      //optional (number of seconds between requests, default is 60)
		callback : function(json){}, //optional (when new results are found they are sent to this function)
		initial : false     //optional (this just shows notifications on the first pass, by default this is true, and we wont see the diference)
	});
	*/
		
	/* ============ notify new post ============ */
	function generate(container, type, totalNewPost) {
		var n = $(container).noty({
			text        : 'There are '+totalNewPost+' new post(s)',
			type        : type,
			dismissQueue: true,
			layout      : 'topCenter',
			theme       : 'relax',
			timeout     : false, // delay for closing event. Set false for sticky notifications
			closeWith: ['click'],  // ['click', 'button', 'hover', 'backdrop'] // backdrop click will close all notifications
			maxVisible  : 5, // you can set max visible notification for dismissQueue true option,
			callback: {
		        onClose: function() {
		        	var lastDate = $('#lastDatePost').data('lastdatepost'); 
		    		var userId = $('#userId').data('userid'); 
		        	onCall = true;
		        	$.post("post",{command:"loadNewPost",lastDatePost:lastDate, userId:userId},"json")
		    		.done(loadNewPost)
		    		.fail(function(xhr,err) {
		                alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
		            });
		        	//setTimeout(callNewPost(), 0);return false;
		        }
		    }
		});
		
		console.log('html: ' + n.options.id);
	}
	
	function callNewPost(){
		var lastDate = $('#lastDatePost').data('lastdatepost'); 
		var idOfUser = $('#userId').data('userid'); 
    	onCall = true;
    	$.post("post",{command:"loadNewPost",lastDatePost:lastDate, userId:idOfUser},"jsonp")
		.done(loadNewPost)
		.fail(function(xhr,err) {
            alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
        });
	}
	
	function loadNewPost(data){
		onCall = false;
		if (data != undefined)
	    {
			$('#lastDatePost').data('lastdatepost',data.lastDatePost); 
	
			var post = $('#postList');
			var userId = $('#userId').data('userid'); 
			var content= '';
			$.each(data.newPost, function(i, post) {
				content += '<div class=\"panel panel-default\" id=\"post' + post.postid +'.\">';
				content += ' <div class=\"panel-heading\">';
				if (userId == post.user.userid)
				{
					content += '  <button id=\"btnDelPost\" data-postid=\"' + post.postid +'\" class=\"btn btn-xs btn-default pull-right\">X</button>';
				}
				content += '  <strong>' + post.user.username +'</strong> ' + post.datecreated +'</div>';
				content += '  <div class=\"panel-body\">';
				content += '	<p><a href=\"#\">Like</a>&nbsp;&nbsp;<span class=\"glyphicon glyphicon-thumbs-up\"> ' + post.likes +'</span></p>';
				content += '	<div class=\"clearfix\"></div>';
				content += '	<hr>';
				$.each(post.comments, function(i, comment) {
					content += '     <p><span id=\"userID\"><strong>'+comment.user.username+'</strong></span>'+comment.comment+'</p>';	
				});	
				content += '	<hr>';
				content += '	<form>';
				content += '	<div class=\"input-group\">';
				content += '	  <input type=\"text\" class=\"form-control\" placeholder=\"Add a comment..\">';
				content += '	  <div class=\"input-group-btn\">';
				content += '	  <button class=\"btn btn-default\"><i class=\"glyphicon glyphicon-share\"></i></button>';
				content += '	  </div>';
				content += '	</div>';
				content += '	</form>';
				content += '  </div>';
				content += '</div>';
			 });
			
			post.prepend(content);
	    }
	}

	function generateAll(data) {
		onCall = false;
		
		if (data != undefined && data.totalNewPost > 0)
		{
			
			generate('div#notification', 'alert', data.totalNewPost);
		}
	}
	
	function checkNewPost(){
		var lastDate = $('#lastDatePost').data('lastdatepost'); 
		var userId = $('#userId').data('userid'); 
		if (onCall == false)
		{
			onCall = true;
			$.post("post",{command:"getNewPost",lastDatePost:lastDate, userId:userId},"json")
				.done(generateAll)
				.fail(function(xhr,err) {
		            alert('Ajax readyState: '+xhr.readyState+'\nstatus: '+xhr.status + ' ' + err);
		        });
		}
	}

	/*
	$(document).ready(function () {
		setInterval(() => {
			checkNewPost();
		}, 3000);
	});
	*/
	$('#btnSearch').on('click', function(){
		//checkNewPost();
		callNewPost();
		return false;
	});
	
	/* ============ notify new post ============ */
	
	/* Change the post type */
	$('#radioBtn a').on('click', function(){
		var sel = $(this).data('title');
		var tog = $(this).data('toggle');
		$('#'+tog).prop('value', sel);
		
		var inputVal = $('#'+tog).val();
		
		if (inputVal=='Y'){
			// to do call all asking for a ride
			alert('asking for a ride');
		}
		else {
			// to do call all offering for a ride
			alert('offering for a ride');
		}
		
		$('a[data-toggle="'+tog+'"]').not('[data-title="'+sel+'"]').removeClass('active').addClass('notActive');
		$('a[data-toggle="'+tog+'"][data-title="'+sel+'"]').removeClass('notActive').addClass('active');
	})
	
	/* Delete post */
	function deletePostSuccess(data){
		// to do remove the post
		if (data != undefined && data != null){
			var pnlPost = $('#post'+data('postid'));
			//$(pnlPost).
		}
	}
	
	$(document).on("click", "#btnDelPost" , function() {
		var result = confirm("Want to delete this post ?");
		if (result) {
			var postid = $(this).data('postid');
			$.post("http://localhost:8080/carpool/user/post",{command:"del",postID:postid}).done(deletePostSuccess);
		}
    });
		
});