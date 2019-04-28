<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/head.css" rel="stylesheet"/>
<style>
	body{background:url("pic/蓝色城市.jpg");background-size:1000px 700px;width: 1300px;padding: 0;margin: 0;}
	ul {position:fixed;width:1350px;list-style-type: none;margin: 0;padding: 0;overflow: hidden;background-color: #333;}
	li { float: left;}
	li a {display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;}
	li a:hover:not(.active) {background-color: #111;}
	.active {background-color: #4CAF50;}
	.find {border-radius:5px;margin-top:50px;margin-left:480px;margin-top:150px;float:left;width: 400px;height: 300px;background:rgba(255,255,255,0.5);}
	.find1 {margin-top: 80px;}
	.find2 {margin-top: 20px;}
</style>
<title>找回密码</title>
</head>
<body>
	<%@include file="ed-head.jsp"%>
	<div class="find">
		<form action="">
			<div class="find1">
				<span style="font-size: 150%;margin-left: 40px;">申述邮箱:</span>
				<input type="text" name="account" style="width: 200px;height: 30px;"/><br />		
			</div>
			
			<div class="find2">
				<span style="font-size: 150%;margin-left: 40px;">账号邮箱:</span>
				<input type="text" name="email" style="width: 200px;height: 30px;"/><br />	
			</div>
			
			<input type="submit" name="subEmail" value="提交" style="font-size:120%;width:100px;height:40px;float: right; margin-right: 40px;margin-top: 20px;" /><br />
		</form>
	</div>
	
</body>
</html>