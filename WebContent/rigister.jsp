<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	body{background:url("pic/紫色城市.jpg");background-size:1400px 700px;padding: 0;margin: 0;}
	ul {border:none;width:1350px;list-style-type: none;margin: 0;padding: 0;overflow: hidden;background-color: #333;}
	li { float: left;}
	li a {display: block; color: white; text-align: center; padding: 14px 16px; text-decoration: none;}
	li a:hover:not(.active) {background-color: #111;}
	form{text-align: center;}
	.active {background-color: #4CAF50;}
	.rigister {border-radius:5px;margin-left:450px;margin-top:90px;float:left;width: 500px;height: 400px;background:rgba(255,255,255,0.5);}
	.rigister>form span {font-size: 120%;}
	.textinput {margin-top: 30px;width: 230px;height: 30px;}
	.btn1{font-size: 20px;background: #F5DEB3;border-radius: 3px; border: none;margin-left: 70px;margin-top: 20px;width:120px;height: 50px;}
	.btn2{font-size: 20px;background: #F5DEB3;border-radius: 3px; border: none;margin-left: 100px;margin-top: 20px;width:120px;height: 50px;}
	.btn:hover{background: #F5DEB3;color: saddlebrown;}
</style>
<title>用户注册</title>
</head>
<body>
	<%@include file="ed-head.jsp"%>
	<div class="rigister">
		<form action="addUser" method="post">
			<span>昵称:</span><input class="f" type="text" name="nickname" placeholder=""/><br>
			<span>密码:</span><input class="f" type="password" name="password" placeholder="数字、英文、符号"/><br>
			<span>重复密码:</span><input class="f" type="password" name="password2" placeholder="数字、英文、符号"/><br>
			<span>年龄:</span><input class="f" type="text" name="age" placeholder=""/><br>
			<span>职业:</span><input class="f" type="text" name="profession" placeholder=""/><br>
			<span>电话:</span><input class="f" type="text" name="tele" placeholder=""/><br>
			<span>邮箱:</span><input class="f" type="text" name="email" placeholder="example@163.com"/><br>
			<span>爱好:</span><input class="f" type="text" name="habby" placeholder=""/><br>
			<span>个性签名:</span><input class="f" type="text" name="autograph" placeholder=""/><br>
			<input class="btn1" type="submit" value="确  定" name="login"/>
			<input class="btn2" type="button" value="取  消" name="register" onclick="window.location.href='register'"/>
		</form>
	</div>
</body>
</html>