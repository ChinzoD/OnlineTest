<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="content">
<form:form modelAttribute="categoryDto" method="POST" action="setcategories">
	<c:forEach items="categoryDto.categories" var="cats">
		<c:out value="cats.name"/><br/>
		<c:forEach items="cats.subcategories" var="subcats">
			<form:checkbox path="selectedSubCategories" value="${subcats.name}"/>${subcats.name}<br/>
		</c:forEach><hr/>
	</c:forEach>
	<button type="submit">Submit</button>
</form:form>
</div>

</body>
</html>