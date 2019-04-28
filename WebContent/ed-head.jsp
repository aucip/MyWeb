<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="www.web1.javaBean.*" %>
<jsp:useBean id="user" scope="session" class="www.web1.javaBean.User"></jsp:useBean>
      	<ul class="top">
		  	<li  ><a href="ed-index" >看文章</a></li>
		  	<c:if test="${user!=null and user.getID() != 0}" var="jugle" scope="session">
		  		<li  ><a href="ed-person" >个人主页</a></li>
		  		<li  ><a href="#" >我的文章</a></li>
		  		<li  ><a href="#" >消息</a></li>
		  		<li  ><a href="ed-upload" >草稿</a></li>
		  	</c:if>
		  	<li>
		  		<c:if test="${user==null or user.getID() == 0}" var="jugle" scope="session"><a class="active" href="login.jsp">登录</a></c:if>
		  		<c:if test="${user!=null and user.getID() != 0}" var="jugle" scope="session">
					${user.getNickname() }				
		  			<li><a href="loginout">注销</a></li>
		  		</c:if>
			</li>		  
		</ul>
