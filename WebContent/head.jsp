<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="www.web1.javaBean.*" %>

<%User user = (User)request.getSession().getAttribute("user");%>
      	<ul class="top">
		  <li  ><a href="index.jsp" >首页</a></li>
		  <li  ><a href="usrUI.jsp" >个人主页</a></li>
		  <li  ><a href="content.jsp" >评论</a></li>
		  <li  ><a href="upload.jsp" >草稿</a></li>
		  <li  ><a href="findPswd.jsp" >找回密码</a></li>
		  <li  style="float:right">
		  <a class="active" href="login.jsp">
		  <c:if test="${user==null}" var="jugle" scope="session">登录</c:if>
		  <c:if test="${user!=null}" var="jugle" scope="session"><%=user.getNickname() %></c:if>
		  </a></li>
		</ul>
