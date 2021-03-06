<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>组织结构</title>
<!-- Css for boot -->
<link href="${ctx}/static/public/css/boot.css" rel="stylesheet" type="text/css" />
<!--Admin Core Css-->
<link href="${ctx}/static/public/css/admin.css" rel="stylesheet" type="text/css" />
<!-- My Fonts -->
<link href="${ctx}/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>


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
			&nbsp;首页&nbsp;/参数管理/&nbsp;组织结构
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
							<div class="pull-left list_name">组织结构</div>
							<div class="pull-right">
							</div>
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-lg-12">
									<div class="table-responsive">
										<table class="table table-striped table-bordered table-hover table-minwidth">
											<thead>
												<tr>
													<th class="center" rowspan="2">
														序号
													</th>
													<th class="center" rowspan="2">
														名称
													</th>
													<th class="center" rowspan="2">
														编号
													</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${items }" var="item" varStatus="index">
													<tr>
														<td align="center">${index.index+1 }</td>
														<td align="left">${item.name }</td>
														<td align="center">${item.code }</td>
													</tr>
												</c:forEach>
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