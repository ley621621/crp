<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="system.role" /></title>
<!-- Css for boot -->
<link href="${ctx }/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!--Admin Core Css-->
<link href="${ctx }/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!-- My Fonts -->
<link href="${ctx }/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<!--layer JS-->
<script src="${ctx }/static/lib/layer/layer.js" type="text/javascript"></script>
<script type="text/javascript">
function _doSetMenu() {
	var url = $("#roleForm").prop("action");
	var param = $("#roleForm").serialize();
	$.post(url, param, function(data){
		data = eval("(" + data + ")");
		if(data.success) {
			layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示'}, function(index){
				layer.close(index);
				parent.location.reload(); 
			});
		} else {
			layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示'});
		}
	});
	
}

function _checkedFirstMenu(menuId){
	var menuIds = $("[temp='second_menu_"+menuId+"']:checked");
	if(menuIds.length > 0){
		$("input[temp='first_menu_"+menuId+"']").prop("checked",true);
	}else{
		$("input[temp='first_menu_"+menuId+"']").prop("checked",false);
	}
}

function _checkedSecondMenu(menuId){
	var menusIds = $("[temp='first_menu_"+menuId+"']:checked");
	if(menusIds.length > 0){
		$("[temp='second_menu_"+menuId+"']").prop("checked",true);
	}else{
		$("[temp='second_menu_"+menuId+"']").prop("checked",false);
	}
	
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
	<form id="roleForm" action="${ctx}/func/role/do_set_menu" method="post">
	<input type="hidden" name="roleId" value="${roleId }" />
	<div class="row">
		<div class="col-lg-12 now_position">
			<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px;">&#xe62d;</i>
			&nbsp;首页&nbsp;/&nbsp;系统管理&nbsp;/&nbsp;角色管理&nbsp;/&nbsp;设置权限
		</div>
	</div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="pull-left list_name">菜单列表</div>
							<div class="pull-right">
								<a class="btn btn-default btn-xs" href="javascript:history.back(-1);"><i class="icon iconfont" style="font-family:'Arial Black', Gadget, sans-serif; font-size:12px">&#xe60c;</i>返回</a>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table
											class="table table-striped table-bordered table-hover table-minwidth">
											<thead>
												<tr>
													<th class="center">一级菜单</th>
													<th class="center">操作</th>
													<th class="center">二级菜单</th>
													<th class="center">菜单编号</th>
													<th class="center">排序</th>
												</tr>
											</thead>
											<tbody>
												<c:set var="num" value="1" />
												<c:forEach items="${menuList }" var="item" varStatus="index">
													<c:forEach items="${item.menuList }" var="menu">
														<tr>
															<c:if test="${index.index != num }">
																<td rowspan="${item.count }" style="background:#fff;">
																	<c:forEach begin="1" end="${item.count/2 }">
																		<br />
																	</c:forEach>
																	<input type="checkbox" name="menuIds" <c:if test="${menuMap[item.menuId] == roleId }">checked="checked"</c:if> temp="first_menu_${item.menuId}" onclick="_checkedSecondMenu('${item.menuId}')" value="${item.menuId}" />
																	${item.menuNa}
																</td>
																<c:set var="num" value="${index.index }" />
															</c:if>
															<td align="center">
																<input type="checkbox" name="menuIds" <c:if test="${menuMap[menu.id] == roleId }">checked="checked"</c:if> temp="second_menu_${item.menuId}" onclick="_checkedFirstMenu('${item.menuId }')" value="${menu.id }" />
															</td>
															<td>${menu.name }</td>
															<td align="center">${menu.code }</td>
															<td align="center">${menu.seq }</td>
														</tr>
													</c:forEach>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="row">
								<a href="javascript:;" onclick="_doSetMenu()" class="btn btn-sm btn-primary pull-right publish" style="width:100px; margin-left: 10px;" >
									<i class="icon iconfont" style="font-family:'Arial Black', Gadget, sans-serif; font-size:14px;">&#xe60a;</i>
									&nbsp;&nbsp;保存
								</a>
								<div class="clear"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	</form>
</body>
</html>