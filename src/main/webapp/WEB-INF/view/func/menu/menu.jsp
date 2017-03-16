<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="system.menu" /></title>
<!-- Css for boot -->
<link href="${ctx}/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!--Admin Core Css-->
<link href="${ctx}/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!-- My Fonts -->
<link href="${ctx}/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<style>
	label{ margin:0px;} 
	.form-control{ padding: 0px ; border-radius: 0px;}
</style>
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<!-- 弹窗插件 -->
<script src="${ctx}/static/lib/layer/layer.js"></script>

<script type="text/javascript">
	function _backMenuList(){
		location.href = "${ctx }/func/menu/to_menu_list"
	}
	
	function _addMenu(){
		var url = $("#add_iframe").contents().find("#addMenuForm").prop("action");
		var param = $("#add_iframe").contents().find("#addMenuForm").serialize();
		$.post(url, param, function(data){
			data = eval("(" + data + ")");
			if(data.success) {
				layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示信息'}, function(index){
					location.href = "${ctx }/func/menu/to_menu"
				});
			} else {
				layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示信息'});
			}
		});
	}
	
</script>

</head>
<body>
	<div class="row">
		<div class="col-lg-12 now_position">
			<i class="icon iconfont" style="font-family:'Arial Black', Gadget, sans-serif; font-size:14px;">&#xe62d;</i>
			首页&nbsp;/&nbsp;系统管理&nbsp;/&nbsp;菜单管理&nbsp;/&nbsp;新增菜单
		 </div>
	</div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="container-fluid">
		<div class="row">
	    	<div class="col-lg-12">
	      		<div class="panel panel-default">
	        		<div class="panel-heading">
	          			<div class="pull-left list_name">新增菜单</div>
	          			<div class="pull-left" style="margin-left:30px;">
            				<input type="hidden" id="corpName"/>
            			</div>
	          			<div id="div_text" class="pull-right"></div>
	        		</div>
	        		<div class="panel-body">
	         			<div class="row">
	            			<div class="col-lg-2">
	            				<iframe id="tree_iframe" src="${ctx }/func/menu/to_tree" frameborder="0" scrolling="auto" allowtransparency="true" width="16%"  style="position:fixed; left:3%; top: 130px;" height="350"></iframe>
	            			</div>
	            			<div class="col-lg-10">
	            				<iframe id="add_iframe" frameborder="0" scrolling="auto" allowtransparency="true" width="100%" height="350"></iframe>
	            			</div>
	            			<div class="clear"></div>
	          			</div>
	        		</div>
	       			<div class="panel-footer">       
	       				<a href="javascript:;" onclick="_addMenu();" id="add_a" class="btn btn-sm btn-primary pull-right" style="width:100px; margin-left: 10px; display: none;" >
	       					<i class="icon iconfont" style="font-family:'Arial Black', Gadget, sans-serif; font-size:14px;">&#xe60a;</i>
	       					&nbsp;&nbsp;保存
	       				</a>
	       				<a href="javascript:;" onclick="_backMenuList();" class="btn btn-sm btn-default pull-right" style="width:100px; margin-left: 10px;" >
	       					<i class="icon iconfont" style="font-family:'Arial Black', Gadget, sans-serif; font-size:14px;">&#xe60c;</i>
	       					&nbsp;&nbsp;返回
	       				</a>
	       				<div class="clear"></div>
	       			</div>
	      		</div>
	    	</div>
		</div>
	</div>
</body>
</html>