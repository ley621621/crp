<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>中粮风险评分系统</title>
<!--Admin Core Css-->
<link href="${ctx}/static/public/css/admin.css" rel="stylesheet"type="text/css" />
<!-- My Fonts -->
<link href="${ctx}/static/lib/iconfont/iconfont.css" rel="stylesheet" type="text/css" />
<!--Tree Menu-->
<link href="${ctx}/static/lib/tree-menu/tree.css" rel="stylesheet" type="text/css" />

<!--jquery-->
<script src="${ctx}/static/public/js/jquery-1.12.4.min.js" type="text/javascript"></script>
<script src="${ctx}/static/public/js/buttonmenu.js"></script>
<!--滚动条美化-->
<script src="${ctx}/static/lib/jQuery.nicescroll/jquery.nicescroll.js"></script>
<!-- 弹窗插件 -->
<script src="${ctx}/static/lib/layer/layer.js"></script>

<!-- 右下角弹窗 -->
<script src="${ctx}/static/lib/pop/js/lrtk.js"></script>
<link href="${ctx}/static/lib/pop/css/lrtk.css" rel="stylesheet" type="text/css" />

<script type="text/javascript">

	$(document).ready(function(){
		//判断登录用户密码是否为初始密码
		var url = "${ctx}/do_isEquals";
		$.post(url, function(data) {
			data = eval("(" + data + ")");
			if (data.success) {
				change_password();
			} 
		});
	});

	function logout() {
		window.location.href = "${ctx}/logout";
	}

	function change_password() {
		layer.open({
			type : 2,
			title : '修改密码',
			fix : false,
			shadeClose : true,
			area : [ '500px', '300px' ],
			content : "${ctx}/to_change_password"
		});
	}
</script>
</head>

<body style="overflow: hidden;">
	<div class="img_bg">
		<img src="${ctx}/static/public/images/bg.jpg" width="100%" height="100%" />
	</div>
	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="position: absolute; left: 0px; top: 0px;">
		<tbody>
			<tr>
				<td colspan="2">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						class="top_banner">
						<tbody>
							<tr>
								<td width="26%" class="logo">
									<img src="${ctx}/static/public/images/logo_r1_c1.png" />
								</td>
								<td width="74%" align="right">
									<ul class="dropdown" style="width: 160px ; text-align:right;">
										<li class="dropdown-inner">
											<a class="focus" style="background-image: url(${ctx}/static/public/images/zhanwei.png)">
												<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 18px;">&#xe65c;</i>
												<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 12px;">&#xe69e;</i>
											</a>
											<ul class="dropdownmenu" style="width:160px;">
												<li>
													<a href="javascript:;" onclick="change_password()">
														<i class="icon iconfont" style="font-family:'Arial Black', Gadget, sans-serif; font-size:18px;">&#xe620;</i>
														 修改密码
												 	</a> 
												 </li>
												<li>
													<a href="javascript:;" onclick="logout();" target="_top">
														<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 18px;">&#xe615;</i>
														退出登录
													</a>
												</li>
											</ul>
										</li>
									</ul>

								</td>
							</tr>
						</tbody>
					</table>
				</td>
			</tr>
			<tr>
				<td width="250" id="table1" valign="top">

					<div class="login-info">
						<div class="space1"></div>
						<ul>
							<li style="font-weight: 600;">${date }</li>
							<li><span class="font-orange">${user.userNa }</span></li>
						</ul>
					</div>
					<div id="content" class="content">
						<div class="subNavBox">
							<c:forEach items="${user.menus }" var="menu">
								<c:if test="${menu.parentId == 0 }">
									<div class="subNav" style="margin-top: 10px;">
										<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif">${menu.icon }</i>
										&nbsp;&nbsp;${menu.name }
									</div>
									<c:set value="${menu.id }" var="m" />
								</c:if>
								<ul class="navContent">
									<c:forEach items="${user.menus }" var="cmenu">
										<c:if test="${cmenu.parentId == m }">
											<li>
												<a href="javascript:void(0)" onclick="$('#table3').prop('src', '${ctx}${cmenu.url }');">
													<i class="icon iconfont" style="font-family: 'Arial Black', Gadget, sans-serif; font-size: 10px;">&#xe68a;</i>
													&nbsp;&nbsp;${cmenu.name }
												</a>
											</li>
										</c:if>
									</c:forEach>
								</ul>
							</c:forEach>
						</div>
					</div>
				</td>
				<td id="table2" valign="top">
					<iframe width="100%" id="table3" src="${ctx}/center" allowtransparency="true" scrolling="auto" frameborder="0"></iframe>
				</td>
			</tr>
		</tbody>
	</table>
	<!-- Frame Height Control -->
	<script>
		var winWidth = 0;
		var winHeight = 0;
		
		function findDimensions() //函数：获取尺寸
		{
			//获取窗口宽度
			if (window.innerWidth)
				winWidth = window.innerWidth;
			else if ((document.body) && (document.body.clientWidth))
				winWidth = document.body.clientWidth;
			//获取窗口高度
			if (window.innerHeight)
				winHeight = window.innerHeight;
			else if ((document.body) && (document.body.clientHeight))
				winHeight = document.body.clientHeight;
			//通过深入Document内部对body进行检测，获取窗口大小
			if (document.documentElement
					&& document.documentElement.clientHeight
					&& document.documentElement.clientWidth)
			{
				winHeight = document.documentElement.clientHeight;
				winWidth = document.documentElement.clientWidth;
			}
			//结果输出至两个文本框
			document.getElementById("table1").height = winHeight - 60;
			document.getElementById("table2").height = winHeight - 60;
			document.getElementById("table3").height = winHeight - 60;
			document.getElementById("content").style.height = winHeight - 140
					+ "px";

		}
		findDimensions();
		//调用函数，获取数值
		window.onresize = findDimensions;
	</script>
	<!--Tree Menu color-->
	<script type="text/javascript">
		$(function() {
			$(".subNav").click(
					function() {
						$(this).toggleClass("currentDd").siblings(".subNav")
								.removeClass("currentDd")
						$(this).toggleClass("currentDt").siblings(".subNav")
								.removeClass("currentDt")

						// 修改数字控制速度， slideUp(500)控制卷起速度
						$(this).next(".navContent").slideToggle(500).siblings(
								".navContent").slideUp(500);
					})
		});

		$(".navContent a").click(function() {
			$('.navContent li a').css({
				'font-weight' : 'normal'
			});

			$(this).css({
				'font-weight' : 'bold'
			});
		});
	</script>
	<script type="text/javascript">
		$('.content').niceScroll({
			cursorcolor : "#ccc",//#CC0071 光标颜色
			cursoropacitymax : 1, //改变不透明度非常光标处于活动状态（scrollabar“可见”状态），范围从1到0
			touchbehavior : false, //使光标拖动滚动像在台式电脑触摸设备
			cursorwidth : "5px", //像素光标的宽度
			cursorborder : "0", // 	游标边框css定义
			cursorborderradius : "5px",//以像素为光标边界半径
			autohidemode : true, //是否隐藏滚动条
			hwacceleration : true,
			smoothscroll : true,
			scrollspeed : 100,
		});
	</script>
</body>
</html>
