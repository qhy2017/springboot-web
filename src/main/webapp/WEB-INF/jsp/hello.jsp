<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.*"%>
<%@page import="com.alibaba.fastjson.*" %>
<%
 String hello = request.getAttribute("hello") == null ? "" : request.getAttribute("hello").toString();
List  list = (List)request.getAttribute("list");
  JSONObject json =  session.getAttribute("name") == null ? new JSONObject() : (JSONObject)session.getAttribute("name");
 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
hello world <h1><%=hello %></h1>
<c:out value="${hello }"></c:out>
<hr>
<c:forEach items="${list}" var="item">
	<c:out value="${item}"></c:out>
</c:forEach>
<c:forEach items="${map}" var="item">
<c:out value="${item}"></c:out>
	${item.key} ${item.value}
</c:forEach>
<hr>输出集合
<%
 for(int i = 0;i<list.size();i++){
%>
  <% if(i==0){ %>
   <font color="red"><%=list.get(i) %></font>  
  <%}%>
  
  <% if(i==1){ %>
   <font color="green"><%=list.get(i) %></font>  
  <%}%>
  <% if(i==2){ %>
   <font color="pink"><%=list.get(i) %></font>  
  <%}%>

<%} %>
<hr>session
<%=json.get("name") %>

<%=JSON.toJSONString(request.getAttribute("session")) %>
</body>
</html>