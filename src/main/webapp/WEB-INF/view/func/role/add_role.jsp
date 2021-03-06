<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="system.role.addRole" /></title>
<!-- Css for boot -->
<link href="${ctx }/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!--Admin Core Css-->
<link href="${ctx }/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!-- My Fonts -->
<link href="${ctx }/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--Tree Menu-->
<link href="${ctx }/static/lib/tree-menu/tree.css" rel="stylesheet" type="text/css" />
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<!--layer JS--> 
<script src="${ctx }/static/lib/layer/layer.js" type="text/javascript"></script> 
<script type="text/javascript">
function saveRole() {
	//验证名称不能为空
	var name = $("input[name='name']").val();
	if(name == '') {
		layer.alert("名称不能为空", {icon: 6}, function(index){
			layer.close(index);
		});
		return;
	}
	//验证编号不能为空
	var code = $("input[name='code']").val();
	if(code == '') {
		layer.alert("编号不能为空", {icon: 6}, function(index){
			layer.close(index);
		});
		return;
	}
	var url = "${ctx}/func/role/do_add_role";
	var param = $("#roleForm").serialize();
	$.post(url, param, function(data){
		data = eval("(" + data + ")");
		if(data.success) {
			layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示信息'}, function(index){
				layer.close(index);
				parent.location.reload(); 
			});
		} else {
			layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示信息'});
		}
	});
	
}
</script>
<style>
label {
	margin: 0px;
}
.form-control {
	padding: 0px;
	border-radius: 0px;
}
</style>



</head>

<body>
<div class="space1"></div>
<div class="space1"></div>
<div class="container-fluid">
	<div class="row">
	    <div class="col-lg-12">
	    	<form id="roleForm">
	      		<div class="panel panel-default">
	        		<div class="panel-body">
	          			<div class="row">
	           				<div class="col-lg-12">
	              				<div class="">
	                				<div class="form_gridinner">
	                  					<div class="row">
	                   						 <div class="clear"></div>
	                  					</div>
	                  					<div class="row form-group">
	                    					<label class="col-lg-2 form_name"><span class="red">*</span>名称&nbsp;&nbsp;</label>
	                   						<div class="col-lg-10">
	                      						<input type="text" class="form-control" name="name"/>
	                   						</div>
	                    					<div class="clear"></div>
	                  					</div>
	                  					<div class="row form-group">
	                  						<label class="col-lg-2 form_name"><span class="red">*</span>编号&nbsp;&nbsp;</label>
	                    					<div class="col-lg-10">
	                      						<input type="text" class="form-control" name="code"/>
	                      						<input type="hidden" class="form-control" name="state" value="0"/>
	                    					</div>
	                    					<div class="clear"></div>
	                  					</div>
	                				</div>
	           					</div>
	           				</div>
	            			<div class="clear"></div>
	       				</div>
	          			<div class="row">
	            			<div class="col-lg-12">
	              				<div class="">
	              				</div>
	            			</div>
	            			<div class="clear"></div>
	          			</div>
	        		</div>
	        		<div class="panel-footer">
	        			<a href="javascript:void(0)" onclick="saveRole()" class="btn btn-sm btn-primary pull-right publish" style="width:100px; margin-left: 10px;" >
	        				<i class="icon iconfont" style="font-family:'Arial Black', Gadget, sans-serif; font-size:14px;">&#xe60a;</i>
	        				&nbsp;&nbsp;保存
	       				</a>
	        			<div class="clear"></div>
	        		</div>
	      		</div>
	   		</form>
		</div>
	</div>
</div>
</body>
</html>