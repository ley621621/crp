<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中粮风险评分系统</title>

<!-- Custom Fonts -->
<link href="${ctx}/static/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- Css for boot -->
<link href="${ctx}/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!-- Css for login -->
<link href="${ctx}/static/public/css/login.css" rel="stylesheet" type="text/css">
<!-- Css for user -->
<link href="${ctx}/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>

<script>
$(function(){
	var msg = $("#msg");
	if(msg.text().trim() != '') {
		msg.show();
	}
	document.onkeydown = function(e){ 
	    var ev = document.all ? window.event : e;
	    if(ev.keyCode==13) {
	    	_doLogin();
	    }
	}
	document.getElementById("account").focus(); 
	
});

function _doLogin() {
	
	var account = $("input[name='account']").val();
	var password = $("input[name='password']").val();
	
	var msg = $("#msg");
	msg.css('display','block');
	msg.empty();
	if($.trim(account) == "") {
		msg.html('用户名不能为空!');
	} else if($.trim(password) == "") {
		msg.html('密码不能为空!');
	} else {
		msg.css('display','none');
		$("#loginForm").submit();
	}
}

</script>
<style type="text/css">
.languge{ text-align:center;color:#fff ; line-height: 35px;}
.languge a{ color:#fff ; text-decoration: none;}
</style>
</head>

<body>
	<div class="img_bg">
		<img src="${ctx}/static/public/images/bg.jpg" width="100%" height="100%" />
	</div>
	<div class="login">
		<div class="login_inner">
			<form id="loginForm" action="${ctx}/check_login" method="post">
				<ul class="login_input">
					<li>
						<div style="width:100% ; height: 46px;"></div>
						<div  style="padding:6px 12px; margin-top:5px; text-align:center; color:orange; width:90%; height:16px; ">
							<span id="msg" style="display:none;">${login_message }</span>
						</div>
					</li>
					<li class="login_inputblank2">
						<input type="text" name="account" id="account" class="login_input1" />
					</li>
					<li class="login_inputblank3"></li>
					<li class="login_inputblank4">
						<input type="password" name="password" autocomplete="off" class="login_input1" />
					</li>
					<li class="login_inputblank5"></li>
					<li class="login_inputblank5">
						<a href="javascript:;" onclick="_doLogin();" class="btn btn-primary btn-login" style="width: 100%; padding: 6px 0px;">
							登录
						</a>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
</html>
