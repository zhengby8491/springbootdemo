$(function()
{
	init();
	initValidate();
})

function init()
{
//	$('.log-btn').click(function()
//	{
//		$('.log-status').addClass('wrong-entry');
//		$('.alert').fadeIn(500);
//		setTimeout("$('.alert').fadeOut(1500);", 3000);
//	});
	$('.form-control').keypress(function()
	{
		$('.log-status').removeClass('wrong-entry');
	});
	$("#loginBtn").off().on("click",function(){
		$("#form").submit();
	})
}

function initValidate()
{
	$("#form").validate({
		submitHandler : function(form)
		{
			formPost();
		},
		rules : {
			username : {
				required : true
			},
			password : {
				required : true
			}
		},
		onfocusout :false,
		OnSubmit: true,
		errorPlacement : function(error, element)
		{
		}
	})
}

function formPost()
{
	var param = {};
	param["username"] = $("#username").val();
	param["password"] = $("#password").val();
	Helper.post("/login/submit",param, function(result){
		if(result.ok)
		{
		 self.location="/index";
		} else {
			$("#password").addClass('wrong-entry');
			$("#password").siblings(".alert").text("用户名或密码错误").fadeIn(500);
			setTimeout("$('.alert').fadeOut(1500);", 3000);
		}
	});
}
