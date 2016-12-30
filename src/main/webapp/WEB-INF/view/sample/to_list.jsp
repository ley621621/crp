<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<table border="1" cellpadding="10">

<tr>
	<th>序号</th>
	<th>名称</th>
	<th>年龄</th>
	<th>创建时间</th>
</tr>

<c:forEach items="${pageInfo.list }" var="item" varStatus="index">
	<tr>
		<td>${index.index+1 }</td>
		<td>${item.name }</td>
		<td>${item.age }</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${item.createTime }"/></td>
	</tr>
</c:forEach>

</table>