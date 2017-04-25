<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include.jsp"%>
<div class="hor-menu ">
	<ul class="nav navbar-nav">
		<li><a href="<c:url value="/admin/home" />">Home</a></li>
		<li><a href="<c:url value="/admin/register" />">User Register</a></li>
		<li><a href="<c:url value="/admin/users" />">User List</a></li>
		<li><a href="<c:url value="/admin/students" />">Student List</a></li>
		<li><a href="<c:url value="/admin/assign" />">Assign</a></li>
	</ul>
</div>