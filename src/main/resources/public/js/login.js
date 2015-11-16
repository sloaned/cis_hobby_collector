

$(document).ready(function(){
	$(".error").empty();
	
	$("#registerSubmit").click(function(event){
		event.preventDefault();
		$("#registerError").empty();

		var username = $("#registerUsername").val();
		var password1 = $("#registerPassword1").val();
		var password2 = $("#registerPassword2").val();
		if(username === "" || password1 === "" || password2 === "")
		{
			$("#registerError").val(errorStart + "All fields are required" + messageEnd);
			return;
		}
		else if(password1 != password2)
		{
			$("#registerError").val(errorStart + "Passwords do not match" + messageEnd);
			return;
		}
		var user = {};
		user.username = username;
		user.password = password1;
		$.ajax({
	        url: '/users/'+username,
	        method: 'GET',
	    }).then(function(User){
	    	if(User === null)
	    	{
	    		$.ajax({
	    	        url: '/users',
	    	        method: 'POST',
	    	        contentType: 'application/json',
	    	        data: JSON.stringify(user)
	    	    }).then(function(){
	    	        console.log("Post successful")
	    	        $("#registerError").val(successStart + "Success! You may now log in" + messageEnd);
	    	    }, function(error){
	    	        console.log(error);
	    	    });
	    	}
	    	else
	    	{
	    		$("#registerError").val(errorStart + "That username is already in use" + messageEnd);
	    	}
	    }, function(error){
	        console.log(error);
	    });
	});
	
	$("#loginSubmit").click(function(event){
		event.preventDefault();
		loginSubmit();
	});
});

var successStart = "<div class='alert alert-success'><strong><span class='glyphicon glyphicon-ok'></span>";
var errorStart = "<div class='alert alert-danger'><span class='glyphicon glyphicon-remove'></span><strong>";
var messageEnd = "</strong></div>";

function registerSubmit(){
	$("#registerError").empty();

	var username = $("#registerUsername").val();
	var password1 = $("#registerPassword1").val();
	var password2 = $("#registerPassword2").val();
	if(username === "" || password1 === "" || password2 === "")
	{
		$("#registerError").val(errorStart + "All fields are required" + messageEnd);
		return;
	}
	else if(password1 != password2)
	{
		$("#registerError").val(errorStart + "Passwords do not match" + messageEnd);
		return;
	}
	var user = {};
	user.username = username;
	user.password = password1;
	$.ajax({
        url: '/users/'+username,
        method: 'GET',
    }).then(function(User){
    	if(User === null)
    	{
    		$.ajax({
    	        url: '/users',
    	        method: 'POST',
    	        contentType: 'application/json',
    	        data: JSON.stringify(user)
    	    }).then(function(){
    	        console.log("Post successful")
    	        $("#registerError").val(successStart + "Success! You may now log in" + messageEnd);
    	    }, function(error){
    	        console.log(error);
    	    });
    	}
    	else
    	{
    		$("#registerError").val(errorStart + "That username is already in use" + messageEnd);
    	}
    }, function(error){
        console.log(error);
    });
};

function loginSubmit(){
	$("#loginError").empty();
	var username = $("#loginUsername");
	var password = $("#loginPassword");
	if(username === null || password === null)
	{
		$("#loginError").val(errorStart + "All fields are required" + messageEnd);
		return;
	}
	$.ajax({
        url: '/users/'+username,
        method: 'GET',
    }).then(function(User){
    	if(User === null)
    	{
    		$("#loginError").val(errorStart + "Username does not exist" + messageEnd);
    		return;
    	}
    	else
    	{
    		if(User.password != password)
    		{
    			$("#loginError").val(errorStart + "Username/password do not match" + messageEnd);
        		return;
    		}
    		else
    		{
    			location.href("/home");
    		}
    	}
    }, function(error){
        console.log(error);
    });
}