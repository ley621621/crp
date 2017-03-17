<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="system.menu" /></title>
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
<!-- 分页插件 -->
<script src="${ctx}/static/lib/laypage/laypage.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//搜索
	$('#menu_search').on('click',function(){
		 $("input[name='pageNum']").val(1);
		$("#menuForm").submit();
	});
		
	// 初始化分页
	laypage({
		  cont: $("#div_page"), //容器。值支持id名、原生dom对象，jquery对象,
		  pages: '${pageInfo.pages}', //总页数
		  skin: 'yahei', //加载内置皮肤，也可以直接赋值16进制颜色值，如:#c00
		  groups: 7, //连续显示分页数
		  first: '首页',
	      last: '尾页',
	      prev:'上一页',
	      next:'下一页',
		  curr: function(){
			  return ${pageInfo.pageNum};
		  }(), 
	      jump: function(e, first){ //触发分页后的回调
	    	  if(!first){ //一定要加此判断，否则初始时会无限刷新
	          	  $("input[name='pageNum']").val(e.curr);
	          	  $("#menuForm").submit();
	      	  }
		  }
	});
	
});

function _toUpdateMenu(menuId) {
	layer.open({
		type: 2,
		title: '编辑',
		fix: false,
		shadeClose: true,
		area: ['550px', '350px'],
		content: "${ctx }/func/menu/to_update_menu?menuId=" + menuId,
	});
}

function _toAddMenu() {
	location.href = "${ctx }/func/menu/to_menu";
}


//更新状态，启用/禁用
function updateState(state,menuId){
	var confirm = "";
	if(state == 0){
		confirm = '您是否启用此菜单?';
	}
	if(state == 1){
		confirm = '您是否禁用此菜单';
	}
	layer.confirm(confirm, {icon: 3, btn: ['是', '否'],title:'提示信息'}, function(index){
	var url = '${ctx}/func/menu/update_state';
	param = {
		"state":state,
		"id":menuId
	};
	$.post(url, param, function(data){
		data = eval("(" + data + ")");
		if(data.success) {
			layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示信息'}, function(index){
			layer.close(index);
			window.location.reload();
			});
		} else {
			layer.alert(data.msg, {icon: 6, btn:['确定'], title:'提示信息'});
		}
	});
	});
}
//删除菜单
function _doDeleteMenu(menu_id){
	layer.confirm("是否删除此数据?",{icon: 6,title:'提示信息'},function(index){
		var url = '${ctx}/func/menu/do_delete_menu';
		param = {"id" : menu_id};
		$.post(url, param, function(data){
			data = eval("(" + data + ")");
			if(data.success){
				layer.alert(data.msg,{title:'提示信息'},function(index){
					layer.close(index);
					location.href = '${ctx}/func/menu/to_menu_list';
				});
			}else{
				layer.alert(data.msg,{title:'提示信息'});
			}
		});
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
	<div class="row">
		<div class="col-lg-12 now_position">
			<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px;">&#xe62d;</i>
			&nbsp;首页&nbsp;/&nbsp;系统管理&nbsp;/&nbsp;菜单管理
		</div>
	</div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="space1"></div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-body" style="padding-bottom: 0px;">
						<div class="row">
							<form id="menuForm" action="${ctx }/func/menu/to_menu_list" method="post">
								<input type="hidden" name="pageNum" value="${pageInfo.pageNum }" />
								<div class="col-lg-12">
									<div class="row form-group">
										<label class="col-lg-1 form_name">名称&nbsp;&nbsp;</label>
										<div class="col-lg-2">
											<input type="text" class="form-control" name="name" value="${vo.name}" />
										</div>
										<label class="col-lg-1 form_name">编号&nbsp;&nbsp;</label>
										<div class="col-lg-2">
											<input type="text" class="form-control" name="code" value="${vo.code}" />
										</div>
										<label class="col-lg-1 form_name">显示条数&nbsp;&nbsp;</label>
										<div class="col-lg-2">
											<select class="form-control" id="pageSize" name="pageSize">
												<option <c:if test="${vo.pageSize == 10}"> selected="selected"</c:if> value="10">10</option>
												<option <c:if test="${vo.pageSize == 20}"> selected="selected"</c:if> value="20">20</option>
												<option <c:if test="${vo.pageSize == 50}"> selected="selected"</c:if> value="50">50</option>
												<option <c:if test="${vo.pageSize == 100}"> selected="selected"</c:if> value="100">100</option>
											</select>
										</div>
										<label class="col-lg-1 form_name"></label>
										<div class="col-lg-2">
											<a href="javascript:;" id="menu_search" class="btn btn-primary btn-xs" style="width: 80%;">
												<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px">&#xe611;</i>
												查询
											</a>
										</div>
										<div class="clear"></div>
									</div>
									<div class="row form-group"></div>
								</div>
								<div class="clear"></div>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">
							<div class="pull-left list_name">菜单列表</div>
							<div class="pull-right">
								<a href="javascript:;" onclick="_toAddMenu()" class="btn btn-success btn-xs">
									<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 14px">&#xe612;</i>
									新增
								</a>
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover table-minwidth">
											<thead>
												<tr>
													<th class="center">序号</th>
													<th class="center">名称</th>
													<th class="center">编号</th>
													<th class="center">地址</th>
													<th class="center">是否启用</th>
													<th class="center">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${pageInfo.list }" var="menu" varStatus="index">
													<tr>
														<td align="center">${index.index+1 }</td>
														<td>${menu.name }</td>
														<td align="center">${menu.code }</td>
														<td>${menu.url }</td>
														<td align="center">
															<c:if test="${menu.state eq '0' }">
																启用
															</c:if>
															<c:if test="${menu.state eq '1' }">
																禁用
															</c:if>
														</td>
														<td align="center">
															<a href="javascript:;" onclick="_toUpdateMenu(${menu.id})" class="link2 cu" title="编辑">
																编辑
															</a>
															&nbsp;
															<a href="javascript:;" onclick="_doDeleteMenu(${menu.id})" class="link2 cu" title="删除">
																删除
															</a>
															<c:if test="${menu.state eq '1'}">
																&nbsp;
																<a href="javascript:;" onclick="updateState(0,'${menu.id }')" class="link2 cu">
																	启用
																</a>
                   											</c:if>
                   											<c:if test="${menu.state eq '0'}">
                   												&nbsp;
																<a href="javascript:;" onclick="updateState(1,'${menu.id }')" class="link2 cu">
																	禁用
																</a>
                      										</c:if>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
								<div class="clear"></div>
							</div>
							<div class="row">
								<div class="col-lg-12">
									<div align="center" class="page font1">
										<table width="100%" cellspacing="0" cellpadding="0" border="0">
											<tbody>
												<tr>
													<td width="26%" align="left">&nbsp;</td>
													<td width="74%" align="right" class="font1">
														<div id="div_page"></div>
													</td>

												</tr>
											</tbody>
										</table>
									</div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>