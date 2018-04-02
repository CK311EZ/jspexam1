<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<%@ include file="commons/path.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="student" method="post">
			<p>学生姓名:<input name="sname" value="${maps['sname']==null?'':maps['sname'] }"></p>
			<p>班级编号:<input name="cid"></p>
			<p>起始日期:<input type="date" name="sdate"></p>
			<p>结束日期:<input type="date" name="edate"></p>
			<p><input type="submit" value="查询">&nbsp;
			<input type="reset" value="重置"></p>
		</form>
	</div>
	<table border="1">
		<tr>
			<th>学生编号</th>
			<th>学生姓名</th>
			<th>学生性别</th>
			<th>出生日期</th>
			<th>班级编号</th>
			<th>班级名称</th>
		</tr>
		<c:forEach items="${list }" var="student">
			<tr>
			<td>${student.sid }</td>
			<td>${student.sname }</td>
			<td>${student.ssex }</td>
			<td>${student.sbirthday }</td>
			<td>${student.sclass.cid }</td>
			<td>${student.sclass.cname }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>