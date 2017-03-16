<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<!-- Css for boot -->
<link href="${ctx}/static/public/css/boot.css" rel="stylesheet"
	type="text/css" />
<!--Admin Core Css-->
<link href="${ctx}/static/public/css/admin.css" rel="stylesheet"
	type="text/css" />
<!-- My Fonts -->
<link href="${ctx}/static/lib/iconfont/iconfont.css" rel="stylesheet"
	type="text/css" />

<style>
label {
	margin: 0px;
}

.form-control {
	padding: 0px;
	border-radius: 0px;
}
</style>

<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js"
	type="text/javascript"></script>
<!-- 弹窗插件 -->
<script src="${ctx}/static/lib/layer/layer.js"></script>

<script type="text/javascript">

	function change_password() {
		var msg = $("#msg");		
		var old_password = $("input[name='old_password']").val();
		var new_password = $("input[name='new_password']").val();
		var password = $("input[name='password']").val();
		
		if(old_password == "" || new_password == "" || password == "") {
			msg.html('密码不能为空');
		} else {
			if(old_password != "") {
				var url = "${ctx}/check_password";
				var param = {
						"password": old_password
				}
				$.post(url, param, function(data){
					data = eval("(" + data + ")");
					if(data.success) {
						if(new_password != password) {
							msg.html('两次输入密码不相同');
						} else {
							var url = "${ctx}/change_password";
							var param = {
									"password": password
							}
							$.post(url, param, function(data){
								data = eval("(" + data + ")");
								if(data.success) {
									layer.alert('修改成功', {icon: 6, btn:['确定'], title:'信息'}, function(index){
										layer.close(index);
				                        parent.window.location.href = "${ctx}/logout";
									});
								} else {
									msg.html('修改成功');
								}
							});
						}
					} else {
						msg.html('原密码输入错误，请重试');
					}
				});
			}
		}
		
		
	}
	
</script>

</head>

<body>
	<form id="form1" method="post">
		<input type="hidden" name="pkBusiness" value="${pkBusiness }" />
		<input type="hidden" name="type" value="${type }" />
		<div class="space1"></div>
		<div class="space1"></div>
		<div class="space1"></div>
		<div class="container-fluid">
							<div class="row">
								<div class="col-lg-12">
									<div class="">
										<div class="form_gridinner" style="width:70%; margin:0px auto;">
											<div class="row form-group">
												<label class="col-lg-4 form_name">原密码&nbsp;&nbsp;</label>
												<div class="col-lg-8 form_name" style="text-align:left;">
													<input name="old_password" type="password" class="form-control" />
												</div>
												<div class="clear"></div>
											</div>
											<div class="row form-group">
												<label class="col-lg-4 form_name" >新密码&nbsp;&nbsp;</label>
												<div class="col-lg-8 form_name" style="text-align:left;">
													<input name="new_password" type="password" class="form-control" />
												</div>
												<div class="clear"></div>
											</div>
											<div class="row form-group">
												<label class="col-lg-4 form_name" >确认密码&nbsp;&nbsp;</label>
												<div class="col-lg-8">
													<input name="password" type="password" class="form-control" />
												</div>
												<div class="clear"></div>
											</div>
											<div class="row">
							                <div class="col-lg-12" style="text-align:center;"><span id="msg"></span></div>
						                    </div>
										</div>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							
							<div class="space1"></div>
						    <div class="space1"></div>
						
						<div class="row">
						<div class="col-lg-3">
						</div>
						
						<div class="col-lg-3">
							<a href="javascript:void(0)" onclick="change_password()"
								class="btn btn-sm btn-primary  publish"
								style="width: 100px; margin-left: 60px;"><i
								class="icon iconfont"
								style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px;">&#xe60a;</i>&nbsp;&nbsp;保存</a>
								</div>
						<div class="col-lg-3">
						<div class="clear"></div>
						</div>
						</div>

		</div>
	</form>
</body>
</html>