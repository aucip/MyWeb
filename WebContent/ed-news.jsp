<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style>
			#u{list-style: none;background: silver;width: 600px;margin: 0px;padding: 0px;}
			#u li{background: slategray;margin: 1px;width: inherit;height: 30px;line-height: 30px;text-align: center;}
		</style>
	</head>
	<body>
		<%@include file="ed-head.jsp"%>
		<ul id="u">
			<c:forEach items="${people}" var="c" varStatus="st">
				<li><a href="ed-userUI?ID=${c.getID() }">${c.getNickname() }</a>的消息<a href="ed-newsFrame?id=${c.getID() }">点击进入对话框</a></li>
			</c:forEach>
		</ul>
	</body>
</html>