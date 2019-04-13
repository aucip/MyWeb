<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/head.css" rel="stylesheet"/>
<style>
	body{background:url("pic/黄昏城市.jpg");background-size:1400px 700px;padding: 0;margin: 0;}
	ul {border:none;width:1350px;list-style-type: none;margin: 0;padding: 0;overflow: hidden;background-color: #333;}
	li { float: left;}
	li a {display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;}
	li a:hover:not(.active) {background-color: #111;}
	.active {background-color: #4CAF50;}
	.login{border-radius:5px;margin-top:50px;margin-left:700px;margin-top:100px;float:left;width: 500px;height: 400px;background:rgba(255,255,255,0.5);}
	.login1{margin-top: 80px;width: 260px;height: 30px;}
	.login2{margin-top: 40px;width: 260px;height: 30px;}
	.btn{font-size: 16px;background: #F5DEB3;border-radius: 3px; border: none;margin-left: 40px;margin-top: 10px;}
	.btn:hover{background: #F5DEB3;color: saddlebrown;}
</style>
<title>登陆</title>
</head>
<body>
	<div class="login">
		<form action="login" method="post">
			
			<span style="font-size: 150%;margin-left: 80px;">邮箱:</span>
			<input id="account" type="text" name="email" placeholder="请输入邮箱" class="login1"/><br>
			<span style="font-size: 150%;margin-left: 80px;">密码:</span>
			<input id="pswd" type="password" name="password" placeholder="请输入密码" class="login2"/><br>
			
			<input class="btn" type="submit" value="登录" name="login" style="font-size:120%;width:120px;height:50px;float:left; margin-left: 80px;margin-top: 50px;"/>
			<a href="rigister.jsp" class="btn" style="text-align:center;text-decoration:none;font-size:120%;width:120px;height:50px;float:right; margin-right: 80px;margin-top: 50px;">注册</a>
		</form>
		<div style="margin-top: 20px;float:right;margin-right: 50px;">
			<a href="findPswd.jsp">找回密码</a>
		</div>
	</div>
	
</body>
</html>