<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><fmt:message key="system.menu.addMenu" /></title>
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
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<form id="addMenuForm" action="${ctx}/func/menu/do_add_menu" method="post">
					<input type="hidden" name="pkParentMenu" value="${pId }">
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
												<label class="col-lg-2 form_name"><span class="red">*</span>菜单名称&nbsp;&nbsp;</label>
												<div class="col-lg-10">
													<input type="text" class="form-control" name="name" />
												</div>
												<div class="clear"></div>
											</div>
											<div class="row form-group">
												<label class="col-lg-2 form_name"><span class="red">*</span>菜单编号&nbsp;&nbsp;</label>
												<div class="col-lg-10">
													<input type="text" class="form-control" name="code" />
													<input type="hidden" class="form-control" name="state" value="0" />
												</div>
												<div class="clear"></div>
											</div>

											<div class="row form-group">
												<label class="col-lg-2 form_name"><span class="red">*</span>菜单地址&nbsp;&nbsp;</label>
												<div class="col-lg-10">
													<input type="text" class="form-control" name="url" />
												</div>
												<div class="clear"></div>
											</div>
											<div class="row form-group">
												<label class="col-lg-2 form_name"><span class="red">*</span>排序值&nbsp;&nbsp;</label>
												<div class="col-lg-10">
													<input type="text" class="form-control" name="seq" />
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
									<div class=""></div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>