<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		//获取当前项目的路径
		String path=request.getContextPath();
		//定义当前项目在服务器的基准路径
		String basePath=request.getScheme()+
		"://"+request.getServerName()+":"
				+request.getServerPort()+path+"/";
%>
<!-- 定义当前页面所有html标签路径的基准值 -->
<!-- 将所有html的url 定义成服务器绝对路径 -->
<base href="<%=basePath%>">