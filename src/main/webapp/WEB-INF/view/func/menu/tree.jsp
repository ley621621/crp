<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="system.menu" /></title>
<!-- Css for boot -->
<link href="${ctx}/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!--Admin Core Css-->
<link href="${ctx}/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!-- My Fonts -->
<link href="${ctx}/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--Tree-->
<link rel="stylesheet" href="${ctx}/static/lib/ztree/css/demo.css" />
<link rel="stylesheet" href="${ctx}/static/lib/ztree/css/zTreeStyle.css" />
<style>
	label{ margin:0px;} 
	.form-control{ padding: 0px ; border-radius: 0px;}
	ul.ztree{ border:0px; background:#fff;}
</style>
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<!--Tree-->
<script src="${ctx}/static/lib/ztree/jquery.ztree.core.js" type="text/javascript"></script>

<script type="text/javascript">
	var setting = {
		data: {
			simpleData: {
				enable: true
			}
		}
	};

	var zNodes =${tree}

	$(document).ready(function(){
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
	
	function _toAddMenu(pId){
		parent.$("#add_a").show();
		var src = "${ctx}/func/menu/to_add_menu?pId=" + pId;
		parent.$("#add_iframe").prop("src", src);
	}
	
</script>

</head>
<body>
	<div class="tree_grid1">
   		<ul id="treeDemo" class="ztree"></ul>
  	</div>
</body>
</html>